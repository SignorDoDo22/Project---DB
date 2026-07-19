package project.db.controller;

import project.db.model.ReadingModel;
import project.db.model.WritingModel;
import project.db.view.RegistrazionePanel;

public class ControllerRegistrazione {

    private final MainController mainController;
    private final ReadingModel modelReading;
    private WritingModel modelWriting;
    private RegistrazionePanel registrationPanel;

    public ControllerRegistrazione(RegistrazionePanel registrationPanel, MainController mainController, ReadingModel model, WritingModel modelWriting) {
        this.registrationPanel = registrationPanel;
        this.mainController = mainController;
        this.modelReading = model;
        this.modelWriting = modelWriting;
    }

    public boolean tryRegistration() {
        var data = registrationPanel.getUserData();
        var codiceUtente = data.get("codiceUtente").getText();
        var username = data.get("username").getText();
        var password = data.get("password").getText();
        var email = data.get("email").getText();
        var nome = data.get("nome").getText();
        var cognome = data.get("cognome").getText();
        var dataDiNascita = java.sql.Date.valueOf(data.get("dataDiNascita").getText());
        var telefono = data.get("telefono").getText();
        return modelWriting.userRequestRegistration(mainController.getConnection(), codiceUtente, username, password, email, nome, cognome, dataDiNascita, telefono, false);
    }

    public void setRegistrationPanel(RegistrazionePanel registrationPanel) {
        this.registrationPanel = registrationPanel;
    }
}
