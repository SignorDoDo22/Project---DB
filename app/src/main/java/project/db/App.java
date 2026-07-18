package project.db;

import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import project.db.controller.DAOUtils;
import project.db.controller.MainController;
import project.db.model.ReadingModel;
import project.db.model.WritingMode;
import project.db.view.MainView;

public class App {

    private static final String URL = "jdbc:mysql://localhost:3306/schemarelfastfood";
    private static final String USER = "root";
    private static final String PASSWORD = "Dodo122100.12";

    public static void main(String[] args) {

       final var connection = DAOUtils.localMySQLConnection("schemarelfastfood", USER, PASSWORD);
       final var readingModel = new ReadingModel(connection);
       final var writingModel = new WritingMode(connection);
       final var mainController = new MainController(readingModel, writingModel, connection);

    }
}