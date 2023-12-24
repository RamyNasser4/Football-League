package League.GUI;

import League.League;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamHome extends JPanel implements ActionListener{
    JButton addTeamButton;
    JButton editTeamButton;
    JButton deleteTeamButton;
    MainPanel main;
    CardLayout cardLayout;
    League league;
    public TeamHome(MainPanel main, CardLayout cardLayout,League league){
        this.main = main;
        this.cardLayout = cardLayout;
        this.league = league;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(3, 1));
        JPanel addTeamPanel = new JPanel(new GridLayout(1, 1));
        JPanel editTeamPanel = new JPanel(new GridLayout(1, 1));
        JPanel deleteTeamPanel = new JPanel(new GridLayout(1, 1));
        this.setVisible(true);
        //Add Team button
        addTeamButton=new JButton("Add Team");
        addTeamButton.setFocusable(false);
        ImageIcon addTeamIcon = new ImageIcon("src/Assets/add-team.png");
        addTeamButton.setIcon(addTeamIcon);
        addTeamButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        addTeamButton.setIconTextGap(10);
        addTeamButton.addActionListener(this);
        //Edit Team Button
        editTeamButton=new JButton("Edit Team");
        editTeamButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        editTeamButton.setFocusable(false);
        editTeamButton.addActionListener(this);
        ImageIcon editTeamIcon =new ImageIcon("src/Assets/edit-team.png");
        editTeamButton.setIcon(editTeamIcon);
        editTeamButton.setIconTextGap(10);
        //Delete Team Button
        deleteTeamButton=new JButton("Delete Team");
        deleteTeamButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        deleteTeamButton.setFocusable(false);
        ImageIcon removeTeamIcon =new ImageIcon("src/Assets/remove-team.png");
        deleteTeamButton.setIcon(removeTeamIcon);
        deleteTeamButton.setIconTextGap(10);
        deleteTeamButton.addActionListener(this);
        addTeamPanel.add(addTeamButton);
        editTeamPanel.add(editTeamButton);
        deleteTeamPanel.add(deleteTeamButton);
        this.add(addTeamPanel);
        this.add(editTeamPanel);
        this.add(deleteTeamPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTeamButton){
            cardLayout.show(main,"AddTeam");
        } else if (e.getSource() == editTeamButton) {
            try {
                if (league.getTeams().isEmpty()){
                    throw new Exception("Add teams first");
                }
                cardLayout.show(main,"EditTeam");
            }catch (Exception exp){
                JOptionPane.showConfirmDialog(this,exp.getMessage(),"Add teams first",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == deleteTeamButton) {
            try {
                if (league.getTeams().isEmpty()){
                    throw new Exception("Add teams first");
                }
                cardLayout.show(main,"DeleteTeam");
            }catch (Exception exp){
                JOptionPane.showConfirmDialog(this,exp.getMessage(),"Add teams first",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
