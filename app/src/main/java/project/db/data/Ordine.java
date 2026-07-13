package project.db.data;
import java.sql.Date;
import java.sql.Time;

public class Ordine {

    private Time orarioCreazione;
    private float prezzoTotale;
    private Time orarioConsegnato;
    private Time orarioConsegna;
    private Time orarioEliminazione;
    private String CodiceOrdine;
    private String CodiceUtente;
    private Date dataCreazione;
    private final String queryOrdine = "INSERT INTO Ordine (orarioCreazione, orarioConsegna, orarioConsegnato, orarioEliminazione, CodiceOrdine, CodiceUtente, prezzoTotale, dataCreazione) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public Ordine(Time orarioCreazione, Time orarioConsegna, Time orarioConsegnato, Time orarioEliminazione, String CodiceOrdine,
        String CodiceUtente, float prezzoTotale, Date dataCreazione){

        this.orarioCreazione = orarioCreazione;
        this.orarioConsegna = orarioConsegna;
        this.orarioConsegnato = orarioConsegnato;
        this.orarioEliminazione = orarioEliminazione;
        this.CodiceOrdine = CodiceOrdine;
        this.CodiceUtente = CodiceUtente;
        this.prezzoTotale = prezzoTotale;
        this.dataCreazione = dataCreazione;
    }


    public static final class DAO {

    }

}
