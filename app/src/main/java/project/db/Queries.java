package project.db;

public enum  Queries {

    INSERIRE_CLIENTE("""
            INSERT INTO Cliente (Codice_Utente, Username, Password, Email, Nome,
                Cognome, Data_di_Nascita, Telefono, NumOrdiniEffetuati)
            VALUES(?,?,?,?,?,?,?,?,?)
            """),

    INSERIRE_RIDER("""
            INSERT INTO RIDER (Codice_Utente, Username, Password, Email, Nome,
                Cognome, Data_di_Nascita, Telefono, RaitingMedioRider, Guadagno, Ordini_Totali_Consegnati)
            VALUES(?,?,?,?,?,?,?,?,?,?,?)
            """),

    INSERIRE_CATEGORIA("""
            INSERT INTO Categoria (IDCategoria, Nome)
            VALUES(?,?)
            """),
    INSERIRE_INGREDIENTE("""
            INSERT INTO Ingrediente (Codice_Ingrediente, Nome_Ingrediente, Vegano, SenzaGlutine, SenzaLattosio)
            VALUES(?,?,?,?,?)
            """),
    INSERIRE_SCONTO("""
            INSERT INTO Sconto (Codice_Sconto, Data_Inizio, Data_Fine, Percentuale_Scontata, Descrizione, ScontoOffertoDallaCasa)
            VALUES(?,?,?,?,?,?)
            """),
    INSERIRE_SCONTOCASA("""
            INSERT INTO ScontoOffertoDallaCasa (Codice_Sconto) VALUES (?)
            """),
    INSERIRE_SCONTOFEDEL("""
            INSERT INTO ScontoFedelta (Codice_Sconto, QuotaOrdini, NumeroUtilizzi)
            VALUES(?, ?, ?)
            """),

    FIND_UTENTE("""
        SELECT *
        FROM Utente
        WHERE Utente.Codice_Utente = ?;
            """);


    private final String query;

    Queries(final String query) {
        this.query = query;
    }

    public String get() {
        return this.query;
    }
}
