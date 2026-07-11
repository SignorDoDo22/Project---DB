package project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import project.db.view.MainView;

public class App {

    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/schema_rel_fastfood";
        String user = "root";
        String password = "Dodo122100.12";

        System.out.println("Connecting...");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }

        MainView view = new MainView();

    }
}
