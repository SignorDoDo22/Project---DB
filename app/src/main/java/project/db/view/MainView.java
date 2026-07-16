package project.db.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainView extends JFrame {

    private LoginPanel loginPanel;
    private SceltaLogin sceltaPanel;
    private CardLayout cardLayout;

    public MainView(){
        this.setTitle("Fast Food");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.sceltaPanel = new SceltaLogin(this);
        this.loginPanel = new LoginPanel(this);
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        this.add(sceltaPanel, "scelta");
        this.add(loginPanel, "login");
    }


    public void changePanel(final String panelName){
        cardLayout.show(getContentPane(), panelName);
    }


}
