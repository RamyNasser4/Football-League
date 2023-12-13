package League.GUI;

import League.GUI.Components.MatchButton;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class Matches extends JPanel {
    public Matches(MainPanel main, CardLayout cardLayout) {
        this.setPreferredSize(new Dimension(980, 720));
        this.setBackground(new Color(0x313741));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        //filter button
        JButton filter = new JButton("Filter");
        filter.setBackground(new Color(0x313741));
        filter.setForeground(Color.white);
        filter.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        filter.setFocusable(false);
        Border line = BorderFactory.createLineBorder(Color.white, 2);
        Border empty = BorderFactory.createEmptyBorder(5, 15, 5, 15);
        filter.setBorder(new CompoundBorder(line, empty));
        JPanel filterContainer = new JPanel();
        filterContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
        filterContainer.setBackground(new Color(0x313741));
        filterContainer.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        filterContainer.add(filter);
        this.add(filterContainer);
        JLabel upcoming = new JLabel("Upcoming Matches");
        upcoming.setForeground(Color.white);
        upcoming.setBackground(new Color(0x313741));
        upcoming.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        upcoming.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        this.add(upcoming);
        upcoming.setAlignmentX(0.5f);
        MatchButton match1 = new MatchButton("Team 1 vs Team 2", main, cardLayout);
        this.add(match1);
    }
}
