package project.db.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import project.db.Queries;
import project.db.controller.DAOException;
import project.db.controller.DAOUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Categoria {
    private String nomeCategoria;
    private String idCategoria;

    public Categoria(String nomeCategoria, String idCategoria) {
        this.nomeCategoria = nomeCategoria;
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public static class DAO {

        public List<Categoria> list(final Connection connection) {
            List<Categoria> categorie = new ArrayList<>();

            try (PreparedStatement preparedStatement = DAOUtils.prepare(connection, Queries.MOSTRA_CATEGORIE.get());
                ResultSet resultSet = preparedStatement.executeQuery()) {

                    while (resultSet.next()) {
                        String nomeCategoria = resultSet.getString("nome_categoria");
                        String idCategoria = resultSet.getString("id_categoria");
                        Categoria categoria = new Categoria(nomeCategoria, idCategoria);
                        categorie.add(categoria);
                    }
            } catch (SQLException e) {
                throw new DAOException("Error listing categories", e);
            }

            return categorie;
        }

        public boolean checkByName(final Connection connection, final String idCategoria) {
            try (PreparedStatement preparedStatement = DAOUtils.prepare(connection, Queries.CHECK_CATEGORIA.get())) {
                preparedStatement.setString(1, idCategoria);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next();
                }
            } catch (SQLException e) {
                throw new DAOException("Error checking if category exists", e);
            }

        }

        public boolean checkByNome(final Connection connection, final String nomeCategoria) {
            try (PreparedStatement preparedStatement = DAOUtils.prepare(connection, Queries.CHECK_NOME_CATEGORIA.get())) {
                preparedStatement.setString(1, nomeCategoria);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next();
                }
            } catch (SQLException e) {
                throw new DAOException("Error checking if category name exists", e);
            }

        }
    }



}
