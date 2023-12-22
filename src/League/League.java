package League;

import League.Match.Match;
import League.Person.Coach.Coach;
import League.Person.Player.Goalkeeper;
import League.Person.Player.Player;
import League.Person.Referee.Referee;
import League.Stadium.Stadium;
import League.Team.Team;
import League.Team.TeamAgeComparator;
import League.Team.TeamGoalsComparator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class League {
    protected ArrayList<Team> teams;
    public static ArrayList<String> teamnames;
    public static ArrayList<Player> searchByNameAndTeam;
    //eg 2023/2024
    public String season;
    public int matchCount;
    public Date DATE;
    public ArrayList<Match> matches;
    public ArrayList<Match> upcomingMatches;
    public ArrayList<Match> pastMatches;
    public ArrayList<Referee> referees;
    public ArrayList<Stadium> stadiums;

    public League(ArrayList<Match> matches, ArrayList<Team> teams,ArrayList<Referee> referees,ArrayList<Stadium> stadiums, int matchCount, Date Date, String season) {
        this.matches = new ArrayList<>(matches);
        this.upcomingMatches = new ArrayList<>();
        this.pastMatches = new ArrayList<>();
        for (Match match : matches){
            FilterMatchByTime(match);
        }
        this.teams = new ArrayList<>(teams);
        teamnames = new ArrayList<>();
        for (Team team : teams){
            teamnames.add(team.getName());
        }
        this.referees = new ArrayList<>(referees);
        this.stadiums = new ArrayList<>(stadiums);
        this.matchCount = matchCount;
        this.DATE = Date;
        this.season = season;
    }
    public League(ArrayList<Match> matches, ArrayList<Team> teams,ArrayList<Referee> referees,ArrayList<Stadium> stadiums, int matchCount, Date Date){
        this(matches, teams,referees,stadiums,matchCount, Date,"");
    }
    public League(ArrayList<Match> matches, ArrayList<Team> teams,ArrayList<Referee> referees,ArrayList<Stadium> stadiums, int matchCount){
        this(matches, teams,referees,stadiums,matchCount, null);
    }
    public League(ArrayList<Match> matches, ArrayList<Team> teams,ArrayList<Referee> referees,ArrayList<Stadium> stadiums){
        this(matches, teams,referees,stadiums,0);
    }
    public League(ArrayList<Match> matches, ArrayList<Team> teams,ArrayList<Referee> referees){
        this(matches, teams,referees,new ArrayList<>());
    }
    public League(ArrayList<Match> matches, ArrayList<Team> teams){
        this(matches, teams,new ArrayList<>());
    }
    public League(ArrayList<Match> matches) {
        this(matches,new ArrayList<>());
    }
    public League() {
        this(new ArrayList<>());
    }
    public League(League League) {
        try {
            this.matchCount = League.matchCount;
            this.DATE = League.DATE;
            this.matches = new ArrayList<>(League.matches);
            try {
                this.teams = new ArrayList<>(League.teams);
                teamnames = new ArrayList<>();
                for (Team team : teams){
                    teamnames.add(team.getName());
                }
            } catch (NullPointerException exp) {
                System.out.println("Null team");
            }
            this.referees = new ArrayList<>(League.referees);
            this.stadiums = new ArrayList<>(League.stadiums);
        } catch (NullPointerException exp) {
            System.out.println("Null object");
        }
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
        for (Team team : teams){
            teamnames.add(team.getName());
        }
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
        for (Match match : matches){
            FilterMatchByTime(match);
        }
    }

    public ArrayList<Referee> getReferees() {
        return referees;
    }

    public void setReferees(ArrayList<Referee> referees) {
        this.referees = referees;
    }

    public ArrayList<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(ArrayList<Stadium> stadiums) {
        this.stadiums = stadiums;
    }

    public ArrayList<Player> SearchByNameAndTeam(String playername, String teamname) {
        //searchByNameAndTeam.clear();
        ArrayList<Player> searched = new ArrayList<>();
        for (Team t : teams) {
            if (teamname.equalsIgnoreCase(t.getName())) {
                for (Player p : t.Players) {
                    if (playername.equalsIgnoreCase(p.getPersonName())) {
                        searched.add(p);
                    }
                }
            }
        }
        int resultCount = searched.size();
        if (resultCount == 0) {
            System.out.println("No results Found");
        }else {
            System.out.println(resultCount + " results found");
        }
        for (Team t : teams) {
            teamnames.add(t.getName());
        }
        return searched;
    }

    public Player[] DisplayTopScorers() {
        Player[] topScorers = new Player[3];
        for (int i = 0; i < 3; i++) {
            int maxGoals = -1;
            for (int j = 0; j < teams.size(); j++) {
                for (int k = 0; k < teams.get(j).getTotal(); k++) {
                    if (teams.get(j).getPlayers().get(k).getGoalsScored() > maxGoals &&
                            teams.get(j).getPlayers().get(k) != topScorers[0] &&
                            teams.get(j).getPlayers().get(k) != topScorers[1]) {
                        maxGoals = teams.get(j).getPlayers().get(k).getGoalsScored();
                        topScorers[i] = teams.get(j).getPlayers().get(k);
                    }
                }
            }
        }
        //display (return until GUI)
        return topScorers;
    }

    public Player[] DisplayTopGoalKeepers() {
        Player[] topKeepers = new Goalkeeper[3];
        int max = 0;
        topKeepers[0] = null;
        topKeepers[1] = null;
        topKeepers[2] = null;

        for (int j = 0; j < teams.size(); j++) {
            for (int k = 0; k < teams.get(j).getTotal(); k++) {
                if (teams.get(j).getPlayers().get(k) instanceof Goalkeeper) {
                    if (max < ((Goalkeeper) teams.get(j).getPlayers().get(k)).GetSaves()) {
                        max = ((Goalkeeper) teams.get(j).getPlayers().get(k)).GetSaves();
                        topKeepers[2] = topKeepers[1];
                        topKeepers[1] = topKeepers[0];
                        topKeepers[0] = teams.get(j).getPlayers().get(k);
                    }

                }
            }

        }
        //display (return until GUI)
        return topKeepers;
    }

   public ArrayList<Team> DisplayTeamByAvgAge() {
        ArrayList<Team> teamscopy = new ArrayList<>(teams);
        TeamAgeComparator comparator = new TeamAgeComparator();
        Collections.sort(teamscopy, comparator);
        return teamscopy;
    }

    public ArrayList<Team> DisplayTeamsByGoals() {
        ArrayList<Team> teamscopy = new ArrayList<>(teams);
        TeamGoalsComparator comparator = new TeamGoalsComparator();
        Collections.sort(teamscopy, comparator);
        return teamscopy;

    }

    public void AddMatch(Match match) {
        try {
            if (match == null) {
                throw new NullPointerException("Null");
            } else {
                matches.add(match);
                matchCount++;
            }
        } catch (NullPointerException e) {
            System.out.println("Objects cant be null");
        }

    }

    public ArrayList<Match> Display_match_ByDateFN(String date) {
        ArrayList<Match> matchesByDate = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date currentDate = dateFormat.parse(date);
            for (Match match : matches) {
                System.out.println(currentDate);
                System.out.println(match.matchdate);
                if (match.matchdate.equals(currentDate)) {
                    matchesByDate.add(match);
                }
            }
        } catch (Throwable throwable) {
            System.out.println("Wrong input");
        }
        return matchesByDate;
    }

    //Function to filter matches as held or to be held
    /**
     * This function filters matches according to current date into upcoming and past matches
     * @param match
     * @throws NullPointerException If there is no elements in array list
     */
    protected void FilterMatchByTime(Match match) {
        for (Match m : matches) {
            Date now = new Date();
            if (m.matchdate.before(now)) {
                System.out.println("Match time:Past");
                try {
                    upcomingMatches.remove(match);
                } catch (NullPointerException exp) {
                    System.out.println("Null");
                }
                pastMatches.add(match);

            } else if (m.matchdate.after(now)) {
                System.out.println("Match time:upcoming");
                try {
                    pastMatches.remove(match);
                } catch (NullPointerException exp) {
                    System.out.println("Null");
                }
                upcomingMatches.add(match);

            } else {
                System.out.println("Match time:now");
                try {
                    upcomingMatches.remove(match);
                    pastMatches.remove(match);
                } catch (NullPointerException exp) {
                    System.out.println("Null");
                }

            }
        }
    }
    public void DeleteTeam(String TeamName){
        boolean isFound = false;
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getName().equalsIgnoreCase(TeamName)){
                teams.remove(i);
                isFound = true;
                break;
            }
        }
        if (!isFound){
            System.out.println("Invalid Team Name");
        }
    }
    public void DeleteMatch(int MatchID){
        boolean isFound = false;
        for (int i = 0; i < matches.size(); i++) {
            if (matches.get(i).getMatch_ID() == MatchID){
                matches.remove(i);
                isFound = true;
                break;
            }
        }
        if (!isFound){
            System.out.println("Invalid Match ID");
        }
    }
    public void AddTeam(Team team){
        try {
            teams.add(team);
            teamnames.add(team.getName());
        }catch (NullPointerException exp){
            System.out.println("Invalid team");
        }
    }
    public Team searchTeam(String name) {
        for (Team team : teams){
            if (team.getName().equalsIgnoreCase(name)){
                return team;
            }
        }
        return null;
    }
    public Team searchTeam(int Team_ID){
        for (Team team : teams){
            if (team.getTeam_ID() == Team_ID){
                return team;
            }
        }
        return  null;
    }
    public void AddReferee(Referee referee){
        try {
            referees.add(referee);
        }catch (NullPointerException exp){
            System.out.println("Invalid Referee");
        }
    }
    public void AddStadium(Stadium stadium){
        try {
            stadiums.add(stadium);
        }catch (NullPointerException exp){
            System.out.println("Invalid stadium");
        }
    }
    public Referee searchReferee(int Referee_ID){
        for (Referee referee : referees){
            if (referee.getRefereeID() == Referee_ID){
                return referee;
            }
        }
        return  null;
    }
    public Stadium searchStadium(int Stadium_ID){
        for (Stadium stadium : stadiums){
            if (stadium.getStadiumID() == Stadium_ID){
                return stadium;
            }
        }
        return  null;
    }
    public Referee searchReferee(String refereeName){
        for (Referee referee : referees){
            if (referee.getPersonName().equalsIgnoreCase(refereeName)){
                return referee;
            }
        }
        return  null;
    }
    public Stadium searchStadium(String stadiumName){
        for (Stadium stadium : stadiums){
            if (stadium.getStadiumName().equalsIgnoreCase(stadiumName)){
                return stadium;
            }
        }
        return  null;
    }
}



