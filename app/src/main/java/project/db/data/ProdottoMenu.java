package project.db.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.SQLException;
import project.db.Queries;
import project.db.controller.DAOException;
import project.db.controller.DAOUtils;
public class ProdottoMenu extends Prodotto {

    private String codiceMenu;

    public ProdottoMenu(final boolean disponibile, final String codice_prodotto,
                     final String descrizioneProdotto, final float prezzoOriginario,
                     final String nome_prodotto, final String singolo, final String menu) {
        super(disponibile, codice_prodotto, descrizioneProdotto, prezzoOriginario, nome_prodotto, singolo, menu);
        this.codiceMenu = codice_prodotto;
    }

    public String getCodiceMenu() {
        return codiceMenu;
    }

    public static class DAO {

        public static boolean insert(final Connection connection, final String codiceMenu){
            try (var preparedStatement = DAOUtils.prepare(connection, Queries.INSERIRE_MENU.get(), codiceMenu)) {
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }


        public static Map<String, List<String>> getIngredienti(final Connection connection, final String codiceMenu) {

            List<String> listaIngredienti = new ArrayList<>();
            Map<String, String> listaProdotti = new HashMap<>();
            Map<String, List<String>> ingredientiMenu = new HashMap<>();

            try( var preparedStatement = DAOUtils.prepare(connection, Queries.MOSTRA_COMPONENTI_MENU_CATALOGO.get(), codiceMenu);
                 var resultSet = preparedStatement.executeQuery();){
                while (resultSet.next()) {
                    var codice_prodotto = resultSet.getString("Codice_Prodotto");
                    var nomeProdotto = resultSet.getString("Nome_Prodotto");
                    listaProdotti.put(codice_prodotto, nomeProdotto);
                }

                for (String codiceProdotto : listaProdotti.keySet()) {
                    List<String> ingredientiProdotto = Prodotto.DAO.getIngredienti(connection, codiceProdotto);
                    ingredientiMenu.put(listaProdotti.get(codiceProdotto), ingredientiProdotto);
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
            return ingredientiMenu;
        }

        public static void addProdottoToMenu(final Connection connection, final String codiceMenu, final String codiceProdotto, final int quantita) {
            try (var preparedStatement = DAOUtils.prepare(connection, Queries.INSERIRE_COMPOSTO_MENU.get(), codiceMenu, codiceProdotto, quantita)) {
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }
}
