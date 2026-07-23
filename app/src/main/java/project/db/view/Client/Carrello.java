package project.db.view.Client;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class Carrello extends JPanel {

    private JScrollPane scrollPanel;
    private JPanel panelscorrevole;
    private ClientPanel clientPanel;
    private JLabel carrelloString;
    private JLabel totaleString;
    private JButton buttonProcedi;



    public Carrello(final ClientPanel clientPanel){

        this.clientPanel = clientPanel;
        this.setLayout(new BorderLayout());
        this.carrelloString = new JLabel("CART");
        this.totaleString = new JLabel("TOTALE: ");
        this.add(carrelloString, BorderLayout.NORTH);

        this.clientPanel = clientPanel;
        this.panelscorrevole = new JPanel();
        this.panelscorrevole.setLayout(new BoxLayout(panelscorrevole, BoxLayout.Y_AXIS));
        this.scrollPanel = new JScrollPane(panelscorrevole);
        this.add(scrollPanel, BorderLayout.CENTER);
        this.add(totaleString, BorderLayout.SOUTH);


    }

    public void addRigaCarrello(int quantita, String nomeProdotto, float prezzoUnitario){

        RigaCarrello rigaOrdine = new RigaCarrello(prezzoUnitario, quantita, nomeProdotto, this);
        this.panelscorrevole.add(rigaOrdine);
        this.revalidate();
        this.repaint();
    }

    public void requestIngredientiPresenti(RigaCarrello rigaCarrello){

    }
}
