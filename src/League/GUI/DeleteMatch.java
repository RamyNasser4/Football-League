package League.GUI;

import League.League;
import League.Match.Match;
import League.Person.Player.Goalkeeper;
import League.Person.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class DeleteMatch extends JPanel implements ActionListener {
    League league;
    MainPanel main;
    CardLayout cardLayout;
    JComboBox chooseMatch;
    JLabel Team1Label;
    JLabel Team2Label;
    JLabel dateLabel;
    JLabel refereeLabel;
    JLabel stadiumLabel;
    JButton deleteMatch;
    JPanel ScorePanel;
    JLabel ScoreLabel;
    public DeleteMatch(League league, MainPanel main, CardLayout cardLayout){
        this.league = league;
        this.main = main;
        this.cardLayout = cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel titlePanel = new JPanel(new GridLayout(1, 1));
        JPanel contentPanel = new JPanel(new GridLayout(11, 1,0,30));
        JLabel titleLabel = new JLabel("Delete Match");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        this.add(titlePanel);
        this.add(contentPanel);
        //contentPanel.add(panel2);
        //choose Match
        JPanel chooseMatchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contentPanel.add(chooseMatchPanel);
        JLabel chooseMatchLabel = new JLabel("Choose Match : ");
        chooseMatchLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        chooseMatchLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,20));
        chooseMatchPanel.add(chooseMatchLabel);
        ArrayList<Integer> MatchesID = new ArrayList<Integer>();
        for (Match match : league.getMatches()){
            MatchesID.add(match.getMatch_ID());
        }
        chooseMatch = new JComboBox(MatchesID.toArray());
        chooseMatchPanel.add(chooseMatch);
        chooseMatch.addActionListener(this);
        //1st team
        JPanel Team1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        Team1Label = new JLabel("");
        Team1Label.setFont(new Font("Comic Sans",Font.BOLD,20));
        Team1Label.setBorder(BorderFactory.createEmptyBorder(0,10,0,27));
        Team1Panel.add(Team1Label);
        contentPanel.add(Team1Panel);
        //2nd team
        JPanel Team2Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        Team2Label = new JLabel("");
        Team2Label.setFont(new Font("Comic Sans",Font.BOLD,20));
        Team2Label.setBorder(BorderFactory.createEmptyBorder(0,10,0,27));
        Team2Panel.add(Team2Label);
        contentPanel.add(Team2Panel);
        //Date
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dateLabel = new JLabel("");
        dateLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        dateLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,55));
        datePanel.add(dateLabel);
        contentPanel.add(datePanel);
        //Referee
        JPanel refereePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        refereeLabel = new JLabel("");
        refereeLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        refereeLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,25));
        refereePanel.add(refereeLabel);
        contentPanel.add(refereePanel);
        //Stadium
        JPanel stadiumPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        stadiumLabel = new JLabel("");
        stadiumLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        stadiumLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,25));
        stadiumPanel.add(stadiumLabel);
        contentPanel.add(stadiumPanel);
        //ScoreLabel
        ScorePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ScoreLabel = new JLabel("");
        ScoreLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        ScoreLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,25));
        ScorePanel.add(ScoreLabel);
        ScorePanel.setVisible(false);
        contentPanel.add(ScorePanel);
        //edit match
        JPanel deleteMatchPanel = new JPanel();
        deleteMatch = new JButton("Delete Match");
        deleteMatch.setSize(new Dimension(100,30));
        deleteMatch.setFont(new Font("Comic Sans",Font.BOLD,20));
        deleteMatch.setHorizontalAlignment(SwingConstants.CENTER);
        deleteMatch.setFocusable(false);
        deleteMatch.addActionListener(this);
        deleteMatchPanel.add(deleteMatch);
        contentPanel.add(deleteMatchPanel);
        try {
            int MatchID = (int) chooseMatch.getSelectedItem();
            Match match = league.searchMatch(MatchID);
            Team1Label.setText("Team 1 : " + match.getTeams()[0].getName());
            Team2Label.setText("Team 2 : " + match.getTeams()[1].getName());
            dateLabel.setText("Date : " + match.getMatchDate());
            refereeLabel.setText("Referee : "+ match.getReferee().getPersonName());
            stadiumLabel.setText("Stadium : " + match.getStadium().getStadiumName());
            ScoreLabel.setText("Score : " + match.getScore());
            Date now = new Date();
            if (match.getDate().before(now)){
                ScorePanel.setVisible(true);
            }else {
                ScorePanel.setVisible(false);
            }
        }catch (NullPointerException ignored){

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseMatch) {
            try {
                int MatchID = (int) chooseMatch.getSelectedItem();
                Match match = league.searchMatch(MatchID);
                Team1Label.setText("Team 1 : " + match.getTeams()[0].getName());
                Team2Label.setText("Team 2 : " + match.getTeams()[1].getName());
                dateLabel.setText("Date : " + match.getMatchDate());
                refereeLabel.setText("Referee : "+ match.getReferee().getPersonName());
                stadiumLabel.setText("Stadium : " + match.getStadium().getStadiumName());
                ScoreLabel.setText("Score : " + match.getScore());
                Date now = new Date();
                if (match.getDate().before(now)){
                    ScorePanel.setVisible(true);
                }else {
                    ScorePanel.setVisible(false);
                }
            } catch (NullPointerException | ArrayIndexOutOfBoundsException ignored) {

            }
        } else if (e.getSource() == deleteMatch) {
            int MatchID = (int) chooseMatch.getSelectedItem();
            Match match = league.searchMatch(MatchID);
            if (!match.getScore().isEmpty()){
                for (Player player : match.getTeam1Scorers()){
                    player.setGoalsScored(player.getGoalsScored()-1);
                }
                for (Player player : match.getTeam2Scorers()){
                    player.setGoalsScored(player.getGoalsScored()-1);
                }
                for (Player player : match.getTeam1Assisters()){
                    player.setAssists(player.getAssists()-1);
                }
                for (Player player : match.getTeam2Assisters()){
                    player.setAssists(player.getAssists()-1);
                }
                if (match.getTeam1score()>match.getTeam2score()){
                    match.getTeams()[0].setTotal_score(match.getTeams()[0].getTotal_score()-3);
                } else if (match.getTeam2score()>match.getTeam1score()) {
                    match.getTeams()[1].setTotal_score(match.getTeams()[1].getTotal_score()-3);
                }else {
                    match.getTeams()[0].setTotal_score(match.getTeams()[0].getTotal_score()-1);
                    match.getTeams()[1].setTotal_score(match.getTeams()[1].getTotal_score()-1);
                }
                if (match.getTeam1score()>0){
                    Goalkeeper team2keeper = (Goalkeeper) match.team2Goalkeeper;
                    team2keeper.setGoalsConceded(team2keeper.getGoalsConceded()-match.getTeam1score());
                }
                if (match.getTeam2score()>0){
                    Goalkeeper team1keeper = (Goalkeeper) match.team1Goalkeeper;
                    team1keeper.setGoalsConceded(team1keeper.getGoalsConceded()-match.getTeam2score());
                }
            }
            try {
                match.getTeams()[0].deleteMatch(MatchID);
                match.getTeams()[1].deleteMatch(MatchID);
            }catch (Exception ignored){

            }
            System.out.println();
            match.getReferee().deleteMatch(MatchID);
            match.getStadium().deleteMatch(MatchID);
            league.DeleteMatch(MatchID);
            main.add(new DeleteMatch(league,main,cardLayout),"DeleteMatch");
            main.add(new Matches(main,cardLayout,league.upcomingMatches,league.pastMatches,league),"Matches");
            main.add(new Standings(main,cardLayout,league),"Standings");
            main.add(new EditMatch(league,main,cardLayout),"EditMatch");
            cardLayout.show(main,"LeagueHome");
        }
    }
}
