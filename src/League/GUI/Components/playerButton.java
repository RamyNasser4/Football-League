package League.GUI.Components;

import League.GUI.MainPanel;
import League.GUI.MatchInfo;
import League.GUI.PlayerInfo;
import League.Person.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class playerButton extends JButton implements ActionListener {
    CardLayout cardLayout;
    MainPanel main;
    Player player;
    public playerButton(String text, MainPanel main, CardLayout CARD , Player player){
        super(text);
        this.main=main;
        this.cardLayout=CARD;
        this.player = player;
    this.setBackground(Color.darkGray);
    this.setHorizontalTextPosition(SwingConstants.LEFT);
    this.setForeground(new Color(0xffffff));
    this.setFont (new Font("MVBoli",Font.PLAIN,20));
    this.addActionListener(this );
    this.setSize(550,100);
    this.setFocusable(false);
    this.setHorizontalAlignment(LEFT);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this){
            main.add(new PlayerInfo(player),"PLAYER");
            cardLayout.show(main,"PLAYER");
        }

    }
}
