package project.db.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.db.Queries;
import project.db.controller.DAOException;
import project.db.controller.DAOUtils;

public class Cliente {

    private String codiceUtente;
    private String username;
    private String password;
    private String email;
    private String nome;
    private String cognome;
    private Date dataDiNascita;
    private String telefono;

    public Cliente(String codiceUtente, String username, String password, String email,
                  String nome, String cognome, Date dataDiNascita, String telefono) {
        this.codiceUtente = codiceUtente;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.telefono = telefono;
    }

    public String getCodiceUtente() { return codiceUtente; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public Date getDataDiNascita() { return dataDiNascita; }
    public String getTelefono() { return telefono; }


    public static class DAO {

        public static List<Cliente> list(final Connection connection) {
            List<Cliente> utenti = new ArrayList<>();

            try (PreparedStatement preparedStatement =
                         DAOUtils.prepare(connection, Queries.SHOW_UTENTI.get());
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    utenti.add(mapUtente(resultSet));
                }

            } catch (SQLException e) {
                throw new DAOException("Errore durante il recupero degli utenti", e);
            }

            return utenti;
        }

        private static Cliente mapUtente(ResultSet resultSet) throws SQLException {
            return new Cliente(
                    resultSet.getString("Codice_Utente"),
                    resultSet.getString("Username"),
                    resultSet.getString("Password"),
                    resultSet.getString("Email"),
                    resultSet.getString("Nome"),
                    resultSet.getString("Cognome"),
                    resultSet.getDate("Data_di_Nascita"),
                    resultSet.getString("Telefono")
            );
        }


        public static boolean insert(final Connection connection, final String codiceUtente, final String username,
        final String password, final String email, final String nome, final String cognome,
        final Date dataDiNascita, final String telefono, final boolean rider) {

            String sql = """
                INSERT INTO Utente (Codice_Utente, Username, Password, Email, Nome, Cognome, Data_di_Nascita, Telefono, Rider)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;

            try (PreparedStatement nuovoUtente = connection.prepareStatement(sql)) {

                nuovoUtente.setString(1, codiceUtente);
                nuovoUtente.setString(2, username);
                nuovoUtente.setString(3, password);
                nuovoUtente.setString(4, email);
                nuovoUtente.setString(5, nome);
                nuovoUtente.setString(6, cognome);
                nuovoUtente.setDate(7, new java.sql.Date(dataDiNascita.getTime())); // see note below
                nuovoUtente.setString(8, telefono);
                nuovoUtente.setBoolean(9, rider);

                int rowsInserted = nuovoUtente.executeUpdate();
                return rowsInserted > 0;

            } catch (final Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public static boolean check(final Connection connection, final String codiceUtente) {

            String sql = """
                SELECT *
                FROM Utente
                WHERE Utente.Codice_Utente = ?;
            """;

            try(
                PreparedStatement preparedStatement = DAOUtils.prepare(connection, sql, codiceUtente);
                ResultSet resultSet = preparedStatement.executeQuery();
            ){
               return resultSet.next();

            }catch(final Exception e ){
                e.printStackTrace();
                return false;
            }
        }


        public static Cliente find(final Connection connection, final String codiceUtente) {

            String sql = """
                SELECT *
                FROM Utente
                WHERE Utente.Codice_Utente = ?;
            """;

            try (
                var statement = DAOUtils.prepare(connection, sql, codiceUtente);
                var resultSet = statement.executeQuery();
            ) {
                if (resultSet.next()) {
                    return new Cliente(
                        resultSet.getString("Codice_Utente"),
                        resultSet.getString("Username"),
                        resultSet.getString("Password"),
                        resultSet.getString("Email"),
                        resultSet.getString("Nome"),
                        resultSet.getString("Cognome"),
                        resultSet.getDate("Data_di_Nascita"),
                        resultSet.getString("Telefono")
                    );
                }

                return null; // nessun utente trovato con quel codice

            } catch (final Exception e) {
                throw new DAOException(e);
            }
        }

    }
}