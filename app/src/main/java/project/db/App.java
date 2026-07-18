package project.db;

import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import project.db.view.MainView;

public class App {

    private static final String URL = "jdbc:mysql://localhost:3306/FastFoodRel";
    private static final String USER = "root";
    private static final String PASSWORD = "Dodo122100.12";

    public static void main(String[] args) {

        MainView view = new MainView();
        view.setVisible(true);

    }
}