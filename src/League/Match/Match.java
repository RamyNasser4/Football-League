package League.Match;

import League.Person.Player.Player;
import League.Person.Referee.Referee;
import League.Stadium.Stadium;
import League.Team.Team;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Match {
    //Fields
    protected static int noOfMatches = 0;
    private final int Match_ID;
    public  String matchDate;
    public Date matchdate;
    protected int team1score;
    protected int team2score;
    protected Team[] Teams;
    protected Referee Referee;
    protected String Score;
    protected Stadium Stadium;
    private ArrayList<Player> team1Scorers;
    private ArrayList<Player> team1Assisters;
    private ArrayList<Player> team2Scorers;
    private ArrayList<Player> team2Assisters;
    public Player team1Goalkeeper;
    public Player team2Goalkeeper;

    public ArrayList<Player> getTeam1Scorers() {
        return team1Scorers;
    }

    public void setTeam1Scorers(ArrayList<Player> team1Scorers) {
        this.team1Scorers = team1Scorers;
    }

    public ArrayList<Player> getTeam1Assisters() {
        return team1Assisters;
    }

    public void setTeam1Assisters(ArrayList<Player> team1Assisters) {
        this.team1Assisters = team1Assisters;
    }

    public ArrayList<Player> getTeam2Scorers() {
        return team2Scorers;
    }

    public void setTeam2Scorers(ArrayList<Player> team2Scorers) {
        this.team2Scorers = team2Scorers;
    }

    public ArrayList<Player> getTeam2Assisters() {
        return team2Assisters;
    }

    public void setTeam2Assisters(ArrayList<Player> team2Assisters) {
        this.team2Assisters = team2Assisters;
    }

    public Player getTeam1Goalkeeper() {
        return team1Goalkeeper;
    }

    public void setTeam1Goalkeeper(Player team1Goalkeeper) {
        this.team1Goalkeeper = team1Goalkeeper;
    }

    public Player getTeam2Goalkeeper() {
        return team2Goalkeeper;
    }

    public void setTeam2Goalkeeper(Player team2Goalkeeper) {
        this.team2Goalkeeper = team2Goalkeeper;
    }

    SimpleDateFormat Date = new SimpleDateFormat("dd/MM/yyyy");
    //Constructors
    public Match(String matchDate, Team[] Teams, Referee Referee, String Score, Stadium Stadium, int team1score, int team2score,ArrayList<Player> team1Scorers,ArrayList<Player> team1Assisters,ArrayList<Player> team2Scorers,ArrayList<Player> team2Assisters,Player team1Goalkeeper,Player team2Goalkeeper) {
        Match_ID = ++noOfMatches;
        this.Teams = new Team[2];
        try {
            this.Teams[0] = Teams[0];
        } catch (NullPointerException exp) {

        }
        try {
            this.Teams[1] = Teams[1];
        } catch (NullPointerException exp) {

        }
        try {
            this.Referee = new Referee(Referee);
        } catch (NullPointerException exp) {

        }
        this.matchDate = matchDate;
        StringToDate();
        this.Score = Score;
        this.Stadium = Stadium;
        this.team1score = team1score;
        this.team2score = team2score;
        this.team1Scorers = team1Scorers;
        this.team1Assisters = team1Assisters;
        this.team2Scorers = team2Scorers;
        this.team2Assisters = team2Assisters;
        this.team1Goalkeeper = team1Goalkeeper;
        this.team2Goalkeeper = team2Goalkeeper;
    }
    public Match(String matchDate, Team[] Teams, Referee Referee, String Score, Stadium Stadium, int team1score, int team2score,ArrayList<Player> team1Scorers,ArrayList<Player> team1Assisters,ArrayList<Player> team2Scorers,ArrayList<Player> team2Assisters,Player team1Goalkeeper) {
        this(matchDate, Teams, Referee, Score, Stadium, team1score, 0,team1Scorers,team1Assisters,team2Scorers,team2Assisters,team1Goalkeeper,null);
    }
    public Match(String matchDate, Team[] Teams, Referee Referee, String Score, Stadium Stadium, int team1score, int team2score,ArrayList<Player> team1Scorers,ArrayList<Player> team1Assisters,ArrayList<Player> team2Scorers,ArrayList<Player> team2Assisters) {
        this(matchDate, Teams, Referee, Score, Stadium, team1score, 0,team1Scorers,team1Assisters,team2Scorers,team2Assisters,null);
    }
    public Match(String matchDate, Team[] Teams, Referee Referee, String Score, Stadium Stadium, int team1score, int team2score,ArrayList<Player> team1Scorers,ArrayList<Player> team1Assisters,ArrayList<Player> team2Scorers) {
        this(matchDate, Teams, Referee, Score, Stadium, team1score, 0,team1Scorers,team1Assisters,team2Scorers,new ArrayList<>());
    }
    public Match(String matchDate, Team[] Teams, Referee Referee, String Score, Stadium Stadium, int team1score, int team2score,ArrayList<Player> team1Scorers,ArrayList<Player> team1Assisters) {
        this(matchDate, Teams, Referee, Score, Stadium, team1score, 0,team1Scorers,team1Assisters,new ArrayList<>());
    }
    public Match(String matchDate, Team[] Teams, Referee Referee, String Score, Stadium Stadium, int team1score, int team2score,ArrayList<Player> team1Scorers) {
        this(matchDate, Teams, Referee, Score, Stadium, team1score, 0,team1Scorers,new ArrayList<>());
    }
    public Match(String matchDate, Team[] Teams, Referee Referee, String Score, Stadium Stadium, int team1score, int team2score) {
        this(matchDate, Teams, Referee, Score, Stadium, team1score, 0,new ArrayList<>());
    }
    public Match(String matchDate, Team[] Teams, Referee Referee, String Score, Stadium Stadium, int team1score) {
        this(matchDate, Teams, Referee, Score, Stadium, team1score, 0);
    }

    public Match(String matchDate, Team[] Teams, Referee Referee, String Score, Stadium Stadium) {
        this(matchDate, Teams, Referee, Score, Stadium, 0);
    }

    public Match(String matchDate, Team[] Teams, Referee Referee, String Score) {
        this(matchDate, Teams, Referee, Score, null);
    }

    public Match(String matchDate, Team[] Teams, Referee Referee) {
        this(matchDate, Teams, Referee, null);
    }

    public Match(String matchDate, Team[] Teams) {
        this(matchDate, Teams, null);
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

            }
            this.Referee = new Referee(Match.Referee);
            //Date
            this.matchdate = Match.matchdate;
            //String
            this.matchDate = Match.matchDate;
            StringToDate();
            this.Score = Match.Score;
            this.Stadium = Match.Stadium;
        } catch (RuntimeException exp) {

        }
    }
    public String WriteMatch(){
        String match = matchDate + "\t" + Teams[0].getName() + "\t" + Teams[1].getName() + "\t" + Referee.getPersonName() + "\t" + Score + "\t" + Stadium.getStadiumName() + "\t" + ",";
        if (!Score.isEmpty()){
            for (Player player : team1Scorers){
                match+= "Team1:"+player.getPersonName() + "\t";
            }
            for (Player player : team2Scorers){
                match+= "Team2:"+player.getPersonName() + "\t";
            }
            match+= ",";
            for (Player player : team1Assisters){
                match += "Team1:"+player.getPersonName() + "\t";
            }
            for (Player player : team2Assisters){
                try {
                    match += "Team2:"+player.getPersonName()+"\t";
                }catch (NullPointerException ignored){

                }
            }
            match+= ",";
            if (team1score > 0){
                match+= "Team2:" + team2Goalkeeper.getPersonName() + "\t";
            }
            if (team2score > 0){
                match+= "Team1:" + team1Goalkeeper.getPersonName() + "\t";
            }
        }
        return match;
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

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
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

    public int getTeam1score() {
        return team1score;
    }

    public void setTeam1score(int team1score) {
        this.team1score = team1score;
    }

    public int getTeam2score() {
        return team2score;
    }

    public void setTeam2score(int team2score) {
        this.team2score = team2score;
    }

    //Function of adding new teams


    //Function of Displaying the info of the Match


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


}
