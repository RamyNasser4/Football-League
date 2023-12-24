package League.GUI;

import League.GUI.Components.SideBarButton;
import League.League;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideBar extends JPanel implements ActionListener {
    SideBarButton matches;
    SideBarButton teams;
    SideBarButton players;
    SideBarButton standings;
    SideBarButton stats;
    SideBarButton stadium;
    SideBarButton referee;
    SideBarButton reset;
    SideBarButton leagueButton;
    CardLayout cardLayout;
    MainPanel main;
    League league;
    public SideBar(MainPanel main, CardLayout cardLayout,League league) {
        this.cardLayout = cardLayout;
        this.main = main;
        this.league=league;
        this.setPreferredSize(new Dimension(300, 720));
        this.setBackground(new Color(0x2a2c2f));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(CENTER_ALIGNMENT);
        matches = new SideBarButton("Matches");
        ImageIcon match = new ImageIcon("src/Assets/match4.png");
        matches.setIcon(match);
        matches.setIconTextGap(15);
        teams = new SideBarButton("Teams");
        ImageIcon team = new ImageIcon("src/Assets/team.png");
        teams.setIcon(team);
        teams.setIconTextGap(25);
        players = new SideBarButton("Players");
        ImageIcon player = new ImageIcon("src/Assets/player.png");
        players.setIcon(player);
        players.setIconTextGap(25);
        standings = new SideBarButton("Standings");
        ImageIcon standing = new ImageIcon("src/Assets/ranking.png");
        standings.setIcon(standing);
        standings.setIconTextGap(25);
        stats = new SideBarButton("Stats");
        ImageIcon stat = new ImageIcon("src/Assets/stats.png");
        stats.setIcon(stat);
        stats.setIconTextGap(25);
        leagueButton = new SideBarButton("League");
        ImageIcon leagueIcon = new ImageIcon("src/Assets/league.png");
        referee =new SideBarButton("Referee");
        ImageIcon refereeIcon = new ImageIcon("src/Assets/referee-sidebar.png");
        referee.setIcon(refereeIcon);
        referee.setIconTextGap(25);
        leagueButton.setIcon(leagueIcon);
        leagueButton.setIconTextGap(25);
        leagueButton.setIcon(leagueIcon);
        leagueButton.setIconTextGap(25);
        stadium = new SideBarButton("Stadiums");
        ImageIcon stadiumIcon = new ImageIcon("src/Assets/stadium-sidebar.png");
        stadium.setIcon(stadiumIcon);
        stadium.setIconTextGap(15);
        reset = new SideBarButton("Reset All");
        ImageIcon resetIcon = new ImageIcon("src/Assets/reset-icon.png");
        reset.setIcon(resetIcon);
        matches.setIconTextGap(15);
        matches.addActionListener(this);
        teams.addActionListener(this);
        players.addActionListener(this);
        standings.addActionListener(this);
        stats.addActionListener(this);
        leagueButton.addActionListener(this);
        referee.addActionListener(this);
        leagueButton.addActionListener(this);
        stadium.addActionListener(this);
        reset.addActionListener(this);
        this.add(matches);
        this.add(teams);
        this.add(players);
        this.add(standings);
        this.add(stats);
        this.add(referee);
        this.add(leagueButton);
        this.add(stadium);
        this.add(reset);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == matches) {
            cardLayout.show(main, "Matches");
        } else if (e.getSource() == teams) {
            cardLayout.show(main,"TeamHome");
        } else if (e.getSource() == players) {
            cardLayout.show(main, "PlayerHome");
        } else if (e.getSource() == standings) {
            cardLayout.show(main, "Standings");
        } else if (e.getSource() == stats) {
            cardLayout.show(main,"Stats");
        } else if (e.getSource() == leagueButton) {
            cardLayout.show(main,"LeagueHome");
        }
        else if (e.getSource()==referee){
            cardLayout.show(main,"RefereeHome");
        }
        else if(e.getSource()==stadium){
            cardLayout.show(main,"Stadiums");
        }
        else if(e.getSource()==reset){
            int option=JOptionPane.showConfirmDialog(this,"Are you sure you want to delete all the data of league?","Confirmation",JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                league.ResetLeague();
                main.add(new Matches(main,cardLayout,league.upcomingMatches,league.pastMatches,league),"Matches");
                main.add(new AddPlayer(league.teamNames,league,main,cardLayout),"AddPlayer");
                main.add(new AddTeam(league,main,cardLayout),"AddTeam");
                main.add(new AddReferee(league,main,cardLayout),"AddReferee");
                main.add(new AddStadium(league,main,cardLayout),"AddStadium");
                main.add(new Players(main,cardLayout,league),"Stats");
                main.add(new Standings(main,cardLayout,league),"Standings");
                main.add(new AddMatch(league,main,cardLayout),"AddMatch");
                main.add(new LeagueHome(main,cardLayout,league),"LeagueHome");
                main.add(new PlayerHome(main,cardLayout,league.teamNames),"PlayerHome");
                main.add(new TeamHome(main,cardLayout,league),"TeamHome");
                cardLayout.show(main,"Matches");
            }
        }

    }
}


