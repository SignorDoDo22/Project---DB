package project.db.view;

import java.awt.*;
import javax.swing.*;
import project.db.controller.MainController;
import project.db.view.Client.ClientPanel;
import project.db.view.Rider.RiderPanel;
import project.db.view.RegistrazionePanel;

public class MainView extends JFrame {

    private LoginPanel loginPanel;
    private SceltaLogin sceltaPanel;
    private RiderPanel riderPanel;
    private CardLayout cardLayout;
    private ClientPanel client;
    private RegistrazionePanel registrationPanel;
    private MainController mainController;

    public MainView(final MainController mainController){
        this.setTitle("Fast Food");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.mainController = mainController;

        this.sceltaPanel = new SceltaLogin(this);
        this.client = new ClientPanel(this);
        this.loginPanel = new LoginPanel(this);
        this.registrationPanel = new RegistrazionePanel(this);
        this.cardLayout = new CardLayout();
        this.riderPanel = new RiderPanel(this.mainController.getControllerRider(), this);
        this.setLayout(cardLayout);

        this.add(sceltaPanel, "scelta");
        this.add(loginPanel, "login");
        this.add(client, "client");
        this.add(riderPanel, "rider");
        this.add(registrationPanel, "registration");
    }


    public void changePanel(final String panelName){
        System.out.println("Cambio pannello a: " + panelName);
        if("scelta".equals(panelName)) {
            cardLayout.show(getContentPane(), panelName);
        }

        if("login".equals(panelName)) {
            cardLayout.show(getContentPane(), panelName);
        }

        if("client".equals(panelName) && mainController.getControllerLogin().tryLogin()) {
            cardLayout.show(getContentPane(), panelName);
            System.out.println("Cambio pannello a client");
            this.mainController.getControllerClient().userRequestedCatalogo();
        }

        if("rider".equals(panelName)) {
            cardLayout.show(getContentPane(), panelName);
            this.mainController.getControllerRider().showOrders();
        }

        if("registration".equals(panelName)) {
            System.out.println("cambio pannello registrazione");
            cardLayout.show(getContentPane(), panelName);
        }
    }

    public ClientPanel getClientPanel(){
        return this.client;
    }

    public RegistrazionePanel getRegistrazionePanel() {
        return this.registrationPanel;
    }

    public LoginPanel getLoginPanel() {
        return this.loginPanel;
    }

    public RiderPanel getRiderPanel() {
        return this.riderPanel;
    }

    public boolean tryLogin(){
        return this.mainController.getControllerLogin().tryLogin();
    }

    public boolean tryRegistration() {
        return this.mainController.getControllerRegistrazione().tryRegistration();
    }

}
