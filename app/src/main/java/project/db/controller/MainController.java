package project.db.controller;

import java.sql.Connection;

import project.db.model.ReadingModel;
import project.db.model.WritingModel;
import project.db.view.MainView;

public class MainController {

    private MainView mainView;
    private ReadingModel modelReading;
    private WritingModel writingModel;
    private Connection connection;
    private ControllerClientPanel controllerClient;
    private ControllerRider controllerRider;
    private final ControllerLogin controllerLogin;
    private final ControllerRegistrazione controllerRegistrazione;

    public MainController(final ReadingModel modelReading, final WritingModel writingModel, final Connection connection){
        this.modelReading = modelReading;
        this.writingModel = writingModel;
        this.connection = connection;
        this.mainView = new MainView(this);
        this.controllerLogin = new ControllerLogin(this);
        this.controllerClient = new ControllerClientPanel(modelReading, mainView.getClientPanel(), this);
        this.controllerRider = new ControllerRider(this, modelReading, mainView.getRiderPanel());
        this.controllerRegistrazione = new ControllerRegistrazione(mainView.getRegistrazionePanel(), this, modelReading, writingModel);

        this.controllerLogin.setPanelLogin(mainView.getLoginPanel());
        this.mainView.setVisible(true);
    }

    public ControllerClientPanel getControllerClient(){
        return this.controllerClient;
    }

    public ControllerLogin getControllerLogin() {
        return this.controllerLogin;
    }

    public MainView getMainView() {
        return this.mainView;
    }

    public ReadingModel getModelReading() {
        return this.modelReading;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public ControllerRider getControllerRider() {
        return this.controllerRider;
    }
    public ControllerRegistrazione getControllerRegistrazione() {
        return this.controllerRegistrazione;
    }
}
