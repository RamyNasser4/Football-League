package League.GUI;

import League.League;
import League.Person.Player.Goalkeeper;
import League.Team.Team;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class DeletePlayer extends JPanel implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deleteButton){
         try {
             String pName = (String) nameComboBox.getItemAt(nameComboBox.getSelectedIndex());
             String pTeam = (String) teamComboBox.getItemAt(teamComboBox.getSelectedIndex());
             if(pName==null) {
                 throw new Exception();
             }
             if(league.searchTeam(pTeam).searchPlayer(pName).getCaptain()){
                 league.searchTeam(pTeam).searchPlayer(pName).setCaptain(false);
                 league.searchTeam(pTeam).setCaptain(null);
             }
             if(league.searchTeam(pTeam).searchPlayer(pName) instanceof Goalkeeper){
                 --league.searchTeam(pTeam).noOfGoalkeepers;
             }
             Team searchTeam = league.searchTeam(pTeam);
             searchTeam.deletePlayer(pName);
             main.add(new DeletePlayer(league.teamNames, league, main, cardLayout), "DeletePlayer");
             main.add(new EditPlayer(league.teamNames,league,main,cardLayout),"EditPlayer");
             main.add(new AddPlayer(league.teamNames,league,main,cardLayout),"AddPlayer");
             main.add(new Players(main,cardLayout,league),"Stats");
             cardLayout.show(main, "PlayerHome");
             JOptionPane.showMessageDialog(null, "Player deleted successfully");
         }
         catch(Exception exception){
             JOptionPane.showMessageDialog(null, "No Players to delete");
         }
        }
        else if(e.getSource()==teamComboBox){
           nameComboBox.removeAllItems();
           Team team=league.searchTeam((String) teamComboBox.getItemAt(teamComboBox.getSelectedIndex()));
           for(String p:team.getPlayernames()){
               nameComboBox.addItem(p);
           }

        }
    }
   JButton deleteButton;
    JComboBox teamComboBox;
    JComboBox nameComboBox;
    League league;
    MainPanel main;
    CardLayout cardLayout;

    public DeletePlayer(ArrayList<String> teamnames, League league,MainPanel main,CardLayout cardLayout){
        this.main = main;
        this.league=league;
        this.cardLayout=cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(4, 1));

        JPanel titlePanel = new JPanel(new GridLayout(2, 1,0,0));
        JPanel contentPanel=new JPanel(new GridLayout(3, 1));
        JLabel titleLabel = new JLabel("Delete Player");
        JLabel title2Label = new JLabel("Search by Team and Name");
        title2Label.setFont(new Font("Comic Sans",Font.BOLD,15));
        title2Label.setVerticalAlignment(JLabel.TOP);
        title2Label.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        titlePanel.add(title2Label);


        JPanel teamPanel = new JPanel(new GridLayout(1, 1));
        JLabel teamLabel = new JLabel("Player Team");
        teamLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        teamPanel.add(teamLabel);
        teamComboBox = new JComboBox(new DefaultComboBoxModel<>(teamnames.toArray()));
        teamComboBox.addActionListener(this);
        teamPanel.add(teamComboBox);
        contentPanel.add(teamPanel);
        this.add(titlePanel);
        this.add(contentPanel);

        String team;
        try {
            team = (String) teamComboBox.getItemAt(teamComboBox.getSelectedIndex());
        }
        catch(NullPointerException exp){
            team="null";
            JOptionPane.showMessageDialog(null, "No teams exist");
        }

        JPanel namePanel = new JPanel(new GridLayout(1, 1));
        JLabel nameLabel = new JLabel("Player Name");
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        namePanel.add(nameLabel);
        nameComboBox =new JComboBox(new DefaultComboBoxModel<>(league.searchTeam(team).getPlayernames().toArray()));
        namePanel.add(nameComboBox);
        contentPanel.add(namePanel);


        String name;
        try {
            name = (String) nameComboBox.getItemAt(nameComboBox.getSelectedIndex());
        }
        catch(NullPointerException exp){
            name="null";
            JOptionPane.showMessageDialog(null, "No teams exist");
        }
         deleteButton=new JButton("Delete");
        deleteButton.setFocusable(false);
        deleteButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        deleteButton.addActionListener(this);
        contentPanel.add(deleteButton);



    }
}
