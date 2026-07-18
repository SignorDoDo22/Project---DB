package project.db.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.db.Queries;
import project.db.controller.DAOException;
import project.db.controller.DAOUtils;

public class Prodotto {

    private boolean disponibile;
    private String codice_prodotto;
    private int numeroVolteOrdinato;
    private String descrizioneProdotto;
    private String nome_prodotto;
    private float prezzoOriginario;
    private String singolo;
    private String menu;

    public Prodotto(final boolean disponibile, final String codice_prodotto, final int numeroVolteOrdinato,
                     final String descrizioneProdotto, final float prezzoOriginario,
                     final String nome_prodotto, final String singolo, final String menu) {
        this.codice_prodotto = codice_prodotto;
        this.nome_prodotto = nome_prodotto;
        this.descrizioneProdotto = descrizioneProdotto;
        this.prezzoOriginario = prezzoOriginario;
        this.numeroVolteOrdinato = numeroVolteOrdinato;
        this.disponibile = disponibile;
        this.singolo = singolo;
        this.menu = menu;
    }


    public boolean isDisponibile() { return disponibile; }
    public String getCodiceProdotto() { return codice_prodotto; }
    public int getNumeroVolteOrdinato() { return numeroVolteOrdinato; }
    public String getDescrizioneProdotto() { return descrizioneProdotto; }
    public String getNomeProdotto() { return nome_prodotto; }
    public float getPrezzoOriginario() { return prezzoOriginario; }
    public String getSingolo() { return singolo; }
    public String getMenu() { return menu; }

    // Metodi di comodo, utili in View/Controller senza dover controllare null a mano
    public boolean isSingolo() { return singolo != null; }
    public boolean isMenu() { return menu != null; }


    public static class DAO {

        public static List<Prodotto> list(final Connection connection) {
            List<Prodotto> catalogo = new ArrayList<>();

            try (
                var statement = DAOUtils.prepare(connection, Queries.MOSTRA_PRODOTTI.get());
                var resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    var disponibileTesto = resultSet.getString("Disponibile");
                    var disponibile = "S".equals(disponibileTesto);

                    var nome_prodotto = resultSet.getString("Nome_Prodotto");
                    var descrizione_prodotto = resultSet.getString("Descrizione_Prodotto");
                    var numeroVolteOrdinato = resultSet.getInt("NumeroVolteOrdinato");
                    var prezzo_Originario = resultSet.getFloat("Prezzo_originario");
                    var codice_prodotto = resultSet.getString("Codice_Prodotto");
                    var singolo = resultSet.getString("Singolo");
                    var menu = resultSet.getString("Menu");

                    catalogo.add(new Prodotto(disponibile, codice_prodotto, numeroVolteOrdinato,
                                            descrizione_prodotto, prezzo_Originario, nome_prodotto,
                                            singolo, menu));
                }

            } catch (SQLException e) {
                throw new DAOException("Errore durante il recupero dei prodotti", e);
            }

            return catalogo;
        }

        public static boolean check(final Connection connection, final String Codice_Prodotto) {
            try (var preparedStatement = DAOUtils.prepare(connection, Queries.CERCA_PRODOTTO_PER_CODICE.get())) {
                preparedStatement.setString(1, Codice_Prodotto);
                try (var resultSet = preparedStatement.executeQuery()){
                    return resultSet.next();
                }
            } catch (Exception e) {
                throw new DAOException("Errore durante la verifica di esistenza del prodotto",e);
            }
        }

        public static boolean insert(){
            return false;
        }


    }
}