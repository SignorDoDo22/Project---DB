package project.db.view.Client.ModificaRiga;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPopupMenu;

import project.db.view.Client.RigaCarrello;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelModificaRiga extends JPanel {

    private int quantita;
    private String nomeIngrediente;
    private String codiceIngrediente;
    private JButton buttonEliminaIngrediente;
    private JPopupMenu popupMenu;

    public PanelModificaRiga(int quantita, String nomeIngrediente, String codiceIngrediente, RigaCarrello rigaCarrello) {

        this.quantita = quantita;
        this.nomeIngrediente = nomeIngrediente;
        this.codiceIngrediente = codiceIngrediente;

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        this.buttonEliminaIngrediente = new JButton("Elimina");
        this.add(buttonEliminaIngrediente);
    }

    public boolean requestEliminaIngrediente() {
        return true;
    }



}
