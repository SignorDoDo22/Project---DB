package project.db.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.util.Map;

public class RegistrazionePanel extends JPanel {
    private JLabel codiceUtente;
    private JLabel username;
    private JLabel password;
    private JLabel email;
    private JLabel nome;
    private JLabel cognome;
    private Date dataDiNascita;
    private JLabel telefono;
    private MainView mainView;
    private JButton registratiButton;
    private JButton indietroButton;
    private JTextField codiceUtenteField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField dataDiNascitaField;
    private JTextField telefonoField;
    private Map<String, JTextField> userData;



    public RegistrazionePanel(MainView mainView) {
        this.mainView = mainView;
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 0; gbc.gridy = 0;
        this.add(new JLabel("Codice Utente:"), gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        this.codiceUtenteField = new JTextField(15);
        this.add(codiceUtenteField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        this.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        this.usernameField = new JTextField(15);
        this.add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        this.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        this.passwordField = new JPasswordField(15);
        this.add(passwordField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        this.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        this.emailField = new JTextField(15);
        this.add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        this.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        this.nomeField = new JTextField(15);
        this.add(nomeField, gbc);
        gbc.gridx = 0; gbc.gridy = 5;
        this.add(new JLabel("Cognome:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5;
        this.cognomeField = new JTextField(15);
        this.add(cognomeField, gbc);

        gbc.gridx = 0; gbc.gridy = 6;
        this.add(new JLabel("Data di Nascita:"), gbc);
        gbc.gridx = 1; gbc.gridy = 6;
        this.dataDiNascitaField = new JTextField(15);
        this.add(dataDiNascitaField, gbc);

        gbc.gridx = 0; gbc.gridy = 7;
        this.add(new JLabel("Telefono:"), gbc);
        gbc.gridx = 1; gbc.gridy = 7;
        this.telefonoField = new JTextField(15);
        this.add(telefonoField, gbc);
        this.registratiButton = new JButton("Registrati");
        this.indietroButton = new JButton("Indietro");
        gbc.gridx = 0; gbc.gridy = 8;
        this.add(registratiButton, gbc);
        gbc.gridx = 0; gbc.gridy = 9;
        this.add(indietroButton, gbc);
        this.userData = Map.of(
                "codiceUtente", codiceUtenteField,
                "username", usernameField,
                "password", passwordField,
                "email", emailField,
                "nome", nomeField,
                "cognome", cognomeField,
                "dataDiNascita", dataDiNascitaField,
                "telefono", telefonoField
        );

        this.indietroButton.addActionListener(e -> mainView.changePanel("login"));
        this.registratiButton.addActionListener(e -> {
            if(mainView.tryRegistration()) {
                System.out.println("Registrazione avvenuta con successo!");
                mainView.changePanel("scelta");
            } else {
                System.out.println("Registrazione fallita. Controlla i dati inseriti.");
            }
        });
    }

    public  Map<String, JTextField> getUserData() {
        return userData;
    }


}
