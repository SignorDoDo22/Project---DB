package project.db.data;

import project.db.Queries;
import project.db.controller.DAOException;
import project.db.controller.DAOUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class ProdottoSingolo extends Prodotto {

    private String codiceIngrediente;

    public ProdottoSingolo(final boolean disponibile, final String codice_prodotto,
                     final String descrizioneProdotto, final float prezzoOriginario,
                     final String nome_prodotto, final String singolo, final String menu) {
        super(disponibile, codice_prodotto, descrizioneProdotto, prezzoOriginario, nome_prodotto, singolo, menu);
        this.codiceIngrediente = codice_prodotto;
    }

    public String getCodiceIngrediente() {
        return codiceIngrediente;
    }


    public static class DAO {

        public static boolean insert(final Connection connection, final String Codice_Prodotto){
            try (var preparedStatement = DAOUtils.prepare(connection, Queries.INSERIRE_SINGOLO.get(), Codice_Prodotto)) {
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException(e);
            }

            return true;
        }

    }

}
