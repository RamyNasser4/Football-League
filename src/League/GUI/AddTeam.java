package League.GUI;

import League.League;
import League.Person.Coach.Coach;
import League.Team.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddTeam extends JPanel implements ActionListener {
    JButton addTeam;
    JTextField teamNameField;
    JTextField teamCoachField;
    JTextField teamCoachAgeField;
    League league;
    MainPanel main;
    CardLayout cardLayout;
    public AddTeam(League league,MainPanel main,CardLayout cardLayout){
        this.league = league;
        this.main = main;
        this.cardLayout = cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel titlePanel = new JPanel(new GridLayout(1, 1));
        JPanel contentPanel=new JPanel(new GridLayout(5, 1,0,30));
       // JPanel panel2 = new JPanel(new GridLayout(4, 1,0,50));
        JLabel titleLabel = new JLabel("Add Team");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        this.add(titlePanel);
        this.add(contentPanel);
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
        JPanel addTeamPanel = new JPanel();
        addTeam = new JButton("Add Team");
        addTeam.setSize(new Dimension(100,30));
        addTeam.setFont(new Font("Comic Sans",Font.BOLD,20));
        addTeam.setHorizontalAlignment(SwingConstants.CENTER);
        addTeam.setFocusable(false);
        addTeam.addActionListener(this);
        addTeamPanel.add(addTeam);
        contentPanel.add(addTeamPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTeam){
            String TeamName = teamNameField.getText();
            String CoachName = teamCoachField.getText();
            int CoachAge;
            try {
                CoachAge = Integer.parseInt(teamCoachAgeField.getText());
            }catch (Exception exp){
                CoachAge = 0;
            }
            if (Validation(TeamName,CoachName,CoachAge)){
                Coach newCoach = new Coach(CoachName,CoachAge,0,TeamName);
                Team newTeam = new Team(TeamName,new ArrayList<>(),null,newCoach,new ArrayList<>(),0,0,0);
                league.AddTeam(newTeam);
                main.add(new AddPlayer(league.teamNames,league,main,cardLayout),"AddPlayer");
                teamNameField.setText("");
                teamCoachField.setText("");
                teamCoachAgeField.setText("");
                cardLayout.show(main,"TeamHome");
                main.add(new Standings(main,cardLayout,league),"Standings");
                main.add(new EditTeam(league,main,cardLayout),"EditTeam");
                main.add(new DeleteTeam(league,main,cardLayout),"DeleteTeam");
                main.add(new EditPlayer(league.teamNames,league,main,cardLayout),"EditPlayer");
                main.add(new AddPlayer(league.teamNames,league,main,cardLayout),"AddPlayer");
                main.add(new DeletePlayer(league.teamNames,league,main,cardLayout),"DeletePlayer");
                main.add(new Players(main, cardLayout,league),"PlayerInfo");
            }else {
                JOptionPane.showConfirmDialog(this,"Invalid Fields","Invalid Field",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public boolean Validation(String TeamName,String CoachName,int CoachAge){
        if (TeamName.equalsIgnoreCase("") || CoachName.equalsIgnoreCase("") || CoachAge== 0){
            return false;
        }
        return true;
    }
}
