package project.db.view.Client;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RecensioniPanel extends JPanel {

    JLabel titoloPanel;
    JPanel panneloScorrevole;
    JScrollPane pannelloCentrale;
    ClientPanel clientPanel;

    public RecensioniPanel(final ClientPanel clientPanel){
        this.clientPanel = clientPanel;
        this.panneloScorrevole = new JPanel();
        this.pannelloCentrale = new JScrollPane(pannelloCentrale);

    }
}
