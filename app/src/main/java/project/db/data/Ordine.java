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
    private Time inPreparazione = null;
    private Time inConsegna = null;
    private Time consegnato = null;
    private String ind_via;
    private Boolean pronto = false;
    private String ind_Città;
    private String ind_Civico;
    private String codice_Utente;

    private String codice_Ordine;


    public Ordine(final Date dataCreazione, final String ind_via, final String ind_Città, final String ind_Civico,
        final String codice_Utente, final String codice_Ordine){

        this.dataCreazione = dataCreazione;

        this.ind_Città = ind_Città;
        this.ind_via = ind_via;
        this.ind_Civico = ind_Civico;

        this.codice_Ordine = codice_Ordine;
        this.codice_Utente = codice_Utente;
    }

    public void setInPreparazione(Time inPreparazione) {
        this.inPreparazione = inPreparazione;
    }

    public void setInConsegna(Time inConsegna) {
        this.inConsegna = inConsegna;
    }

    public void setConsegnato(Time consegnato) {
        this.consegnato = consegnato;
    }

    public void setPronto(Boolean pronto) {
        this.pronto = pronto;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public Time getInPreparazione() {
        return inPreparazione;
    }

    public Time getInConsegna() {
        return inConsegna;
    }

    public Time getConsegnato() {
        return consegnato;
    }


    public Boolean getPronto() {
        return pronto;
    }

    public String getIndVia() {
        return ind_via;
    }

    public String getIndCitta() {
        return ind_Città;
    }

    public String getIndCivico() {
        return ind_Civico;
    }

    public String getCodiceUtente() {
        return codice_Utente;
    }

    public String getCodiceOrdine() {
        return codice_Ordine;
    }

    public static class DAO {

        public static List<Ordine> list(Connection connection){

            List<Ordine> listOrdine = new ArrayList<>();

            try( var preparedStatement = DAOUtils.prepare(connection, Queries.MOSTRA_ORDINI.get());
                ResultSet result = preparedStatement.executeQuery()) {

                while (result.next()) {

                    var dataCreazione = result.getDate("DataCreazione");
                    var consegnato = result.getTime("Consegnato");
                    var consegnatoBool = result.getBoolean("Consegnato_Bool");
                    var inConsegna = result.getTime("In_Consegna");
                    var inPreparazione = result.getTime("In_Preparazione");
                    var indVia = result.getString("Ind_Via");
                    var indCittà = result.getString("Ind_Città");
                    var indCivico = result.getString("Ind_Civico");
                    var codiceUtente = result.getString("Codice_Utente");
                    var codiceordine = result.getString("Codice_Ordine");
                    Ordine ordine = new Ordine(dataCreazione, indVia, indCittà, indCivico, codiceUtente, codiceordine);
                    ordine.setInPreparazione(inPreparazione);
                    ordine.setInConsegna(inConsegna);
                    ordine.setConsegnato(consegnato);
                    ordine.setPronto(consegnatoBool);
                    listOrdine.add(ordine);
                }

            } catch (Exception e) {
                throw new DAOException("Errore nel caricamento degli ordini",e);
            }
            return listOrdine;
        }

        public static List<Ordine> OrdearReady(Connection connection){
            List<Ordine> ordiniPronti = new ArrayList<>();

            try(var preparedStatement = DAOUtils.prepare(connection, Queries.MOSTRA_ORDINI_PRONTI.get());
                ResultSet result = preparedStatement.executeQuery()) {

                while (result.next()) {

                    var dataCreazione = result.getDate("DataCreazione");
                    var consegnato = result.getTime("OrarioConsegnato");
                    var consegnatoBool = result.getBoolean("Pronto");
                    var inConsegna = result.getTime("OrarioInConsegna");
                    var inPreparazione = result.getTime("OrarioPreparazione");
                    var indVia = result.getString("Ind_Via");
                    var indCittà = result.getString("Ind_Citta");
                    var indCivico = result.getString("Ind_Civico");
                    var codiceUtente = result.getString("Codice_Utente");
                    var codiceordine = result.getString("Codice_Ordine");
                    Ordine ordine = new Ordine(dataCreazione, indVia, indCittà, indCivico, codiceUtente, codiceordine);
                    ordine.setInPreparazione(inPreparazione);
                    ordine.setInConsegna(inConsegna);
                    ordine.setConsegnato(consegnato);
                    ordine.setPronto(consegnatoBool);
                    System.out.println("Ordine pronto: " + codiceordine + " per l'utente: " + codiceUtente);

                    ordiniPronti.add(ordine);
                }

            } catch (Exception e) {
                throw new DAOException("Errore nel caricamento degli ordini pronti", e);
            }
            return ordiniPronti;
        }



    }

}
