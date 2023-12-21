package League.GUI;

import League.League;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    CardLayout cardLayout;

    public MainPanel(League league) {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        //PlayerGui playerGui = new PlayerGui(this,cardLayout,league);
        Matches matches = new Matches(this, cardLayout,league.upcomingMatches,league.pastMatches,league);
        Standings standings = new Standings(this,cardLayout,league);
        Players players = new Players(this,cardLayout,league);
        PlayerHome playerHome = new PlayerHome(this,cardLayout,league.teamnames);
        AddPlayer addPlayer = new AddPlayer(league.teamnames,league,this,cardLayout);
        EditPlayer editPlayer = new EditPlayer(league);
        DeletePlayer deletePlayer = new DeletePlayer(league.teamnames,league);
        TeamHome teamHome = new TeamHome(this,cardLayout);
        AddTeam addTeam = new AddTeam(league,this,cardLayout);
        EditTeam editTeam = new EditTeam(league,this,cardLayout);
        DeleteTeam deleteTeam = new DeleteTeam(league,this,cardLayout);
        LeagueHome leagueHome = new LeagueHome(this,cardLayout);
        AddMatch addMatch = new AddMatch(league,this,cardLayout);
        //this.add(playerGui, "PlayerGUI");
        this.add(playerHome,"PlayerHome");
        this.add(matches, "Matches");
        this.add(standings, "Standings");
        this.add(players,"Stats");
        this.add(addPlayer,"AddPlayer");
        this.add(editPlayer,"EditPlayer");
        this.add(deletePlayer,"DeletePlayer");
        //this.add(new TeamInfo(league.getTeams().get(0)),"TeamInfo");
        this.add(teamHome,"TeamHome");
        this.add(addTeam,"AddTeam");
        this.add(editTeam,"EditTeam");
        this.add(deleteTeam,"DeleteTeam");
        this.add(leagueHome,"LeagueHome");
        this.add(addMatch,"AddMatch");
    }
}
