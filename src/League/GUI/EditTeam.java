package League.GUI;

import League.League;
import League.Person.Player.Player;
import League.Team.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class EditTeam extends JPanel implements ActionListener {
    JComboBox chooseTeams;
    JButton editTeam;
    JTextField teamNameField;
    JTextField teamIDField;
    JTextField teamCoachField;
    JTextField teamCoachAgeField;
    League league;
    MainPanel main;
    CardLayout cardLayout;
    public EditTeam(League league,MainPanel main,CardLayout cardLayout){
        this.league = league;
        this.main = main;
        this.cardLayout = cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel titlePanel = new JPanel(new GridLayout(1, 1));
        JPanel contentPanel=new JPanel(new GridLayout(6, 1,0,30));
        JLabel titleLabel = new JLabel("Edit Team");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        this.add(titlePanel);
        this.add(contentPanel);
        JPanel chooseTeamPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contentPanel.add(chooseTeamPanel);
        chooseTeams = new JComboBox(new DefaultComboBoxModel<>(league.teamNames.toArray()));
        chooseTeams.addActionListener(this);
        chooseTeams.setEditable(false);
        chooseTeamPanel.add(chooseTeams);
        //team name
        JPanel teamNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel teamNameLabel = new JLabel("Team Name : ");
        teamNameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        teamNameLabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,20));
        teamNamePanel.add(teamNameLabel);
        teamNameField = new JTextField("");
        teamNameField.setPreferredSize(new Dimension(300,40));
        teamNamePanel.add(teamNameField);
        contentPanel.add(teamNamePanel);
        //team id
        JPanel teamIDPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel teamIDLabel = new JLabel("Team ID : ");
        teamIDLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        teamIDLabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,54));
        teamIDPanel.add(teamIDLabel);
        teamIDField = new JTextField("");
        teamIDField.setPreferredSize(new Dimension(300,40));
        teamIDPanel.add(teamIDField);
        contentPanel.add(teamIDPanel);
        //coach name
        JPanel coachNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel teamCoachName = new JLabel("Coach Name : ");
        teamCoachName.setFont(new Font("Comic Sans",Font.BOLD,20));
        teamCoachName.setBorder(BorderFactory.createEmptyBorder(0,5,0,10));
        coachNamePanel.add(teamCoachName);
        teamCoachField = new JTextField("");
        teamCoachField.setPreferredSize(new Dimension(300,40));
        coachNamePanel.add(teamCoachField);
        contentPanel.add(coachNamePanel);
        JPanel coachAgePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel teamCoachAge = new JLabel("Coach Age : ");
        teamCoachAge.setFont(new Font("Comic Sans",Font.BOLD,20));
        teamCoachAge.setBorder(BorderFactory.createEmptyBorder(0,5,0,26));
        coachAgePanel.add(teamCoachAge);
        teamCoachAgeField = new JTextField("");
        teamCoachAgeField.setPreferredSize(new Dimension(300,40));
        coachAgePanel.add(teamCoachAgeField);
        contentPanel.add(coachAgePanel);
        JPanel editTeamPanel = new JPanel();
        editTeam = new JButton("Edit Team");
        editTeam.setSize(new Dimension(100,30));
        editTeam.setFont(new Font("Comic Sans",Font.BOLD,20));
        editTeam.setHorizontalAlignment(SwingConstants.CENTER);
        editTeam.setFocusable(false);
        editTeam.addActionListener(this);
        editTeamPanel.add(editTeam);
        try {
            String TeamName = (String) chooseTeams.getSelectedItem();
            Team searched = league.searchTeam(TeamName);
            teamNameField.setText(searched.getName());
            teamIDField.setText(String.valueOf(searched.getTeam_ID()));
            teamCoachField.setText(searched.getCoach().getPersonName());
            teamCoachAgeField.setText(String.valueOf(searched.getCoach().getPersonAge()));
        }catch (Exception exp){

        }
        contentPanel.add(editTeamPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseTeams){
            String TeamName = (String) chooseTeams.getSelectedItem();
            Team searched = league.searchTeam(TeamName);
            teamNameField.setText(searched.getName());
            teamIDField.setText(String.valueOf(searched.getTeam_ID()));
            teamCoachField.setText(searched.getCoach().getPersonName());
            teamCoachAgeField.setText(String.valueOf(searched.getCoach().getPersonAge()));
        } else if (e.getSource() == editTeam) {
            String TeamName = teamNameField.getText();
            int TeamID;
            try {
                TeamID = Integer.parseInt(teamIDField.getText());
            }catch (Exception exp){
                TeamID = 0;
            }
            String CoachName = teamCoachField.getText();
            int CoachAge;
            try {
                CoachAge = Integer.parseInt(teamCoachAgeField.getText());
            }catch (Exception exp){
                //JOptionPane.showConfirmDialog(this,"Invalid Coach Age","Invalid Field",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
                CoachAge = 0;
            }try {

                if (Validation(TeamName,TeamID,CoachName,CoachAge)){
                    String currentTeamName = (String) chooseTeams.getSelectedItem();
                    Team searched = league.searchTeam(currentTeamName);
                    searched.setName(TeamName);
                    searched.setTeam_ID(TeamID);
                    searched.getCoach().setPersonName(CoachName);
                    searched.getCoach().setPersonAge(CoachAge);
                    for (Player player : searched.getPlayers()) {
                        player.SetPlayerTeam(TeamName);
                    }
                    for (int i = 0; i < league.teamNames.size(); i++) {
                        if (league.teamNames.get(i).equalsIgnoreCase(currentTeamName)){
                            league.teamNames.set(i,TeamName);
                        }
                    }
                    main.add(new AddPlayer(league.teamNames,league,main,cardLayout),"AddPlayer");
                    cardLayout.show(main,"TeamHome");
                    main.add(new Standings(main,cardLayout,league),"Standings");
                    main.add(new EditTeam(league,main,cardLayout),"EditTeam");
                    main.add(new DeleteTeam(league,main,cardLayout),"DeleteTeam");
                    main.add(new Matches(main,cardLayout,league.upcomingMatches,league.pastMatches,league),"Matches");
                    main.add(new DeletePlayer(league.teamNames,league,main,cardLayout),"DeletePlayer");
                    main.add(new EditPlayer(league.teamNames,league,main,cardLayout),"EditPlayer");
                    main.add(new AddPlayer(league.teamNames,league,main,cardLayout),"AddPlayer");

                }else {
                    JOptionPane.showConfirmDialog(this,"Invalid Fields","Invalid Field",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
                }
            }catch (InputMismatchException exp){
                JOptionPane.showConfirmDialog(this,"Team with this ID already exists","Invalid Inputs",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public boolean Validation(String TeamName,int TeamID,String CoachName,int CoachAge){
        if (TeamName.equalsIgnoreCase("") || TeamID == 0 || CoachName.equalsIgnoreCase("") || CoachAge== 0){
            return false;
        }
        for (Team team : league.getTeams()){
            if (team.getTeam_ID() == TeamID && !(team.getName().equalsIgnoreCase((String) chooseTeams.getSelectedItem()))){
                throw new InputMismatchException();
            }
        }
        return true;
    }
}
