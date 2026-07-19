package project.db.view.Rider;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RiderPanel extends JPanel {

    private JScrollPane scrollPane;
    private JPanel panelInterno;
    private JButton buttonIndietro;
    private JButton buttonProcedi;

    public RiderPanel() {
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.panelInterno = new JPanel();
        this.panelInterno.setLayout(new BoxLayout(panelInterno, BoxLayout.Y_AXIS));
        this.scrollPane = new JScrollPane(panelInterno);
        this.buttonIndietro = new JButton("Indietro");
        this.buttonProcedi = new JButton("Procedi e ordina");

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonIndietro, BorderLayout.SOUTH);
        this.add(buttonProcedi, BorderLayout.SOUTH);


    }

}
