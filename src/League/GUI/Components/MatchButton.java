package League.GUI.Components;

import League.GUI.GUI;
import League.GUI.MainPanel;
import League.GUI.MatchInfo;
import League.GUI.Matches;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatchButton extends JButton implements ActionListener{
    CardLayout cardLayout;
    MainPanel main;
    public MatchButton(String text,MainPanel main,CardLayout cardLayout){
        super(text);
        this.main = main;
        this.cardLayout = cardLayout;
        this.setForeground(Color.white);
        this.setBackground(new Color(0x313741));
        this.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
        this.setFocusable(false);
        this.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        this.setAlignmentX(0.5f);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this){
            main.add(new MatchInfo(),"Match 1");
            cardLayout.show(main,"Match 1");
            /*matches.setVisible(false);
            gui.validate();
            gui.add(new MatchInfo());*/
            System.out.println("clicked");
        }
    }
}
