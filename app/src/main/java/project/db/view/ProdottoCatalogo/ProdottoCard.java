package project.db.view.ProdottoCatalogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class ProdottoCard extends JPanel {

    private final JButton aggiungiProdotto;
    private final String codiceProdotto;
    private final String isMenu;

    public ProdottoCard(final String codiceProdotto, final String nomeProdotto,final float prezzo,
                         final boolean disponibile, final String isMenu) {

        this.codiceProdotto = codiceProdotto;
        this.isMenu = isMenu;

        this.setBorder(BorderFactory.createCompoundBorder(
                new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY),
                new EmptyBorder(10, 15, 10, 15)
        ));
        this.setLayout(new BorderLayout());
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));

        // ---- Colonna sinistra: nome + descrizione ----
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.add(new JLabel(nomeProdotto));
        this.add(infoPanel, BorderLayout.WEST);

        // ---- Colonna destra: prezzo + bottone ----
        JPanel azionePanel = new JPanel();
        azionePanel.add(new JLabel(String.format("€%.2f", prezzo)));

        this.aggiungiProdotto = new JButton("Aggiungi");
        this.aggiungiProdotto.setEnabled(disponibile);
        azionePanel.add(aggiungiProdotto);

        this.add(azionePanel, BorderLayout.EAST);

        if (!disponibile) {
            this.setBackground(new Color(253, 235, 235));
            this.setOpaque(true);
        }
    }

    public String getCodiceProdotto() {
        return codiceProdotto;
    }


    public JButton getAggiungiProdotto() {
        return aggiungiProdotto;
    }
}