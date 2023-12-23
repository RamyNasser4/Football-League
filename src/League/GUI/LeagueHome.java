package League.GUI;

import League.League;

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
    League league;
    public LeagueHome(MainPanel main, CardLayout cardLayout,League league){
        this.main = main;
        this.cardLayout = cardLayout;
        this.league = league;
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
            try {
                if (league.getTeams().size() < 2){
                    throw new Exception("Add teams first");
                } else if (league.getStadiums().isEmpty()) {
                    throw new Exception("Add stadium first");
                } else if (league.getReferees().isEmpty()) {
                    throw new Exception("Add referee first");
                }
                cardLayout.show(main,"AddMatch");
            }catch (Exception exp){
                JOptionPane.showConfirmDialog(this,exp.getMessage(),exp.getMessage(),JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == editMatchButton) {
            try {
                if (league.getMatches().isEmpty()){
                    throw new Exception("Add matches first");
                }
                cardLayout.show(main,"EditMatch");
            }catch (Exception exp){
                JOptionPane.showConfirmDialog(this,exp.getMessage(),"Add matches first",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == deleteMatchButton) {
            try {
                if (league.getMatches().size() == 0){
                    throw new Exception("Add matches first");
                }
                cardLayout.show(main,"DeleteMatch");
            }catch (Exception exp){
                JOptionPane.showConfirmDialog(this,exp.getMessage(),"Add matches first",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
