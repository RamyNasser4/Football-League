package League.GUI;
import League.League;
import League.Person.Player.*;
import League.Team.Team;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;

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
            for (Player player : league.searchTeam(pTeam).getPlayers()){
                if (player.GetPlayerNumber() == Integer.parseInt(number) && league.searchTeam(pTeam).searchPlayer(pName)!=player){
                    throw new InputMismatchException();
                }
            }
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
                    JOptionPane.showMessageDialog(null, "Edited Successfully");
                    cardLayout.show(main,"PlayerHome");
                    main.add(new DeletePlayer(league.teamNames,league,main,cardLayout),"DeletePlayer");
                    main.add(new EditPlayer(league.teamNames,league,main,cardLayout),"EditPlayer");
                    main.add(new AddPlayer(league.teamNames,league,main,cardLayout),"AddPlayer");
                }

            else if (captain.equals("No")&&league.searchTeam(pTeam).searchPlayer(pName).getCaptain()){
                    Player p=league.searchTeam(pTeam).searchPlayer(pName);
                    p.setPersonName(name);
                    p.setPersonAge(Integer.parseInt(Age));
                    p.SetPlayerRank(Integer.parseInt(rank));
                    p.SetPlayerNumber(Integer.parseInt(number));
                    p.setCaptain(false);
                    league.searchTeam(pTeam).setCaptain(null);
                    JOptionPane.showMessageDialog(null, "Edited Successfully");
                    cardLayout.show(main,"PlayerHome");
                    main.add(new DeletePlayer(league.teamNames,league,main,cardLayout),"DeletePlayer");
                    main.add(new EditPlayer(league.teamNames,league,main,cardLayout),"EditPlayer");
                    main.add(new AddPlayer(league.teamNames,league,main,cardLayout),"AddPlayer");
                }

              else if(captain.equals("No")&&!league.searchTeam(pTeam).searchPlayer(pName).getCaptain()){
                    Player p=league.searchTeam(pTeam).searchPlayer(pName);
                    p.setPersonName(name);
                    p.setPersonAge(Integer.parseInt(Age));
                    p.SetPlayerRank(Integer.parseInt(rank));
                    p.SetPlayerNumber(Integer.parseInt(number));
                    p.setCaptain(false);
                    JOptionPane.showMessageDialog(null, "Edited Successfully");
                    cardLayout.show(main,"PlayerHome");
                    main.add(new DeletePlayer(league.teamNames,league,main,cardLayout),"DeletePlayer");
                    main.add(new EditPlayer(league.teamNames,league,main,cardLayout),"EditPlayer");
                    main.add(new AddPlayer(league.teamNames,league,main,cardLayout),"AddPlayer");
                }
                if(pTeam.equals((String) teamComboBox.getItemAt(teamComboBox.getSelectedIndex()))){

                }
                else {
                    Player p=league.searchTeam(pTeam).searchPlayer(pName);
                    Team t=league.searchTeam((String) teamComboBox.getItemAt(teamComboBox.getSelectedIndex()));
                    Team t2=league.searchTeam(pTeam);
                    t2.deletePlayer(pName);
                    t.addPlayer(p);
                    cardLayout.show(main,"PlayerHome");
                    main.add(new DeletePlayer(league.teamNames,league,main,cardLayout),"DeletePlayer");
                    main.add(new EditPlayer(league.teamNames,league,main,cardLayout),"EditPlayer");
                    main.add(new AddPlayer(league.teamNames,league,main,cardLayout),"AddPlayer");
                }


            }
            catch(NumberFormatException exp) {
                JOptionPane.showMessageDialog(null, "Enter a valid number in number,age and rank");
            }
            catch(NullPointerException exp){
                JOptionPane.showMessageDialog(null, "Null");
                cardLayout.show(main,"PlayerHome");
                main.add(new DeletePlayer(league.teamNames,league,main,cardLayout),"DeletePlayer");
                main.add(new EditPlayer(league.teamNames,league,main,cardLayout),"EditPlayer");
                main.add(new AddPlayer(league.teamNames,league,main,cardLayout),"AddPlayer");
            }catch (InputMismatchException exp){
                JOptionPane.showMessageDialog(null, "T-shirt number is reserved for another player");
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
    JButton searchButton;
    JButton saveButton;
    String pTeam;
    String pName;
    JPanel contentPanel;
    JPanel namePanel;
    JPanel teamPanel;
    JPanel titlePanel;
    League league;
    MainPanel main;
    CardLayout cardLayout;
    JTextField nameField;
    JTextField ageField;
    JTextField rankField;
    JTextField numberField;
    public EditPlayer(ArrayList<String> teamNames, League league,MainPanel main,CardLayout cardLayout) {

        this.main = main;
        this.league = league;
        this.cardLayout = cardLayout;

        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(4, 1));
        titlePanel = new JPanel(new GridLayout(2, 1, 0, 0));
        contentPanel = new JPanel(new GridLayout(3, 1));
        JLabel titleLabel = new JLabel("Edit Player");
        JLabel title2Label = new JLabel("Search by Team and Name");
        title2Label.setFont(new Font("Comic Sans", Font.BOLD, 15));
        title2Label.setVerticalAlignment(JLabel.TOP);
        title2Label.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        titlePanel.add(title2Label);

         teamPanel = new JPanel(new GridLayout(1, 1));
        JLabel teamLabel = new JLabel("Player Team");
        teamLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        teamPanel.add(teamLabel);
        teamComboBox = new JComboBox(new DefaultComboBoxModel<>(teamNames.toArray()));
        teamComboBox.addActionListener(this);
        teamPanel.add(teamComboBox);
        contentPanel.add(teamPanel);

        String team;
        try {
            team = (String) teamComboBox.getItemAt(teamComboBox.getSelectedIndex());
        } catch (NullPointerException exp) {
            team = "null";
            JOptionPane.showMessageDialog(null, "No teams exist");
        }

         namePanel = new JPanel(new GridLayout(1, 1));
        JLabel nameLabel = new JLabel("Player Name");
        nameLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        namePanel.add(nameLabel);
        nameComboBox = new JComboBox(new DefaultComboBoxModel<>(league.searchTeam(team).getPlayernames().toArray()));
        namePanel.add(nameComboBox);
        contentPanel.add(namePanel);
        this.add(titlePanel);
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
        this.remove(titlePanel);
        contentPanel.remove(searchButton);
        contentPanel.remove(namePanel);
        contentPanel.remove(teamPanel);
        contentPanel.add(titlePanel);
        JPanel namePanel = new JPanel(new GridLayout(1, 1));
        JLabel nameLabel = new JLabel("Name");
        namePanel.add(nameLabel);
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        nameField = new JTextField(playerToEdit.getPersonName());
        namePanel.add(nameField);
        contentPanel.add(namePanel);
        contentPanel.add(teamPanel);

        JPanel agePanel = new JPanel(new GridLayout(1, 1));
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        ageField = new JTextField(Integer.toString(playerToEdit.GetPlayerAge()));
        agePanel.add(ageLabel);
        agePanel.add(ageField);
        contentPanel.add(agePanel);

        JPanel rankPanel = new JPanel(new GridLayout(1, 1));
        JLabel rankLabel = new JLabel("Rank");
        rankLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        rankPanel.add(rankLabel);
        rankField = new JTextField(Integer.toString(playerToEdit.GetPlayerRank()));
        rankPanel.add(rankField);
        contentPanel.add(rankPanel);

        JPanel numberPanel = new JPanel(new GridLayout(1, 1));
        JLabel numberLabel = new JLabel("T-shirt number");
        numberLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        numberPanel.add(numberLabel);
        numberField = new JTextField(Integer.toString(playerToEdit.GetPlayerNumber()));
        numberPanel.add(numberField);
        contentPanel.add(numberPanel);

        JPanel captainPanel = new JPanel(new GridLayout(1, 1));
        JLabel captainLabel = new JLabel("Team Captain");
        captainLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        captainPanel.add(captainLabel);
        String capList[]={"No","Yes"};
        String capList2[]={"Yes","No"};
        if(playerToEdit.getCaptain()) {
            captainComboBox = new JComboBox(capList2);
            captainPanel.add(captainComboBox);
            contentPanel.add(captainPanel);
        }
        else {
            captainComboBox = new JComboBox(capList);
            captainPanel.add(captainComboBox);
            contentPanel.add(captainPanel);
        }

        saveButton = new JButton("Save");
        saveButton.setFocusable(false);
        saveButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        saveButton.addActionListener(this);
        contentPanel.add(saveButton);
    }


}
