package League.GUI;

import League.GUI.Components.MatchButton;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class Matches extends JPanel {
    public Matches(){
        this.setPreferredSize(new Dimension(980,720));
        this.setBackground(new Color(0x2a2c2f));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        //filter button
        JButton filter = new JButton("Filter");
        filter.setBackground(new Color(0x2a2c2f));
        filter.setForeground(Color.white);
        filter.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        filter.setFocusable(false);
        Border line = BorderFactory.createLineBorder(Color.white,2);
        Border empty = BorderFactory.createEmptyBorder(5,15,5,15);
        filter.setBorder(new CompoundBorder(line,empty));
        JPanel filterContainer = new JPanel();
        filterContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
        filterContainer.setBackground(new Color(0x2a2c2f));
        filterContainer.setMaximumSize(new Dimension(Integer.MAX_VALUE,60));
        filterContainer.add(filter);
        this.add(filterContainer);
        JLabel upcoming = new JLabel("Upcoming Matches");
        upcoming.setForeground(Color.white);
        upcoming.setBackground(new Color(0x2a2c2f));
        upcoming.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
        upcoming.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));
        this.add(upcoming);
        upcoming.setAlignmentX(0.5f);
        MatchButton match1 = new MatchButton("Team 1 vs Team 2");
        this.add(match1);
    }
}
