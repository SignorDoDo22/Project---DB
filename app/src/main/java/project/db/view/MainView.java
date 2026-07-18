package project.db.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import project.db.view.Client.ClientPanel;

public class MainView extends JFrame {

    private LoginPanel loginPanel;
    private SceltaLogin sceltaPanel;
    private CardLayout cardLayout;
    private ClientPanel client;

    public MainView(){
        this.setTitle("Fast Food");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.sceltaPanel = new SceltaLogin(this);
        this.client = new ClientPanel();
        this.loginPanel = new LoginPanel(this);
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        this.add(sceltaPanel, "scelta");
        this.add(loginPanel, "login");
        this.add(client, "client");
    }


    public void changePanel(final String panelName){
        cardLayout.show(getContentPane(), panelName);
    }


}
