package League.GUI;

import League.League;
import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    CardLayout cardLayout;

    public MainPanel(League league) {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        //PlayerGui playerGui = new PlayerGui(this,cardLayout,league);
        Matches matches = new Matches(this, cardLayout,league.upcomingMatches,league.pastMatches,league);
        Standings standings = new Standings(this,cardLayout,league);
        Players players = new Players(this,cardLayout,league);
        PlayerHome playerHome = new PlayerHome(this,cardLayout,league.teamNames);
        AddPlayer addPlayer = new AddPlayer(league.teamNames,league,this,cardLayout);
        EditPlayer editPlayer = new EditPlayer(league.teamNames,league,this,cardLayout);
        DeletePlayer deletePlayer = new DeletePlayer(league.teamNames,league,this,cardLayout);
        TeamHome teamHome = new TeamHome(this,cardLayout);
        AddTeam addTeam = new AddTeam(league,this,cardLayout);
        EditTeam editTeam = new EditTeam(league,this,cardLayout);
        DeleteTeam deleteTeam = new DeleteTeam(league,this,cardLayout);
        LeagueHome leagueHome = new LeagueHome(this,cardLayout,league);
        AddMatch addMatch = new AddMatch(league,this,cardLayout);
        EditMatch editMatch = new EditMatch(league,this,cardLayout);
        DeleteMatch deleteMatch = new DeleteMatch(league,this,cardLayout);
        Stadiums stadiums =new Stadiums(this,cardLayout,league);
        AddStadium addStadium=new AddStadium(league,this,cardLayout);
        EditStadium editStadium=new EditStadium(league,this,cardLayout);
        DeleteStadium deleteStadium=new DeleteStadium(league,this,cardLayout);
        AddReferee addReferee=new AddReferee(league,this,cardLayout);
        DeleteReferee deleteReferee=new DeleteReferee(league,this,cardLayout);
        RefereeHome refereeHome=new RefereeHome(this,cardLayout,league);


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
        this.add(editMatch,"EditMatch");
        this.add(deleteMatch,"DeleteMatch");
        this.add(stadiums,"Stadiums");
        this.add(addStadium,"AddStadium");
        this.add(editStadium,"EditStadium");
        this.add(deleteStadium,"DeleteStadium");
        this.add(addReferee,"AddReferee");
        this.add(refereeHome,"RefereeHome");
        this.add(deleteReferee,"DeleteReferee");




    }
}
