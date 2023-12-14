package League.Match;

import League.Person.Referee.Referee;
import League.Stadium.Stadium;
import League.Team.Team;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Match {
    //Fields
    public static int noOfMatches = 0;
    private final int Match_ID;
    public String matchDate;
    public Date matchdate;
    public int team1score;
    public int team2score;
    public Team[] Teams;
    public Referee Referee;
    public String Score;
    public Stadium Stadium;
    SimpleDateFormat Date = new SimpleDateFormat("dd/MM/yyyy");
    //Constructors
    public Match(String matchDate, Date matchdate, Team[] Teams, Referee Referee, String Score, Stadium Stadium, int team1score, int team2score) {
        Match_ID = ++noOfMatches;
        this.Teams = new Team[2];
        try {
            this.Teams[0] = Teams[0];
        } catch (NullPointerException exp) {
            System.out.println("Null first team");
        }
        try {
            this.Teams[1] = Teams[1];
        } catch (NullPointerException exp) {
            System.out.println("Null second team");
        }
        try {
            this.Referee = new Referee(Referee);
        } catch (NullPointerException exp) {
            System.out.println("Null referee");
        }
        this.matchDate = matchDate;
        this.matchdate = matchdate;
        this.Score = Score;
        this.Stadium = Stadium;
        this.team1score = team1score;
        this.team2score = team2score;
    }

    public Match(String matchDate, Date matchdate, Team[] Teams, Referee Referee, String Score, Stadium Stadium, int team1score) {
        this(matchDate, matchdate, Teams, Referee, Score, Stadium, team1score, 0);
    }

    public Match(String matchDate, Date matchdate, Team[] Teams, Referee Referee, String Score, Stadium Stadium) {
        this(matchDate, matchdate, Teams, Referee, Score, Stadium, 0);
    }

    public Match(String matchDate, Date matchdate, Team[] Teams, Referee Referee, String Score) {
        this(matchDate, matchdate, Teams, Referee, Score, null);
    }

    public Match(String matchDate, Date matchdate, Team[] Teams, Referee Referee) {
        this(matchDate, matchdate, Teams, Referee, null);
    }

    public Match(String matchDate, Date matchdate, Team[] Teams) {
        this(matchDate, matchdate, Teams, null);
    }

    public Match(String matchDate, Date matchdate) {
        this(matchDate, matchdate, null);
    }

    public Match(String matchDate) {
        this(matchDate, null);
    }

    public Match() {
        this("");
    }

    public Match(Match Match) {
        Match_ID = ++noOfMatches;
        try {
            this.Teams = new Team[2];
            try {
                this.Teams = Arrays.copyOf(Match.Teams, Teams.length);
            } catch (NullPointerException exp) {
                System.out.println("Null");
            }
            this.Referee = new Referee(Match.Referee);
            //Date
            this.matchdate = Match.matchdate;
            //String
            this.matchDate = Match.matchDate;
            this.Score = Match.Score;
            this.Stadium = Match.Stadium;
        } catch (RuntimeException exp) {
            System.out.println("Null");
        }
    }
    public String WriteMatch(){
        return matchdate + "\t" + Teams[0].getName() + "\t" + Teams[1].getName() + "\t" + Referee.getPersonName() + "\t" + Score + "\t" + Stadium.getStadiumName();
    }


    //Function to be called when setting date in constructor
    public void StringToDate() {
        try {
            matchdate = Date.parse(matchDate);
        } catch (Throwable throwable) {
            System.out.println("Wrong input");
        }
    }

    //Getters and Setters
    public int getMatch_ID() {
        return Match_ID;
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
        try {
            Referee = referee;
        } catch (NullPointerException exp) {
            System.out.println("Null referee");
        }
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
        try {
            Stadium = stadium;
        } catch (NullPointerException exp) {
            System.out.println("Null stadium");
        }
    }

    public Team[] getTeams() {
        return Teams;
    }

    public void setTeams(Team[] teams) {
        this.Teams = new Team[teams.length];
        int i = 0;
        for (Team team : teams) {
            try {
                this.Teams[i] = team;
            } catch (NullPointerException exp) {
                System.out.println("Null team in array");
            }
            ++i;
        }
    }

    //Function of adding new teams
    public void addTeams(Team team1, Team team2) {
        this.Teams = new Team[2];
        try {
            Teams[0] = team1;
        } catch (NullPointerException exp) {
            System.out.println("Null team 1");
        }
        try {
            Teams[1] = team2;
        } catch (NullPointerException exp) {
            System.out.println("Null team 2");
        }
    }

    //Function of Displaying the info of the Match
    public void Display() {
        for (Team team : Teams) {
            System.out.println("Match Date:" + matchdate + "\n" + "Home Team" + Teams[0].Name + "Away Team" + Teams[0].Name + "\n"
                    + "Pitch Referee:" + Referee.Name + "\n" + "Stadium" + Stadium.getStadiumName()
                    + "Final Result is:" + Score);
        }
    }

    //Function to Add Points for the teams
    public void AddPoints() {
        if (team1score == team2score) {
            Teams[0].setTotal_score(Teams[0].getTotal_score() + 1);
            Teams[1].setTotal_score(Teams[1].getTotal_score() + 1);
        } else if (team1score > team2score) {
            Teams[0].setTotal_score(Teams[0].getTotal_score() + 3);

        } else {
            Teams[1].setTotal_score(Teams[1].getTotal_score() + 3);
        }
    }

    public void TeamsScoreToString() {
        String team1 = Integer.toString(team1score);
        String team2 = Integer.toString(team2score);
        Score = team1 + " " + team2;
    }
}
