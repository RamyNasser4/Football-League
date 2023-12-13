package League.GUI;

import League.GUI.Components.SideBarButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideBar extends JPanel implements ActionListener {
    SideBarButton matches;
    SideBarButton teams;
    SideBarButton players;
    SideBarButton standings;
    CardLayout cardLayout;
    MainPanel main;

    public SideBar(MainPanel main, CardLayout cardLayout) {
        this.cardLayout = cardLayout;
        this.main = main;
        this.setPreferredSize(new Dimension(300, 720));
        this.setBackground(new Color(0x2a2c2f));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(CENTER_ALIGNMENT);
        matches = new SideBarButton("Matches");
        teams = new SideBarButton("Teams");
        players = new SideBarButton("Players");
        standings = new SideBarButton("Standings");
        matches.addActionListener(this);
        teams.addActionListener(this);
        players.addActionListener(this);
        standings.addActionListener(this);
        this.add(matches);
        this.add(teams);
        this.add(players);
        this.add(standings);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == matches) {
            cardLayout.show(main, "Matches");
        } else if (e.getSource() == teams) {

        } else if (e.getSource() == players) {
            cardLayout.show(main, "PlayerGUI");
        } else if (e.getSource() == standings) {
            cardLayout.show(main, "Standings");
        }
    }
}
