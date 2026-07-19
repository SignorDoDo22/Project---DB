package project.db.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

    private JTextField name;
    private JPasswordField password;
    private JTextField email;
    private JPanel panelInterno;
    private MainView mainView;
    private JButton indietroButton;
    private JButton loginButton;
    private JButton registratiButton;
    private Map<String, JTextField> userData;

    public LoginPanel(final MainView mainView) {
        userData = new HashMap<>();
        this.setLayout(new BorderLayout());
        this.mainView = mainView;
        this.panelInterno = new JPanel();
        this.panelInterno.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.NONE;

        this.name = new JTextField(15);       // 15 colonne = dimensione ragionevole
        this.password = new JPasswordField(15);
        this.email = new JTextField(15);
        this.indietroButton = new JButton("Indietro");
        this.loginButton = new JButton("Login");
        this.registratiButton = new JButton("Registrati");

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
        panelInterno.add(registratiButton, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panelInterno.add(indietroButton, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        panelInterno.add(loginButton, gbc);

        // Aggiungendo panelInterno al CENTER, GridBagLayout dentro di lui
        // centra automaticamente il "blocco" di componenti nello spazio disponibile,
        // senza stirare i singoli campi
        this.add(panelInterno, BorderLayout.CENTER);

        this.indietroButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.changePanel("scelta");
            }
        });

        this.loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainView.tryLogin()){
                    mainView.changePanel("client");
                } else {
                    System.out.println("Login fallito nel panel");
                }
            }
        });

        this.registratiButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Registrati button clicked");
                mainView.changePanel("registration");
            }
        });

    }


    public Map<String, JTextField> getUserData() {
        userData.put("name", name);
        userData.put("email", email);
        userData.put("password", password);
        return userData;
    }
}