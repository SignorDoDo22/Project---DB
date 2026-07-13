package project.db.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LoginPanel extends JPanel {

    private JButton button;
    private JTextArea name;
    private JTextArea password;
    private JTextArea email;

    public LoginPanel(){
        this.setVisible(true);
        this.button = new JButton("inserisci");
        this.name = new JTextArea("nome");
        this.password = new JTextArea("password");
        this.email = new JTextArea("email");
        this.setLayout(new GridLayout(4,1));
        this.add(button);
        this.add(name);
        this.add(password);
        this.add(email);
    }

}
