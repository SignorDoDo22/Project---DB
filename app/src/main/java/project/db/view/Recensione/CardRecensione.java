package project.db.view.Recensione;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

import project.db.view.Client.ClientPanel;

public class CardRecensione extends JPanel {

    Date dataCreazione;
    String Codice_Recensione;
    Float costoTotale;
    ClientPanel clientPanel;
    JButton creaRecensione;

    public CardRecensione(Date dataCreazione, String Codice_Recensione, Float costoTotale, ClientPanel clientPanel){
        this.dataCreazione = dataCreazione;
        this.Codice_Recensione = Codice_Recensione;
        this.costoTotale = costoTotale;
        this.clientPanel = clientPanel;

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(300,0));
        this.creaRecensione = new JButton("Crea Recensione");

    }

}
