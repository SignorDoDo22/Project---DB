package project.db.model;

import java.sql.Date;
import java.sql.Time;

public class Ordine {

    private float prezzoTotale;
    private Date dataCreazione;
    private Time orarioConsegna;
    private Time orarioPreparazione;
    private Time orarioEliminazione;

    public Ordine(float prezzoTotale, Date dataCreazione, Time orarioConsegna, Time orarioPreparazione, Time orarioEliminazione) {
        this.prezzoTotale = prezzoTotale;
        this.dataCreazione = dataCreazione;
        this.orarioConsegna = orarioConsegna;
        this.orarioPreparazione = orarioPreparazione;
        this.orarioEliminazione = orarioEliminazione;
    }


    public static final class DAO {

    }



}
