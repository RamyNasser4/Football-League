package League.Match;

import League.Person.Refree.Referee;
import League.Stadium.Stadium;
import League.Team.Team;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.Arrays;

public class Match {
    //Fields
    public static int Match_ID = 0;
   public String matchDate;
   SimpleDateFormat Date = new SimpleDateFormat("dd/MM/yyyy");
   public Date matchdate;
   //Function to be called when setting date in constructor
public void StringtoDate(String matchDate) {
    try {
        matchdate = Date.parse(matchDate);

    } catch (Throwable throwable) {
        System.out.println("Wrong input");
    }
}
    public Team[] Teams;
    public Referee Referee;
    public String Score;
    public Stadium Stadium;
    public String dateOfMatch;

    //Constructors
    public Match(String dateOfMatch, Team[] Teams, Referee Referee, String Score, Stadium Stadium) {
        Match_ID++;
        this.Teams = new Team[2];
        this.Teams[0]=Teams[0];
        this.Teams[1]=Teams[1];
            try {
                this.Referee = new Referee(Referee);
            } catch (NullPointerException exp) {
                System.out.println("Null");
            }
       this.dateOfMatch = dateOfMatch;
        this.Score = Score;
        this.Stadium = Stadium;
    }

    public Match(String Date, Team[] Teams, Referee Referee, String Score) {
        this(Date,Teams,Referee,Score,null);
        Match_ID++;
    }

    public Match(String Date,Team[] Teams, Referee Referee) {
        this(Date,Teams,Referee,null,null);
        Match_ID++;

    }

    public Match(String Date, Team[] Teams) {
        this(Date,Teams,null,null,null);
        Match_ID++;
    }

    public Match(String Date) {
        this(Date,null,null,null,null);
        Match_ID++;
    }

    public Match() {
        this("");
        Match_ID++;
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
            this.Referee = new Referee (Match.Referee);
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

    public Date getDate() {
        return matchdate;
   }

   public void setDate(Date date) {
    matchdate = date;
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
                    + "Pitch Referee:" + Referee.Name + "\n" + "Stadium" + Stadium.getStadiumName()
                    + "Final Result is:" + Score);
        }
    }
}
