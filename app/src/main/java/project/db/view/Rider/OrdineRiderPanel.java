package project.db.view.Rider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class OrdineRiderPanel extends JPanel {

    private final JButton prendiInCaricoButton;
    private final JButton consegnaButton;
    private final String codiceOrdine;

    public OrdineRiderPanel(String codiceOrdine, String via, String citta, String civico, boolean giaPresoInCarico) {

        this.codiceOrdine = codiceOrdine;

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createCompoundBorder(
                new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY),
                new EmptyBorder(10, 15, 10, 15)
        ));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));

        JLabel indirizzoLabel = new JLabel(
                String.format("Ordine %s - %s, %s (%s)", codiceOrdine, via, civico, citta));
        this.add(indirizzoLabel, BorderLayout.WEST);

        JPanel azionePanel = new JPanel();

        this.prendiInCaricoButton = new JButton("Prendi in carico");
        this.consegnaButton = new JButton("Consegna");

        if (giaPresoInCarico) {
            azionePanel.add(consegnaButton);
        } else {
            azionePanel.add(prendiInCaricoButton);
        }

        this.add(azionePanel, BorderLayout.EAST);
    }

    public String getCodiceOrdine() {
        return codiceOrdine;
    }

    public JButton getPrendiInCaricoButton() {
        return prendiInCaricoButton;
    }

    public JButton getConsegnaButton() {
        return consegnaButton;
    }
}