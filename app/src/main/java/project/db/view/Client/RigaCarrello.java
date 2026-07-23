package project.db.view.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RigaCarrello extends JPanel {

    private float prezzo;
    private int quantita;
    private String nomeProdotto;
    private JLabel nomeProdottoLabel;
    private JLabel quantitaLabel;
    private JLabel prezzoLabel;
    private JButton buttonModificaRiga;
    private JButton buttonEliminaRiga;

    public RigaCarrello(float prezzo, int quantita, String nomeProdotto, Carrello carrello) {
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.nomeProdotto = nomeProdotto;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.nomeProdottoLabel = new JLabel(nomeProdotto);
        this.quantitaLabel = new JLabel(String.valueOf(quantita));
        this.prezzoLabel = new JLabel(String.format("€%.2f", prezzo));
        this.add(nomeProdottoLabel);
        this.add(quantitaLabel);
        this.add(prezzoLabel);
        this.buttonModificaRiga = new JButton("Modifica");
        this.buttonEliminaRiga = new JButton("Elimina");
        this.add(buttonModificaRiga);
        this.add(buttonEliminaRiga);

        this.buttonModificaRiga.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });
    }

    public void requestIngredientiPresenti(){

    }


    public void readModifiche(){

    }


}
