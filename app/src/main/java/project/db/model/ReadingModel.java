package project.db.model;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

import project.db.data.Cliente;
import project.db.data.Prodotto;
import project.db.data.Recensione;

public class ReadingModel {

    private final Connection connection;

    public ReadingModel(final Connection connection){
        Objects.requireNonNull(connection, "Model created with null connection");
        this.connection = connection;
    }

    public List<Prodotto> loadProdotti() {
        return Prodotto.DAO.list(connection);
    }

    public List<String> loadIngredienti(final String Codice_Prodotto){
        return Prodotto.DAO.getIngredienti(connection, Codice_Prodotto);
    }

    public List<Recensione> loadRecensioni(final String codiceUtente) {
        return Recensione.DAO.list(connection, codiceUtente);
    }

    public Cliente getCliente(final String email, final String password) {
        return Cliente.DAO.getCliente(connection, email, password);
    }

    public boolean find(final String email, final String password) {
        return Cliente.DAO.find(connection, email, password);
    }

}
