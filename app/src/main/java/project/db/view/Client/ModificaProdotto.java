package project.db.view.Client;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class ModificaProdotto extends JDialog  {

    private JPanel panel;
    private ClientPanel clientPanel;
    private String codiceProdotto;

    public ModificaProdotto(ClientPanel clientPanel, String codiceProdotto) {
        this.setTitle("Modifica Prodotto");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.panel = new JPanel();
        this.add(panel);
        this.clientPanel = clientPanel;
        this.codiceProdotto = codiceProdotto;
        this.setVisible(true);
    }

}
