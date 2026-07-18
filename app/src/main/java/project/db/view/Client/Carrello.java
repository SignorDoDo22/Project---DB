package project.db.view.Client;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Carrello extends JPanel {

    private JScrollPane scrollPanel;
    private JPanel panelscorrevole;
    private ClientPanel clientPanel;
    private JLabel carrelloString;
    private JLabel totaleString;

    public Carrello(final ClientPanel clientPanel){
        this.setLayout(new BorderLayout());
        this.carrelloString = new JLabel("CART");
        this.totaleString = new JLabel("TOTALE: ");
        this.add(carrelloString, BorderLayout.NORTH);

        this.clientPanel = clientPanel;
        this.panelscorrevole = new JPanel();
        this.panelscorrevole.setLayout(new BorderLayout());
        this.scrollPanel = new JScrollPane(panelscorrevole);
        this.add(scrollPanel, BorderLayout.CENTER);
        this.add(totaleString, BorderLayout.SOUTH);


    }
}
