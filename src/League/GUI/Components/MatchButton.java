package League.GUI.Components;

import League.GUI.GUI;
import League.GUI.MainPanel;
import League.GUI.MatchInfo;
import League.GUI.Matches;
import League.Match.Match;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatchButton extends JButton implements ActionListener{
    CardLayout cardLayout;
    MainPanel main;
    Match match;
    public MatchButton(String text, MainPanel main, CardLayout cardLayout, Match match){
        super(text);
        this.main = main;
        this.cardLayout = cardLayout;
        this.match = match;
        this.setForeground(Color.white);
        this.setBackground(Color.darkGray);
        this.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
        this.setFocusable(false);
        this.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        this.setAlignmentX(0.5f);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this){
            main.add(new MatchInfo(match),"Match " + match.getMatch_ID());
            cardLayout.show(main,"Match " + match.getMatch_ID());
        }
    }
}
