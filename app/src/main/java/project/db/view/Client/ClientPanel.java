package project.db.view.Client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import project.db.view.ProdottoCatalogo.ProdottoCard;

public class ClientPanel extends JPanel {

    private final JPanel pannelloInferiore;
    private final JScrollPane pannelloCentrale;
    private final JPanel pannelScorrevole;
    private final Carrello carrello;
    private final JButton buttonIndietro;
    private final JButton buttonProcedi;

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

        for (int i = 0; i < 50; i++) {
            this.pannelScorrevole.add(new ProdottoCard());  // aggiunto al pannello giusto
        }
    }
}