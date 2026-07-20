package project.db.view.Rider;

import java.util.List;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import project.db.controller.ControllerRider;
import project.db.data.Ordine;
import project.db.view.MainView;

public class RiderPanel extends JPanel {

    private JScrollPane scrollPane;
    private JPanel panelInterno;
    private JButton buttonIndietro;
    private JButton buttonProcedi;
    private ControllerRider controllerRider;
    private MainView mainView;


    public RiderPanel(ControllerRider controllerRider, MainView mainView) {
        this.controllerRider = controllerRider;
        this.mainView = mainView;

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

        this.buttonIndietro.addActionListener(e -> mainView.changePanel("scelta"));
    }

    public void showOrdersReady(List<Ordine> ordini) {
        panelInterno.removeAll();
        for (Ordine ordine : ordini) {
            OrdineRiderPanel ordineRiderPanel = new OrdineRiderPanel(ordine);
            System.out.println("PANEL -- Ordine pronto: " + ordine.getCodiceOrdine());
            panelInterno.add(ordineRiderPanel);
        }
        panelInterno.revalidate();
        panelInterno.repaint();
    }
}
