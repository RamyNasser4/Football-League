package Match;

import Referee.Referee;
import Stadium.Stadium;
import Team.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.SocketHandler;

public class Match {
    //Fields
    public static int Match_ID = 0;
    public String Date;
    public Team[] Teams;
    public Referee Referee;
    public String Score;
    public Stadium Stadium;

    //Constructors
    public Match(String Date, Team Teams, Referee Referee, String Score, Stadium Stadium) {
        Match_ID++;
        this.Teams = new Team[2];
        this.Referee = Referee;
        this.Date = Date;
        this.Score = Score;
        this.Stadium = Stadium;
    }

    public Match(String Date, Team Teams, Referee Referee, String Score) {
        Match_ID++;
        this.Teams = new Team[2];
        this.Referee = Referee;
        this.Date = Date;
        this.Score = Score;
    }

    public Match(String Date, Team Teams, Referee Referee) {
        Match_ID++;
        this.Teams = new Team[2];
        this.Referee = Referee;
        this.Date = Date;
    }

    public Match(String Date, Team Teams) {
        Match_ID++;
        this.Teams = new Team[2];
        this.Date = Date;
    }

    public Match(String Date) {
        Match_ID++;
        this.Date = Date;
    }

    public Match() {
        this("");
    }
    public Match(Match Match){
        try {
            Match_ID++;
            this.Teams = new Team[2];
            try {
                this.Teams = Arrays.copyOf(Match.Teams, Teams.length);
            } catch (NullPointerException exp) {
                System.out.println("Null");
            }
            this.Referee = Match.Referee;
            this.Date = Match.Date;
            this.Score = Match.Score;
            this.Stadium = Match.Stadium;
        }
        catch (RuntimeException exp){
            System.out.println("Null");
        }
    }
    //Getters and Setters
    public static int getMatch_ID() {
        return Match_ID;
    }

    public static void setMatch_ID(int match_ID) {
        Match_ID = match_ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Referee getReferee() {
        return Referee;
    }

    public void setReferee(Referee referee) {
        Referee = referee;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public Stadium getStadium() {
        return Stadium;
    }

    public void setStadium(Stadium stadium) {
        Stadium = stadium;
    }
    public Team[] getTeams() {
        return Teams;
    }

    public void setTeams(Team[] teams) {
        Teams = teams;
    }


    //Function of adding new teams
    public void addTeams(Team team1, Team team2) {
       this.Teams=new Team[2];
       Teams[0]=team1;
       Teams[1]=team2;
    }

    //Function of Displaying the info of the Match
    public void Display() {
        for (Team team : Teams) {
            System.out.println("Match Date:" + Date + "\n" + "Home Team" + Teams[0].Name + "Away Team" + Teams[0].Name + "\n"
                    + "Pitch Referee:" + Referee.getRefereeName() + "\n" + "Stadium" + Stadium.getStadiumName()
                    + "Final Result is:" + Score);
        }
    }
}
