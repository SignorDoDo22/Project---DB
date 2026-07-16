package project.db.controller;

/**
 * Eccezione "tecnica": avvolge una SQLException (o altro errore di accesso
 * ai dati) in qualcosa di piu' leggibile e specifico del dominio.
 *
 * E' unchecked (estende RuntimeException) per non costringere ogni chiamante
 * del DAO a scrivere try/catch anche quando non puo' fare nulla di utile
 * con l'errore (es. un Controller puo' solo propagarlo, una View puo' solo
 * mostrare un messaggio - nessuno dei due puo' "risolvere" un problema
 * di connessione al database).
 */
public class DAOException extends RuntimeException {

    public DAOException(String messaggio, Throwable causa) {
        super(messaggio, causa);
    }

    public DAOException(String messaggio) {
        super(messaggio);
    }

    public DAOException(Throwable causa) {
        super("Errore di accesso al database", causa);
    }
}