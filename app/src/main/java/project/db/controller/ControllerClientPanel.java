package project.db.controller;

import project.db.model.ReadingModel;
import project.db.view.Client.ClientPanel;
import project.db.data.Ordine;
import java.util.List;
import java.util.Map;



public class ControllerClientPanel {

    private final ReadingModel modelReading;
    private final ClientPanel clientPanel;
    private final MainController mainController;

    public ControllerClientPanel(final ReadingModel modelReading, final ClientPanel clientPanel, final MainController mainController){
        this.modelReading = modelReading;
        this.clientPanel = clientPanel;
        this.mainController = mainController;
        this.clientPanel.setController(this);
    }

    public void userRequestedCatalogo() {
        try {
            final var prodotti = this.modelReading.loadProdotti();
            this.clientPanel.showCatalogo(prodotti);
            System.out.println("Catalogo caricato con successo");
        } catch (final DAOException e) {
            e.printStackTrace();
        }
    }

    public void userRequestIngredientiProd(final String codice_prodotto) {

        final var ingredienti = this.modelReading.loadIngredienti(codice_prodotto);
        this.clientPanel.mostraIngredienti(ingredienti);

    }

    public List<Ordine> userRequestOrdiniRecensibili(){
        return this.modelReading.loadOrdiniRecensibili(this.mainController.getControllerLogin().getUtente().getCodiceUtente());
    }

    public void userRequestIngredientiMenu(final String codiceProdottoMenu){
        this.clientPanel.mostraIngredientiMenu(this.modelReading.loadIngredientiMenu(codiceProdottoMenu));

    }


}


