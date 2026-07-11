package project.db.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainView {

    private JFrame mainScreen;
    private JPanel mainPanel;

    public MainView(){
        this.mainScreen = new JFrame("Servizio Fast Food");
        this.mainPanel = new JPanel();

        this.mainScreen.setVisible(true);
        this.mainScreen.setSize(700,700);
        this.mainScreen.setResizable(false);
        this.mainScreen.setLayout(new BorderLayout());
    }

}
