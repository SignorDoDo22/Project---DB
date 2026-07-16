package project.db.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOUtils {

    public static PreparedStatement prepare(Connection conn, String query, Object... params) throws SQLException {
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return statement;
    }
}
