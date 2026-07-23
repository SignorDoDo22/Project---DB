package project.db.view.Recensione;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import project.db.view.Client.ClientPanel;

public class CardRecensione extends JPanel {

    private ClientPanel clientPanel;
    private JButton creaRecensione;
    private JTextArea testoRecensione;
    private JComboBox<Integer> votoOrdineSelector;
    private JComboBox<Integer> votoRiderSelector;
    private JLabel titoloPanel;

    public CardRecensione() {

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(300, 0));

        this.titoloPanel = new JLabel("Creazione Recensione");
        this.testoRecensione = new JTextArea();
        this.creaRecensione = new JButton("Crea Recensione");

        Integer[] voti = {1, 2, 3, 4, 5};
        this.votoOrdineSelector = new JComboBox<>(voti);
        this.votoRiderSelector = new JComboBox<>(voti);

        JPanel votiPanel = new JPanel(new GridLayout(2, 2));
        votiPanel.add(new JLabel("Voto Ordine:"));
        votiPanel.add(votoOrdineSelector);
        votiPanel.add(new JLabel("Voto Rider:"));
        votiPanel.add(votoRiderSelector);

        this.add(titoloPanel, BorderLayout.NORTH);
        this.add(testoRecensione, BorderLayout.CENTER);
        this.add(votiPanel, BorderLayout.SOUTH);
    }

    // Getter puliti: la view espone solo dati grezzi, non componenti
    public String getTestoRecensione() {
        return testoRecensione.getText();
    }

    public int getVotoOrdine() {
        return (int) votoOrdineSelector.getSelectedItem();
    }

    public int getVotoRider() {
        return (int) votoRiderSelector.getSelectedItem();
    }
}
