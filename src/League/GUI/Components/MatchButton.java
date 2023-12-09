package League.GUI.Components;

import League.GUI.GUI;
import League.GUI.MatchInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatchButton extends JButton{
    GUI gui;
    MatchInfo matchInfo;
    public MatchButton(String text){
        super(text);
        this.setForeground(Color.white);
        this.setBackground(new Color(0x2a2c2f));
        this.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
        this.setFocusable(false);
        this.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        this.setAlignmentX(0.5f);
    }
}
