package League.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeagueHome extends JPanel implements ActionListener {
    JButton addMatchButton;
    JButton editMatchButton;
    JButton deleteMatchButton;
    MainPanel main;
    CardLayout cardLayout;
    public LeagueHome(MainPanel main,CardLayout cardLayout){
        this.main = main;
        this.cardLayout = cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(3, 1));
        JPanel addMatchPanel = new JPanel(new GridLayout(1, 1));
        JPanel editMatchPanel = new JPanel(new GridLayout(1, 1));
        JPanel deleteMatchPanel = new JPanel(new GridLayout(1, 1));
        this.setVisible(true);
        //Add Team button
        addMatchButton=new JButton("Add Match");
        addMatchButton.setFocusable(false);
        ImageIcon addMatchIcon = new ImageIcon("src/Assets/match-add.png");
        addMatchButton.setIcon(addMatchIcon);
        addMatchButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        addMatchButton.setIconTextGap(10);
        addMatchButton.addActionListener(this);
        //Edit Team Button
        editMatchButton=new JButton("Edit Match");
        editMatchButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        editMatchButton.setFocusable(false);
        editMatchButton.addActionListener(this);
        ImageIcon editMatchIcon =new ImageIcon("src/Assets/match-edit.png");
        editMatchButton.setIcon(editMatchIcon);
        editMatchButton.setIconTextGap(10);
        //Delete Team Button
        deleteMatchButton=new JButton("Delete Match");
        deleteMatchButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        deleteMatchButton.setFocusable(false);
        ImageIcon removeTeamIcon =new ImageIcon("src/Assets/match-delete.png");
        deleteMatchButton.setIcon(removeTeamIcon);
        deleteMatchButton.setIconTextGap(10);
        deleteMatchButton.addActionListener(this);
        addMatchPanel.add(addMatchButton);
        editMatchPanel.add(editMatchButton);
        deleteMatchPanel.add(deleteMatchButton);
        this.add(addMatchPanel);
        this.add(editMatchPanel);
        this.add(deleteMatchPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addMatchButton){
            cardLayout.show(main,"AddMatch");
        } else if (e.getSource() == editMatchButton) {
            cardLayout.show(main,"EditMatch");
        } else if (e.getSource() == deleteMatchButton) {
            cardLayout.show(main,"DeleteMatch");
        }
    }
}
