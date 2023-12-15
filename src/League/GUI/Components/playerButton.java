package League.GUI.Components;

import League.GUI.MainPanel;
import League.GUI.MatchInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class playerButton extends JButton implements ActionListener {
    CardLayout cardLayout;
    MainPanel main;
    public playerButton(String text,MainPanel main,CardLayout CARD  ){
        super(text);
        this.main=main;
        this.cardLayout=CARD;
    this.setBackground(Color.darkGray);
    this.setHorizontalTextPosition(SwingConstants.LEFT);
    this.setForeground(new Color(0xffffff));
    this.setFont (new Font("MVBoli",Font.PLAIN,20));
    this.addActionListener(this );
    this.setSize(550,100);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this){
            main.add(new MatchInfo(),"PLAYER");
            cardLayout.show(main,"PLAYER");
        }

    }
}
