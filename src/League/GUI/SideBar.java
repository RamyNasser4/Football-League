package League.GUI;

import League.GUI.Components.SideBarButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideBar extends JPanel {
    public SideBar(){
        this.setPreferredSize(new Dimension(300,720));
        this.setBackground(Color.black);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setAlignmentX(CENTER_ALIGNMENT);
        SideBarButton matches = new SideBarButton("Matches");
        SideBarButton teams = new SideBarButton("Teams");
        SideBarButton players = new SideBarButton("Players");
        SideBarButton standings = new SideBarButton("Standings");

                this.add(matches);
        this.add(teams);
        this.add(players);
        this.add(standings);
        this.setVisible(true);
    }
}
