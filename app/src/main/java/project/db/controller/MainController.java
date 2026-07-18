package project.db.controller;

import java.sql.Connection;

import project.db.model.ReadingModel;
import project.db.model.WritingMode;
import project.db.view.MainView;

public class MainController {

    private MainView mainView;
    private ReadingModel modelReading;
    private WritingMode writingMode;
    private Connection connection;
    private ControllerClientPanel controllerClient;

    public MainController(final ReadingModel modelReading, final WritingMode writingMode, final Connection connection){
        this.modelReading = modelReading;
        this.writingMode = writingMode;
        this.connection = connection;
        this.mainView = new MainView(this);
        this.controllerClient = new ControllerClientPanel(modelReading, mainView.getClientPanel());
        this.mainView.setVisible(true);
    }

    public ControllerClientPanel getControllerClient(){
        return this.controllerClient;
    }

}
