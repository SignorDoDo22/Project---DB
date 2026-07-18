package project.db.view.ProdottoCatalogo;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class ProdottoCard extends JPanel {

    private JButton aggiungiProdotto;
    private ProdottoCardEast east;
    private ProdottoCardCenter center;
    private JLabel nomeProdotto;
    private JLabel descrizioneProdotto;
    private JLabel costo;

    public ProdottoCard(){

        this.setVisible(true);
        this.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY),
            new EmptyBorder(10, 15, 10, 15)
        ));
        this.setLayout(new BorderLayout());

        this.center = new ProdottoCardCenter(this, "DESCRIZIONE");
        this.east = new ProdottoCardEast(this);

        this.aggiungiProdotto = new JButton("Aggiungi");
        this.nomeProdotto = new JLabel("nome");
        this.descrizioneProdotto = new JLabel("descrizione");
        this.costo = new JLabel("Costo");

        this.add(nomeProdotto, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);
        this.add(aggiungiProdotto, BorderLayout.EAST);

    }



}
