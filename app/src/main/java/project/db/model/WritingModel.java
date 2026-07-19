package project.db.model;
import java.sql.Connection;
import project.db.data.Cliente;
import java.sql.Date;

public class WritingModel {

    private final Connection connection;

    public WritingModel(Connection connection) {
        this.connection = connection;
    }

    public boolean userRequestRegistration(final Connection connection, final String codiceUtente, final String username,
        final String password, final String email, final String nome, final String cognome,
        final Date dataDiNascita, final String telefono, final boolean rider) {
        return Cliente.DAO.insert(connection, codiceUtente, username, password, email, nome, cognome, dataDiNascita, telefono, rider);
    }


}
