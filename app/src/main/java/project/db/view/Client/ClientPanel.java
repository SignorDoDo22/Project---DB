package project.db.view.Client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.util.Objects;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import project.db.controller.ControllerClientPanel;
import project.db.data.Prodotto;
import project.db.view.ProdottoCatalogo.ProdottoCard;

public class ClientPanel extends JPanel {

    private final JPanel pannelloInferiore;
    private final JScrollPane pannelloCentrale;
    private final JPanel pannelScorrevole;
    private final Carrello carrello;
    private final JButton buttonIndietro;
    private final JButton buttonProcedi;
    private ControllerClientPanel controllerClientPanel;

    public ClientPanel() {
        this.setLayout(new BorderLayout());
        this.carrello = new Carrello(this);
        this.carrello.setPreferredSize(new Dimension(225,0));
        this.pannelScorrevole = new JPanel();
        this.pannelScorrevole.setLayout(new BoxLayout(pannelScorrevole, BoxLayout.Y_AXIS));

        this.pannelloCentrale = new JScrollPane(pannelScorrevole);
        this.add(pannelloCentrale, BorderLayout.CENTER);


        this.pannelloInferiore = new JPanel();
        this.pannelloInferiore.setLayout(new GridLayout(1, 3));

        this.buttonIndietro = new JButton("Indietro");
        this.buttonProcedi = new JButton("Procedi e ordina");

        this.pannelloInferiore.add(buttonIndietro);
        this.pannelloInferiore.add(new JPanel());  // cella vuota centrale, per spaziatura
        this.pannelloInferiore.add(buttonProcedi);

        this.add(pannelloInferiore, BorderLayout.SOUTH);
        this.add(carrello, BorderLayout.EAST);
    }

    public void showCatalogo(List<Prodotto> prodotti){
        for(Prodotto p : prodotti){
            this.pannelScorrevole.add(new ProdottoCard(p.getCodiceProdotto(), p.getNomeProdotto(),
            p.getPrezzoOriginario(), p.isDisponibile(), p.getMenu()));
        }
    }

    public void setController(final ControllerClientPanel controllerClientPanel){
        Objects.requireNonNull(controllerClientPanel);
        this.controllerClientPanel = controllerClientPanel;
    }

}