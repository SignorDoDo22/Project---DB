package project.db.data;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import project.db.Queries;
import project.db.controller.DAOException;
import project.db.controller.DAOUtils;

public class Ingrediente {

    private Boolean vegano;
    private Boolean senzaGlutine;
    private Boolean senzaLattosio;
    private String nomeIngrediente;
    private String codiceIngrediente;

    public Ingrediente(Boolean vegano, Boolean senzaGlutine, Boolean senzaLattosio,
        String nomeIngrediente, String codiceIngrediente){
        this.vegano = vegano;
        this.senzaGlutine = senzaGlutine;
        this.nomeIngrediente = nomeIngrediente;
        this.senzaLattosio = senzaLattosio;
        this.codiceIngrediente = codiceIngrediente;
    }

    public static class DAO {

        List<Ingrediente> list(Connection connection){

            List<Ingrediente> ingredienti = new ArrayList<>();
            try(
                var statement = DAOUtils.prepare(connection, Queries.MOSTRA_INGREDIENTI.get());
                var setResult = statement.executeQuery();){

                while (setResult.next()) {
                    var senzaLattosio = setResult.getBoolean("SenzaLattosio");
                    var vegano = setResult.getBoolean("Vegano");
                    var codiceIngrediente = setResult.getString("Codice_Ingrediente");
                    var nomeIngrediente = setResult.getString("Nome_Ingrediente");
                    var senzaGlutine = setResult.getBoolean("SenzaGlutine");
                    Ingrediente ingrediente = new Ingrediente(vegano, senzaGlutine, senzaLattosio, nomeIngrediente, codiceIngrediente);
                    ingredienti.add(ingrediente);
                }

            } catch (Exception e) {
                throw new DAOException("Errore nel caricamento degli ingredienti", e);
            }

            return ingredienti;
        }

        public static boolean check(Connection connection, String codiceIngrediente){
            try (
                var preparedStatement = DAOUtils.prepare(connection, Queries.TROVA_INGREDIENTE.get());
                var resultSet = preparedStatement.executeQuery();
            ) {
                return resultSet.next();

            } catch (Exception e) {
                throw new DAOException("Errore Ingrediente specifico non trovato", e);
            }
        }

    }

}
