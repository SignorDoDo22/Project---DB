package project.db.controller;

import project.db.model.ReadingModel;
import project.db.view.Rider.RiderPanel;

public class ControllerRider {

    private  MainController mainController;
    private ReadingModel modelReading;
    private RiderPanel riderPanel;

    public ControllerRider(MainController mainController, ReadingModel modelReading, RiderPanel riderPanel) {
        this.mainController = mainController;
        this.modelReading = modelReading;
        this.riderPanel = riderPanel;
    }

    public void showOrders(){

    }

}
