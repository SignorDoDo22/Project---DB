package project.db;

import javax.swing.JFrame;

import project.db.view.MainView;
import project.db.view.SceltaLogin;

public class App {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/relfastfood";
    private static final String USER = "root";
    private static final String PASSWORD = "Dodo122100.12";

    public static void main(String[] args) {
        MainView view = new MainView();
        view.setVisible(true);

    }
}