package League.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import League.GUI.Components.playerButton;

public class searchBYplayer extends JPanel implements ActionListener {
    JButton SEARCH;
    JButton TOPSCORERS;
    JButton TOPGKS;
    public searchBYplayer(MainPanel main, CardLayout CARD) {
        this.setBackground(Color.white);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Use Y_AXIS for vertical alignment
        this.setPreferredSize(new Dimension(980, 720));

         TOPGKS =new JButton();
        TOPGKS.setText("TopGKS");
        TOPGKS.setFont(new Font("MVBoli",Font.PLAIN,30));
        TOPGKS.setBackground(Color.GRAY);
        TOPGKS.setPreferredSize(new Dimension(10,50));


        TOPSCORERS=new JButton();
        TOPSCORERS.setText("TopScorers");
        TOPSCORERS.setFont(new Font("MVBoli",Font.PLAIN,30));
        TOPSCORERS.setBackground(Color.GRAY);
        TOPSCORERS.setPreferredSize(new Dimension(10,50));

         SEARCH =new JButton();
        SEARCH.setText("Search");
        SEARCH.setFont(new Font("MVBoli",Font.PLAIN,30));
        SEARCH.setBackground(Color.GRAY);
        SEARCH.setPreferredSize(new Dimension(10,50));
        SEARCH.addActionListener(this);


        JPanel PANELS = new JPanel(new GridLayout(1, 3));
        PANELS.add(SEARCH);
        PANELS.add(TOPGKS);
        PANELS.add(TOPSCORERS);
        this.add(PANELS);


        playerButton player1 = new playerButton("name:                                         age:              team:                           Goals:                assists:            ", main, CARD);
        playerButton player2 = new playerButton("name:                                         age:              team:                           Goals:                assists:            ", main, CARD);
        playerButton player3 = new playerButton("name:                                         age:              team:                           Goals:                assists:            ", main, CARD);
        playerButton player4 = new playerButton("name:                                         age:              team:                           Goals:                assists:            ", main, CARD);

        JPanel PANEL1 = new JPanel(new GridLayout(1, 1));
        JPanel PANEL2 = new JPanel(new GridLayout(1, 2));
        JPanel PANEL3 = new JPanel(new GridLayout(1, 1));
        JPanel PANEL4 = new JPanel(new GridLayout(1, 1));

        this.add(PANEL1);
        this.add(PANEL2);
        this.add(PANEL3);
        this.add(PANEL4);
        PANEL1.setSize(980,50);
        PANEL2.setSize(980,50);
        PANEL3.setSize(980,50);
        PANEL4.setSize(980,50);

        PANEL1.add(player1);
        PANEL2.add(player2);
        PANEL3.add(player3);
        PANEL4.add(player4);
        player1.setHorizontalAlignment(SwingConstants.LEFT);
        player4.setHorizontalAlignment(SwingConstants.LEFT);
        player2.setHorizontalAlignment(SwingConstants.LEFT);
        player3.setHorizontalAlignment(SwingConstants.LEFT);

        // Set background color for playerButtons if needed
        player1.setBackground(Color.DARK_GRAY);
        player2.setBackground(Color.DARK_GRAY);
        player3.setBackground(Color.DARK_GRAY);
        player4.setBackground(Color.DARK_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==SEARCH){
            String input =JOptionPane.showInputDialog("enter the player name");
        }

    }
}



