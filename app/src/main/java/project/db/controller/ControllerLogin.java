package project.db.controller;

import project.db.data.Cliente;
import project.db.view.LoginPanel;
import project.db.view.MainView;

public class ControllerLogin {

    private final MainController mainController;
    private Cliente utente;
    private LoginPanel loginPanel;
    private MainView mainView;

    public ControllerLogin(final MainController mainController) {
        this.mainController = mainController;
    }

    public boolean tryLogin() {
        final var modelReading = this.mainController.getModelReading();
        var data = loginPanel.getUserData();
        var email = data.get("email").getText();
        var password = data.get("password").getText();
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        if(modelReading.find(email, password)){
            System.out.println("Utente trovato - nel database ControllerLogin");
            this.utente = modelReading.getCliente(email, password);
        } else {
            System.out.println("Utente non trovato");
            this.utente = null;
        }
        return this.utente != null;
    }


    public void logOut(){
        this.utente = null;
    }

    public void setUtente(final Cliente utente) {
        this.utente = utente;
    }

    public Cliente getUtente() {
        return utente;
    }

    public void setPanelLogin(final LoginPanel loginPanel) {
        this.loginPanel = loginPanel;
    }



}
