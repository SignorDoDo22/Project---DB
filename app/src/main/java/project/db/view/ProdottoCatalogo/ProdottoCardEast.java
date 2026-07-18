package project.db.view.ProdottoCatalogo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProdottoCardEast extends JPanel {

    private ProdottoCard mainViewCard;
    private JButton aggiungi;

    public ProdottoCardEast(final ProdottoCard mainViewCard){
        this.mainViewCard = mainViewCard;
        this.aggiungi = new JButton("aggiungi");

    }
}
