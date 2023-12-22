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

        nameComboBox.removeAllItems();
        Team team=league.searchTeam((String) teamComboBox.getItemAt(teamComboBox.getSelectedIndex()));
        for(String p:team.getPlayernames()){
            nameComboBox.addItem(p);
        }
    }
    else if(e.getSource()==saveButton){
        String name = nameField.getText();
        String Age = ageField.getText();
        String rank =rankField.getText();
        String number =numberField.getText();

        if(!name.isEmpty() && !Age.isEmpty() && !rank.isEmpty() && !number.isEmpty() ){
            try{
            Integer.parseInt(Age);
            Integer.parseInt(rank);
            Integer.parseInt(number);
            String captain=(String) captainComboBox.getItemAt(captainComboBox.getSelectedIndex());
            if(captain.equals("Yes")&&league.searchTeam(pTeam).getCaptain()!=null && !league.searchTeam(pTeam).getCaptain().equals(league.searchTeam(pTeam).searchPlayer(pName))) {

                JOptionPane.showMessageDialog(null, "Only 1 captain is allowed in a team");
            }
            if(captain.equals("Yes")&&((league.searchTeam(pTeam).getCaptain()==null)||(league.searchTeam(pTeam).getCaptain().equals(league.searchTeam(pTeam).searchPlayer(pName))))){
                    Player p=league.searchTeam(pTeam).searchPlayer(pName);
                    p.setPersonName(name);
                    p.setPersonAge(Integer.parseInt(Age));
                    p.SetPlayerRank(Integer.parseInt(rank));
                    p.SetPlayerNumber(Integer.parseInt(number));
                    p.setCaptain(true);
                    league.searchTeam(pTeam).setCaptain(p);
                    System.out.println( "7"+league.searchTeam(pTeam).getCaptain().getPersonName());
                    JOptionPane.showMessageDialog(null, "Edited Successfully");
                    cardLayout.show(main,"PlayerHome");
                    main.add(new DeletePlayer(league.teamnames,league,main,cardLayout),"DeletePlayer");
                    main.add(new EditPlayer(league.teamnames,league,main,cardLayout),"EditPlayer");
                    main.add(new AddPlayer(league.teamnames,league,main,cardLayout),"AddPlayer");
                }

            else if (captain.equals("No")&&league.searchTeam(pTeam).searchPlayer(pName).getCaptain()){
                    Player p=league.searchTeam(pTeam).searchPlayer(pName);
                    p.setPersonName(name);
                    p.setPersonAge(Integer.parseInt(Age));
                    p.SetPlayerRank(Integer.parseInt(rank));
                    p.SetPlayerNumber(Integer.parseInt(number));
                    p.setCaptain(false);
                    league.searchTeam(pTeam).setCaptain(null);
                    System.out.println( "1"+league.searchTeam(pTeam).getCaptain().getPersonName());
                    JOptionPane.showMessageDialog(null, "Edited Successfully");
                    cardLayout.show(main,"PlayerHome");
                    main.add(new DeletePlayer(league.teamnames,league,main,cardLayout),"DeletePlayer");
                    main.add(new EditPlayer(league.teamnames,league,main,cardLayout),"EditPlayer");
                    main.add(new AddPlayer(league.teamnames,league,main,cardLayout),"AddPlayer");
                }

              else if(captain.equals("No")&&!league.searchTeam(pTeam).searchPlayer(pName).getCaptain()){
                    Player p=league.searchTeam(pTeam).searchPlayer(pName);
                    p.setPersonName(name);
                    p.setPersonAge(Integer.parseInt(Age));
                    p.SetPlayerRank(Integer.parseInt(rank));
                    p.SetPlayerNumber(Integer.parseInt(number));
                    p.setCaptain(false);
                    System.out.println( "11"+league.searchTeam(pTeam).getCaptain().getPersonName());
                    JOptionPane.showMessageDialog(null, "Edited Successfully");
                    cardLayout.show(main,"PlayerHome");
                    main.add(new DeletePlayer(league.teamnames,league,main,cardLayout),"DeletePlayer");
                    main.add(new EditPlayer(league.teamnames,league,main,cardLayout),"EditPlayer");
                    main.add(new AddPlayer(league.teamnames,league,main,cardLayout),"AddPlayer");
                }



            }
            catch(NumberFormatException exp) {
                JOptionPane.showMessageDialog(null, "Enter a valid number in number,age and rank");
            }
            catch(NullPointerException exp){
                Player p=league.searchTeam(pTeam).searchPlayer(pName);
                p.setPersonName(name);
                p.setPersonAge(Integer.parseInt(Age));
                p.SetPlayerRank(Integer.parseInt(rank));
                p.SetPlayerNumber(Integer.parseInt(number));
                p.setCaptain(false);
                league.searchTeam(p.GetPlayerTeam()).setCaptain(null);
                JOptionPane.showMessageDialog(null, "Edited Successfully");
                cardLayout.show(main,"PlayerHome");
                main.add(new DeletePlayer(league.teamnames,league,main,cardLayout),"DeletePlayer");
                main.add(new EditPlayer(league.teamnames,league,main,cardLayout),"EditPlayer");
                main.add(new EditPlayer(league.teamnames,league,main,cardLayout),"EditPlayer");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please fill all fields");
        }
    }
    }
    JComboBox teamComboBox;
    JComboBox nameComboBox;
    JComboBox captainComboBox;
    //JComboBox positionsComboBox;
    JButton searchButton;
    JButton saveButton;
    String pTeam;
    String pName;
    JPanel contentPanel;
    JPanel namepanel;
    JPanel teampanel;
    JPanel titlepanel;
    League league;
    MainPanel main;
    CardLayout cardLayout;
    JTextField nameField;
    JTextField ageField;
    JTextField rankField;
    JTextField numberField;
    public EditPlayer(ArrayList<String> teamnames, League league,MainPanel main,CardLayout cardLayout) {

        this.main = main;
        this.league = league;
        this.cardLayout = cardLayout;

        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(4, 1));
        titlepanel = new JPanel(new GridLayout(2, 1, 0, 0));
        contentPanel = new JPanel(new GridLayout(3, 1));
        JLabel titleLabel = new JLabel("Edit Player");
        JLabel title2Label = new JLabel("Search by Team and Name");
        title2Label.setFont(new Font("Comic Sans", Font.BOLD, 15));
        title2Label.setVerticalAlignment(JLabel.TOP);
        title2Label.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlepanel.add(titleLabel);
        titlepanel.add(title2Label);

         teampanel = new JPanel(new GridLayout(1, 1));
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

         namepanel = new JPanel(new GridLayout(1, 1));
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

    public void DisplayFields(){
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(1, 1,0,0));
        contentPanel .setLayout(new GridLayout(8, 1,0,30));
        Player playerToEdit;
        try {
            playerToEdit = league.searchTeam(pTeam).searchPlayer(pName);
       }
       catch(NullPointerException exp){
           playerToEdit=null;

       }
        this.remove(titlepanel);
        contentPanel.remove(searchButton);
        contentPanel.remove(namepanel);
        contentPanel.remove(teampanel);
        contentPanel.add(titlepanel);
        JPanel namepanel = new JPanel(new GridLayout(1, 1));
        JLabel nameLabel = new JLabel("Name");
        namepanel.add(nameLabel);
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        nameField = new JTextField(playerToEdit.getPersonName());
        namepanel.add(nameField);
        contentPanel.add(namepanel);


        JPanel agepanel = new JPanel(new GridLayout(1, 1));
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        ageField = new JTextField(Integer.toString(playerToEdit.GetPlayerAge()));
        agepanel.add(ageLabel);
        agepanel.add(ageField);
        contentPanel.add(agepanel);

        JPanel rankpanel = new JPanel(new GridLayout(1, 1));
        JLabel rankLabel = new JLabel("Rank");
        rankLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        rankpanel.add(rankLabel);
        rankField = new JTextField(Integer.toString(playerToEdit.GetPlayerRank()));
        rankpanel.add(rankField);
        contentPanel.add(rankpanel);

        JPanel numberpanel = new JPanel(new GridLayout(1, 1));
        JLabel numberLabel = new JLabel("T-shirt number");
        numberLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        numberpanel.add(numberLabel);
        numberField = new JTextField(Integer.toString(playerToEdit.GetPlayerNumber()));
        numberpanel.add(numberField);
        contentPanel.add(numberpanel);

        JPanel captainpanel = new JPanel(new GridLayout(1, 1));
        JLabel captainLabel = new JLabel("Team Captain");
        captainLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        captainpanel.add(captainLabel);
        String capbool[]={"No","Yes"};
        String capbool2[]={"Yes","No"};
        if(playerToEdit.getCaptain()) {
            captainComboBox = new JComboBox(capbool2);
            captainpanel.add(captainComboBox);
            contentPanel.add(captainpanel);
        }
        else {
            captainComboBox = new JComboBox(capbool);
            captainpanel.add(captainComboBox);
            contentPanel.add(captainpanel);
        }


        /*JPanel positionspanel = new JPanel(new GridLayout(1, 1));
        JLabel positionsLabel = new JLabel("Position");
        positionsLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        positionspanel.add(positionsLabel);
        String goalKeeper[]={"GoalKeeper","Defender","Midfielder","Forward"};
        String defender[]={"Defender","GoalKeeper","Midfielder","Forward"};
        String midfielder[]={"Midfielder","Defender","GoalKeeper","Forward"};
        String forward[]={"Forward","Midfielder","Defender","GoalKeeper"};
        if(playerToEdit instanceof Forward){
            positionsComboBox =new JComboBox(forward);
            positionspanel.add(positionsComboBox);
        }
        else if (playerToEdit instanceof Defender){
            positionsComboBox =new JComboBox(defender);
            positionspanel.add(positionsComboBox);
        }
        else if (playerToEdit instanceof Midfielder){
            positionsComboBox =new JComboBox(midfielder);
            positionspanel.add(positionsComboBox);
        }
        else{
            positionsComboBox =new JComboBox(goalKeeper);
            positionspanel.add(positionsComboBox);
        }
        contentPanel.add(positionspanel);*/

        saveButton = new JButton("Save");
        saveButton.setFocusable(false);
        saveButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        saveButton.addActionListener(this);
        contentPanel.add(saveButton);
    }


}
