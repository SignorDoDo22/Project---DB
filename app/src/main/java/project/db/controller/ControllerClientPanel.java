package project.db.controller;

import project.db.model.ReadingModel;
import project.db.view.Client.ClientPanel;


public class ControllerClientPanel {

    private final ReadingModel modelReading;
    private final ClientPanel clientPanel;

    public ControllerClientPanel(final ReadingModel modelReading, final ClientPanel clientPanel){
        this.modelReading = modelReading;
        this.clientPanel = clientPanel;
        this.clientPanel.setController(this);
    }

    public void userRequestedCatalogo() {
        try {
            final var prodotti = this.modelReading.loadProdotti();
            this.clientPanel.showCatalogo(prodotti);
        } catch (final DAOException e) {
            e.printStackTrace();
        }
    }

    public void userRequestIngredientiProd(final String codice_prodotto) {
        try {
            final var ingredienti = this.modelReading.loadIngredienti(codice_prodotto);
            this.clientPanel.mostraIngredienti(ingredienti);
        } catch (final DAOException e) {
            e.printStackTrace();
        }
    }



}


