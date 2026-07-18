package project.db.model;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import project.db.data.Prodotto;

public class ReadingModel {

    private final Connection connection;

    public ReadingModel(final Connection connection){
        Objects.requireNonNull(connection, "Model created with null connection");
        this.connection = connection;
    }

    public List<Prodotto> loadProdotti() {
        return Prodotto.DAO.list(connection);
    }


}
