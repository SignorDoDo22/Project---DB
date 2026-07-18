package project.db.view.ProdottoCatalogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProdottoCardEast extends JPanel {

    private ProdottoCard mainViewCard;
    private JButton aggiungi;
    private JButton info;

    public ProdottoCardEast(final ProdottoCard mainViewCard){
        this.mainViewCard = mainViewCard;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.aggiungi = new JButton("aggiungi");
        this.info = new JButton("info");

        this.info.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

        });

        this.aggiungi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

        });
    }


}
