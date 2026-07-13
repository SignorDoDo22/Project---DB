package project.db.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AdminPanel extends JPanel {

    JButton buttonLogin;
    JTextArea name;
    JTextArea password;

    public AdminPanel(){

        this.setVisible(true);
        this.setLayout(new GridLayout(3,1));
        this.buttonLogin = new JButton("inserisci");
        this.name = new JTextArea("nome");
        this.password = new JTextArea("password");
        this.add(buttonLogin);
        this.add(name);
        this.add(password);
    }


}
