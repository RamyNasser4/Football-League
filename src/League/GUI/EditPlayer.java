package League.GUI;
import League.League;
import League.Person.Player.*;
import League.Team.Team;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static League.League.searchByNameAndTeam;
import League.Team.Team;
public class EditPlayer extends JPanel implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==searchButton){
        try {
            pName = (String) nameComboBox.getItemAt(nameComboBox.getSelectedIndex());
            pTeam = (String) teamComboBox.getItemAt(teamComboBox.getSelectedIndex());
            if(pName==null) {
                throw new Exception();
            }
                //removeAll();
                DisplayFields();
                revalidate();
                repaint();


        }
        catch(Exception exception){
            JOptionPane.showMessageDialog(null, "No Players to edit");
        }
    }
    else if(e.getSource()==teamComboBox){

        //removeAll();
        DisplayFields();
        revalidate();
        repaint();

        nameComboBox.removeAllItems();
        Team team=league.searchTeam((String) teamComboBox.getItemAt(teamComboBox.getSelectedIndex()));
        for(String p:team.getPlayernames()){
            nameComboBox.addItem(p);
        }
    }
    }
    JComboBox teamComboBox;
    JButton searchButton;
    String pTeam;
    String pName;
    JComboBox nameComboBox;
    JPanel contentPanel;
    League league;
    MainPanel main;
    CardLayout cardLayout;
    public EditPlayer(ArrayList<String> teamnames, League league,MainPanel main,CardLayout cardLayout) {

        this.main = main;
        this.league = league;
        this.cardLayout = cardLayout;

        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(4, 1));
        JPanel titlepanel = new JPanel(new GridLayout(2, 1, 0, 0));
        contentPanel = new JPanel(new GridLayout(3, 1));
        JLabel titleLabel = new JLabel("Edit Player");
        JLabel title2Label = new JLabel("Search by Team and Name");
        title2Label.setFont(new Font("Comic Sans", Font.BOLD, 15));
        title2Label.setVerticalAlignment(JLabel.TOP);
        title2Label.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlepanel.add(titleLabel);
        titlepanel.add(title2Label);

        JPanel teampanel = new JPanel(new GridLayout(1, 1));
        JLabel teamLabel = new JLabel("Player Team");
        teamLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        teampanel.add(teamLabel);
        teamComboBox = new JComboBox(new DefaultComboBoxModel<>(teamnames.toArray()));
        teamComboBox.addActionListener(this);
        teampanel.add(teamComboBox);
        contentPanel.add(teampanel);

        String team;
        try {
            team = (String) teamComboBox.getItemAt(teamComboBox.getSelectedIndex());
            System.out.println(team);
        } catch (NullPointerException exp) {
            team = "null";
            JOptionPane.showMessageDialog(null, "No teams exist");
        }

        JPanel namepanel = new JPanel(new GridLayout(1, 1));
        JLabel nameLabel = new JLabel("Player Name");
        nameLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        namepanel.add(nameLabel);
        nameComboBox = new JComboBox(new DefaultComboBoxModel<>(league.searchTeam(team).getPlayernames().toArray()));
        namepanel.add(nameComboBox);
        contentPanel.add(namepanel);
        this.add(titlepanel);
        this.add(contentPanel);


        searchButton = new JButton("Search");
        searchButton.setFocusable(false);
        searchButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        searchButton.addActionListener(this);
        contentPanel.add(searchButton);
    }
   /* public boolean Validation(String name,String team ){
        if(pName.isEmpty()||pTeam.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }*/
    public void DisplayFields(){
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(4, 1));
        Player playerToEdit=league.searchTeam(pTeam).searchPlayer(pName);
        JPanel namepanel = new JPanel(new GridLayout(1, 1));
        JLabel nameLabel = new JLabel("Name");
        namepanel.add(nameLabel);
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        JTextField nameFeild = new JTextField(playerToEdit.getPersonName());
        namepanel.add(nameFeild);
        contentPanel.add(namepanel);


        JPanel agepanel = new JPanel(new GridLayout(1, 1));
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        JTextField ageField = new JTextField(Integer.toString(playerToEdit.GetPlayerAge()));
        agepanel.add(ageLabel);
        agepanel.add(ageField);
        contentPanel.add(agepanel);

        JPanel rankpanel = new JPanel(new GridLayout(1, 1));
        JLabel rankLabel = new JLabel("Rank");
        rankLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        rankpanel.add(rankLabel);
        JTextField rankField = new JTextField(Integer.toString(playerToEdit.GetPlayerRank()));
        rankpanel.add(rankField);
        contentPanel.add(rankpanel);

        JPanel numberpanel = new JPanel(new GridLayout(1, 1));
        JLabel numberLabel = new JLabel("T-shirt number");
        numberLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        numberpanel.add(numberLabel);
        JTextField numberField = new JTextField(Integer.toString(playerToEdit.GetPlayerNumber()));
        numberpanel.add(numberField);
        contentPanel.add(numberpanel);

        JPanel captainpanel = new JPanel(new GridLayout(1, 1));
        JLabel captainLabel = new JLabel("Team Captain");
        captainLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        captainpanel.add(captainLabel);
        String capbool[]={"No","Yes"};
        String capbool2[]={"Yes","No"};
        if(playerToEdit.getCaptain()) {
            JComboBox captainComboBox = new JComboBox(capbool2);
            captainpanel.add(captainComboBox);
            contentPanel.add(captainpanel);
        }
        else {
            JComboBox captainComboBox = new JComboBox(capbool);
            captainpanel.add(captainComboBox);
            contentPanel.add(captainpanel);
        }


        JPanel positionspanel = new JPanel(new GridLayout(1, 1));
        JLabel positionsLabel = new JLabel("Position");
        positionsLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        positionspanel.add(positionsLabel);
        String goalKeeper[]={"GoalKeeper","Defender","Midfielder","Forward"};
        String defender[]={"Defender","GoalKeeper","Midfielder","Forward"};
        String midfielder[]={"Midfielder","Defender","GoalKeeper","Forward"};
        String forward[]={"Forward","Midfielder","Defender","GoalKeeper"};
        if(playerToEdit instanceof Forward){
            JComboBox positionsComboBox =new JComboBox(forward);
            positionspanel.add(positionsComboBox);
        }
        else if (playerToEdit instanceof Defender){
            JComboBox positionsComboBox =new JComboBox(defender);
            positionspanel.add(positionsComboBox);
        }
        else if (playerToEdit instanceof Midfielder){
            JComboBox positionsComboBox =new JComboBox(midfielder);
            positionspanel.add(positionsComboBox);
        }
        else{
            JComboBox positionsComboBox =new JComboBox(goalKeeper);
            positionspanel.add(positionsComboBox);
        }
        contentPanel.add(positionspanel);
    }


}
