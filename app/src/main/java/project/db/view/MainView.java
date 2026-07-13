package project.db.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainView extends JFrame {

    private JPanel mainPanel;
    private JPanel cards;
    private LoginPanel loginPanel;
    private JButton ClientButton;
    private JButton RiderButton;
    private JButton AdminButton;
    private JPanel buttonPanel;
    private JPanel esperimentoPanel;
    private JPanel new_panel;
    private JPanel login_panel2;

    public MainView(){

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Fast Food System");
        this.setLayout(new BorderLayout());
        this.mainPanel = new JPanel();
        this.esperimentoPanel = new JPanel();
        this.loginPanel = new LoginPanel();
        this.ClientButton = new JButton("Client");
        this.RiderButton = new JButton("Rider");
        this.AdminButton = new JButton("Admin");
        this.buttonPanel = new JPanel();
        this.login_panel2 = new JPanel();

        this.login_panel2.add(new JButton("DODO"));


        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
        this.setSize(1000,700);
        this.setResizable(false);
        this.esperimentoPanel.setLayout(new CardLayout());
        this.esperimentoPanel.add(loginPanel, "login");
        this.esperimentoPanel.add(login_panel2, "login2");

        this.add(esperimentoPanel, BorderLayout.CENTER);

        this.buttonPanel.setLayout(new GridLayout(3,1));
        this.buttonPanel.add(ClientButton);
        this.buttonPanel.add(RiderButton);
        this.buttonPanel.add(AdminButton);

        this.AdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(esperimentoPanel.getLayout());
                cl.show(esperimentoPanel, "login2");
            }
        });
    }



}
