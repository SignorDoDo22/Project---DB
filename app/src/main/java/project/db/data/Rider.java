package project.db.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.db.Queries;
import project.db.controller.DAOUtils;
public class Rider {

    private String codiceRider;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String telefono;
    private int Ordini_Totali_Consegnati;
    private Date dataDiNascita;
    private int raitingMedio;
    private float guadagnoTotale;


    public Rider(Date dataDiNascita, String codiceRider, String nome, String cognome, String email, String password, String telefono) {
        this.dataDiNascita = dataDiNascita;
        this.codiceRider = codiceRider;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
    }

    public String getCodiceRider() {
        return codiceRider;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setRatingMedio(int raitingMedio) {
        this.raitingMedio = raitingMedio;
    }

    public int getRatingMedio() {
        return raitingMedio;
    }

    public void setGuadagnoTotale(float guadagnoTotale) {
        this.guadagnoTotale = guadagnoTotale;
    }

    public float getGuadagnoTotale() {
        return guadagnoTotale;
    }

    public void setNumOrdiniConsegnati(int numOrdiniConsegnati) {
        Ordini_Totali_Consegnati = numOrdiniConsegnati;
    }

    public int getNumOrdiniConsegnati() {
        return Ordini_Totali_Consegnati;
    }

    public static class DAO {

        public static List<Rider> list(final Connection connection) {
            List<Rider> riders = new ArrayList<>();

            try (PreparedStatement preparedStatement =
                         DAOUtils.prepare(connection, Queries.MOSTRA_RIDER.get());
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String codiceRider = resultSet.getString("codice_rider");
                    String nome = resultSet.getString("nome");
                    String cognome = resultSet.getString("cognome");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    String telefono = resultSet.getString("telefono");
                    int Ordini_Totali_Consegnati = resultSet.getInt("`Ordini_Totali_Consegnati`");
                    Date dataDiNascita = resultSet.getDate("dataDiNascita");
                    int raitingMedio = resultSet.getInt("raitingMedio");
                    float guadagnoTotale = resultSet.getFloat("guadagnoTotale");

                    Rider rider = new Rider(dataDiNascita, codiceRider, nome, cognome, email, password, telefono);
                    rider.setNumOrdiniConsegnati(Ordini_Totali_Consegnati);
                    rider.setGuadagnoTotale(guadagnoTotale);
                    rider.setRatingMedio(raitingMedio);
                    riders.add(rider);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return riders;
        }
    }

    public static void aggiornaGuadagnoTotale(float guadagno, Connection connection, String codiceRider) {
        try (PreparedStatement preparedStatement =
                     DAOUtils.prepare(connection, Queries.AGGIORNA_GUADAGNO_TOTALE_RIDER.get())) {
            preparedStatement.setFloat(1, guadagno);
            preparedStatement.setString(2, codiceRider);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void aggiornaRaitingMedio(int raiting) {
        return;
    }

    public static void riderPrendeInCaricoOrdine(String codiceRider, String codiceOrdine, Connection connection) {
        return;
    }

}
