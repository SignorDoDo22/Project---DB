package project.db.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

    private JButton button;
    private JTextField name;
    private JPasswordField password;
    private JTextField email;
    private JPanel panelInterno;
    private MainView mainView;
    private JButton indietroButton;

    public LoginPanel(final MainView mainView) {

        this.setLayout(new BorderLayout());
        this.mainView = mainView;
        this.panelInterno = new JPanel();
        this.panelInterno.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.NONE; // non stirare i componenti

        this.name = new JTextField(15);       // 15 colonne = dimensione ragionevole
        this.password = new JPasswordField(15);
        this.email = new JTextField(15);
        this.button = new JButton("Inserisci");
        this.indietroButton = new JButton("Indietro");

        gbc.gridx = 0; gbc.gridy = 0;
        panelInterno.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        panelInterno.add(name, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelInterno.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        panelInterno.add(email, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panelInterno.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        panelInterno.add(password, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelInterno.add(button, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        panelInterno.add(indietroButton, gbc);


        // Aggiungendo panelInterno al CENTER, GridBagLayout dentro di lui
        // centra automaticamente il "blocco" di componenti nello spazio disponibile,
        // senza stirare i singoli campi
        this.add(panelInterno, BorderLayout.CENTER);

        indietroButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.changePanel("scelta");
            }
        });
    }
}