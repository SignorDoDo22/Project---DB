package project.db;

public enum  Queries {

    SHOW_RIGHE_PRODOTTO("""
            SELECT * FROM Riga_prodotto
        """),

    SHOW_RIGA_PRODOTTO_SINGOLA("""
            SELECT * FROM Riga_prodotto
            WHERE Codice_Ordine = ? AND Codice_Prodotto_Ordinato = ?
        """),

    CHECK_RIGA_PRODOTTO("""
            SELECT 1 FROM Riga_prodotto
            WHERE Codice_Ordine = ? AND Codice_Prodotto_Ordinato = ?
        """),

    CHECK_RIGA_PRODOTTO_SINGOLO("""
            SELECT 1 FROM RigaProdottoSingolo
            WHERE Codice_Ordine = ? AND Codice_Prodotto_Ordinato = ?
        """),

    INSERT_RIGA_PRODOTTO("""
            INSERT INTO Riga_prodotto (Codice_Ordine, Codice_Prodotto_Ordinato, Quantita, Prezzo, Codice_Sconto)
            VALUES (?, ?, ?, ?, ?)
        """),

    INSERT_RIGA_PRODOTTO_SINGOLO("""
            INSERT INTO RigaProdottoSingolo (Codice_Ordine, Codice_Prodotto_Ordinato)
            VALUES (?, ?)
        """),

    INSERT_RIGA_PRODOTTO_MENU("""
            INSERT INTO RigaProdottoMenu (Codice_Ordine, Codice_Prodotto_Ordinato)
            VALUES (?, ?)
        """),

    SHOW_ORDINI("""
        SELECT * FROM Ordine
        """),

    INSERT_ORDINE("""
        INSERT INTO Ordine (OrarioCreazione, Prezzo_totale, DataCreazione, OrarioConsegnato,
                             OrarioConsegna, OrarioEliminazione, Indirizzo_consegna_ordine,
                             Codice_Ordine, Codice_Utente)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """);


    private final String query;

    Queries(final String query) {
        this.query = query;
    }

    public String get() {
        return this.query;
    }
}
