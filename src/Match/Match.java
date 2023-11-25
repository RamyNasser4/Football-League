package Match;
import Referee.*;
import Stadium.Stadium;
import Team.*;
import java.util.ArrayList;
public class Match {
    //Fields
    public static int Match_ID=0;
    public String Date;
    public ArrayList<Team> Teams;
    public Referee Referee;
    public String Score;
    public Stadium Stadium;
    public Team team1;
    public Team team2;

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
    public ArrayList<Team> getTeams() {
        return Teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        Teams = teams;
    }
    //Constructors
    public Match(String Date,Team Teams,Referee Referee,String Score,Stadium Stadium){
        Match_ID++;
        this.Teams=new ArrayList<>();
        this.Referee=Referee;
        this.Date=Date;
        this.Score=Score;
        this.Stadium=Stadium;
    }
    public Match(String Date,Team Teams,Referee Referee,String Score){
        Match_ID++;
        this.Teams=new ArrayList<>();
        this.Referee=Referee;
        this.Date=Date;
        this.Score=Score;
    }
    public Match(String Date,Team Teams,Referee Referee){
        Match_ID++;
        this.Teams=new ArrayList<>();
        this.Referee=Referee;
        this.Date=Date;
    }
    public Match(String Date,Team Teams){
        Match_ID++;
        this.Teams=new ArrayList<>();
        this.Date=Date;
    }
    public Match(String Date){
        Match_ID++;
        this.Date=Date;
    }
    public Match(){
        this("");
    }
    //Function of adding new teams
    public void addTeams(Team team1, Team team2){
        this.Teams.add(team1);
        this.Teams.add(team2);
    }
    //Function of Displaying the info of the Match
    public void Display() {
        for (Team team : Teams) {
            System.out.println("Match Date:" + Date + "\n" + "Home Team" + team1+"Away Team" +team2 +"\n"
                    + "Pitch Referee:" + Referee.getRefereeName() + "\n" + "Stadium" + Stadium.getStadiumName()
                    + "Final Result is:" + Score);
        }
    }
}
