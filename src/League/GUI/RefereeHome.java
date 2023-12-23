package League.GUI;

import League.League;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RefereeHome extends JPanel {
    MainPanel main;
    CardLayout cardlayout;
    League league;
    public RefereeHome (MainPanel main, CardLayout cardLayout, League league){
        this.main=main;
        this.league=league;
        this.cardlayout=cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(2, 1));
        JPanel panel1 = new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(1, 1));
        JPanel panel3 = new JPanel(new GridLayout(1, 1));
        ImageIcon addRefereeIcon =new ImageIcon("src/Assets/add-referee.png");
        this.setVisible(true);
        //Add Referee button
        JButton panel1Button=new JButton("Add Referee");
        panel1Button.setFocusable(false);
        panel1Button.setIcon(addRefereeIcon);
        panel1Button.setFont(new Font("Comic Sans",Font.BOLD,20));


        //Delete Referee Button
        JButton panel3Button=new JButton("Delete Referee");
        panel3Button.setFont(new Font("Comic Sans",Font.BOLD,20));
        panel3Button.setFocusable(false);
        ImageIcon removeRefereeIcon =new ImageIcon("src/Assets/delete-referee.png");
        panel3Button.setIcon(removeRefereeIcon);
        panel1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardlayout.show(main,"AddReferee");
            }
        });

        panel3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (league.getReferees().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"There is no Referees to delete.");
                }
                else {
                    cardlayout.show(main,"DeleteReferee");
                }
            }
        });
        panel1.add(panel1Button);
       // panel2.add(panel2Button);
        panel3.add(panel3Button);
        this.add(panel1);
        this.add(panel3);
    }

}
