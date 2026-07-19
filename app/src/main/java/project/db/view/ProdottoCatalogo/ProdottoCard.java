package project.db.view.ProdottoCatalogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import project.db.view.Client.ClientPanel;

public class ProdottoCard extends JPanel {

    private final JButton aggiungiProdotto;
    private final JButton infoProdotto;
    private final String codiceProdotto;
    private final String isMenu;
    private ClientPanel clientPanel;

    public ProdottoCard(final String codiceProdotto, final String nomeProdotto,final float prezzo,
                         final boolean disponibile, final String isMenu, final ClientPanel clientPanel) {

        this.codiceProdotto = codiceProdotto;
        this.isMenu = isMenu;
        this.clientPanel = clientPanel;
        this.infoProdotto = new JButton("info");
        this.setBorder(BorderFactory.createCompoundBorder(
                new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY),
                new EmptyBorder(10, 15, 10, 15)
        ));
        this.setLayout(new BorderLayout());
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));


        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.add(new JLabel(nomeProdotto));
        this.add(infoPanel, BorderLayout.WEST);


        JPanel azionePanel = new JPanel();
        azionePanel.add(new JLabel(String.format("€%.2f", prezzo)));

        this.aggiungiProdotto = new JButton("Aggiungi");
        this.aggiungiProdotto.setEnabled(disponibile);
        azionePanel.add(aggiungiProdotto);
        azionePanel.add(infoProdotto);

        this.add(azionePanel, BorderLayout.EAST);

        if (!disponibile) {
            this.setBackground(new Color(253, 235, 235));
            this.setOpaque(true);
        }

        this.infoProdotto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println(nomeProdotto);
                clientPanel.requestIngredienti(codiceProdotto);
            }

        });
    }

    public String getCodiceProdotto() {
        return codiceProdotto;
    }


    public JButton getAggiungiProdotto() {
        return aggiungiProdotto;
    }



}