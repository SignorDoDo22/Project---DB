package project.db.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import project.db.Queries;
import project.db.controller.DAOException;
import project.db.controller.DAOUtils;

public class Ordine {

    private Date dataCreazione;
    private float Prezzo_totale;
    private Time inConsegna = Time.valueOf("13:45:00");
    private Time consegnato = Time.valueOf("13:45:00");
    private String ind_via;
    private String ind_Città;
    private String ind_Civico;
    private String codice_Utente;
    private String codice_Ordine;


    public Ordine(final Date dataCreazione, final float Prezzo_totale, final String ind_via, final String ind_Città, final String ind_Civico,
        final String codice_Utente, final String codice_Ordine){

        this.Prezzo_totale = Prezzo_totale;
        this.dataCreazione = dataCreazione;

        this.ind_Città = ind_Città;
        this.ind_via = ind_via;
        this.ind_Civico = ind_Civico;

        this.codice_Ordine = codice_Ordine;
        this.codice_Utente = codice_Utente;

    }


    public static class DAO {

        public static List<Ordine> list(Connection connection){

            List<Ordine> listOrdine = new ArrayList<>();

            try( var preparedStatement = DAOUtils.prepare(connection, Queries.MOSTRA_ORDINI.get());
                ResultSet result = preparedStatement.executeQuery()) {

                while (result.next()) {

                    var dataCreazione = result.getDate("Data_Creazione");
                    var prezzoTotale = result.getFloat("Prezzo_Totale");
                    var consegnato = result.getTime("Consegnato");
                    var inConsegna = result.getTime("In_Consegna");
                    var indVia = result.getString("Ind_Via");
                    var indCittà = result.getString("Ind_Città");
                    var indCivico = result.getString("Ind_Civico");
                    var codiceUtente = result.getString("Codice_Utente");
                    var codiceordine = result.getString("Codice_Ordine");
                    Ordine ordine = new Ordine(dataCreazione, prezzoTotale, indVia, indCittà, indCivico, codiceUtente, codiceordine);
                    ordine.inConsegna = inConsegna;
                    ordine.consegnato = consegnato;
                    listOrdine.add(ordine);
                }

            } catch (Exception e) {
                throw new DAOException("Errore nel caricamento degli ordini",e);
            }
            return listOrdine;
        }



    }

}
