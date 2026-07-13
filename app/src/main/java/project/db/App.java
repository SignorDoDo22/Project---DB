package project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import project.db.view.MainView;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/northwind";
        String user = "root";
        String password = "Dodo122100.12";

        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
            while(rs.next()){
                System.out.println("User: " + rs.getString("FirstName"));
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }

        MainView view = new MainView();
    }
}
