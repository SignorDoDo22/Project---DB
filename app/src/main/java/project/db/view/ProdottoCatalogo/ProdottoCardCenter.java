package project.db.view.ProdottoCatalogo;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProdottoCardCenter extends JPanel {

    private ProdottoCard mainViewCard;
    private JLabel descrizioneLabel;

    public ProdottoCardCenter(final ProdottoCard mainViewCard, final String descrizione){
        this.setVisible(true);
        this.mainViewCard = mainViewCard;
        this.descrizioneLabel = new JLabel(descrizione);
        this.add(descrizioneLabel);
    }
}
