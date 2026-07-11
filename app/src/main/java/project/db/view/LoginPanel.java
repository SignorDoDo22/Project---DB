package project.db.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LoginPanel {

    private JPanel loginPanel;
    private JButton button;
    private JTextArea name;
    private JTextArea password;
    private JTextArea email;

    public LoginPanel(){
        this.loginPanel = new JPanel();
        this.button = new JButton("inserisci");


    }

}
