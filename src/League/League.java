package League;

import League.Match.Match;
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




public class League {
    protected ArrayList<Team> teams;
    public static ArrayList<String> teamNames;
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
        FilterMatchByTime();
        this.teams = new ArrayList<>(teams);
        teamNames = new ArrayList<>();
        for (Team team : teams){
            teamNames.add(team.getName());
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
            FilterMatchByTime();
            try {
                this.teams = new ArrayList<>(League.teams);
                teamNames = new ArrayList<>();
                for (Team team : teams){
                    teamNames.add(team.getName());
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
            teamNames.add(team.getName());
        }
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
        FilterMatchByTime();
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

    public ArrayList<Player> SearchByNameAndTeam(String playerName, String teamName) {
        //searchByNameAndTeam.clear();
        ArrayList<Player> searched = new ArrayList<>();
        for (Team t : teams) {
            if (teamName.equalsIgnoreCase(t.getName())) {
                for (Player p : t.Players) {
                    if (playerName.equalsIgnoreCase(p.getPersonName())) {
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
            teamNames.add(t.getName());
        }
        return searched;
    }
    public ArrayList<Player> getPlayersByTeamName(String teamName) {
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                return new ArrayList<>(team.getPlayers()); // Assuming Team class has a getPlayers() method
            }
        }
        return new ArrayList<>(); // Return an empty list if no team is found
    }

    public ArrayList<Player> getAllPlayers() {
        ArrayList<Player> allPlayers = new ArrayList<>();
        for (Team team : teams) {
            allPlayers.addAll(team.getPlayers());
        }
        return allPlayers;
    }


    public Player[] DisplayTopScorers() {
        Player[] topScorers = new Player[3];
        int maxGoals1 = Integer.MIN_VALUE, maxGoals2 = Integer.MIN_VALUE, maxGoals3 = Integer.MIN_VALUE;
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                int goals = player.getGoalsScored();
                if (goals > maxGoals1) {
                    maxGoals3 = maxGoals2;
                    maxGoals2 = maxGoals1;
                    maxGoals1 = goals;
                    topScorers[2] = topScorers[1];
                    topScorers[1] = topScorers[0];
                    topScorers[0] = player;
                } else if (goals > maxGoals2 && player != topScorers[0]) {
                    maxGoals3 = maxGoals2;
                    maxGoals2 = goals;
                    topScorers[2] = topScorers[1];
                    topScorers[1] = player;
                } else if (goals > maxGoals3 && player != topScorers[0] && player != topScorers[1]) {
                    maxGoals3 = goals;
                    topScorers[2] = player;
                }
            }
        }
        return topScorers;
    }

    public Player[] DisplayTopGoalKeepers() {
        Player[] topKeepers = new Goalkeeper[3];
        int max1 = -1, max2 = -1, max3 = -1;
        topKeepers[0] = null;
        topKeepers[1] = null;
        topKeepers[2] = null;
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                if (player instanceof Goalkeeper) {
                    Goalkeeper gk = (Goalkeeper) player;
                    int goalsConceded = gk.getGoalsConceded();

                    if (goalsConceded > max1) {
                        max3 = max2;
                        max2 = max1;
                        max1 = goalsConceded;
                        topKeepers[2] = topKeepers[1];
                        topKeepers[1] = topKeepers[0];
                        topKeepers[0] = gk;
                    } else if (goalsConceded > max2 && gk != topKeepers[0]) {
                        max3 = max2;
                        max2 = goalsConceded;
                        topKeepers[2] = topKeepers[1];
                        topKeepers[1] = gk;
                    } else if (goalsConceded > max3 && gk != topKeepers[0] && gk != topKeepers[1]) {
                        max3 = goalsConceded;
                        topKeepers[2] = gk;
                    }
                }
            }
        }
        Player[] reversedTopKeepers = new Player[3];
        for (int i = 0; i < 3; i++) {
            reversedTopKeepers[i] = topKeepers[2 - i];
        }
        return reversedTopKeepers;
    }

   public ArrayList<Team> DisplayTeamByAvgAge() {
        ArrayList<Team> teamsCopy = new ArrayList<>(teams);
        TeamAgeComparator comparator = new TeamAgeComparator();
        Collections.sort(teamsCopy, comparator);
        return teamsCopy;
    }

    public ArrayList<Team> DisplayTeamsByGoals() {
        ArrayList<Team> teamsCopy = new ArrayList<>(teams);
        TeamGoalsComparator comparator = new TeamGoalsComparator();
        Collections.sort(teamsCopy, comparator);
        return teamsCopy;

    }

    public void AddMatch(Match match) {
        try {
            if (match == null) {
                throw new NullPointerException("Null");
            } else {
                matches.add(match);
                FilterMatchByTime();
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
     * @throws NullPointerException If there is no elements in array list
     */
    protected void FilterMatchByTime() {
        upcomingMatches = new ArrayList<>();
        pastMatches = new ArrayList<>();
        for (Match m : matches) {
            Date now = new Date();
            if (m.matchdate.before(now)) {
                System.out.println("Match time:Past");
                try {
                    upcomingMatches.remove(m);
                } catch (NullPointerException exp) {
                    System.out.println("Null");
                }
                pastMatches.add(m);
            } else if (m.matchdate.after(now)) {
                System.out.println("Match time:upcoming");
                try {
                    pastMatches.remove(m);
                } catch (NullPointerException exp) {
                    System.out.println("Null");
                }
                upcomingMatches.add(m);

            } else {
                System.out.println("Match time:now");
                try {
                    upcomingMatches.remove(m);
                    pastMatches.remove(m);
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
    public void DeleteReferee(String refereeName){
        boolean isFound = false;
        for (int i =0 ; i <Referee.noOfReferees;i++){
            if(referees.get(i).getPersonName().equals(refereeName)){
                referees.remove(i);
                --Referee.noOfReferees;
                isFound=true;
                break;
            }
        }
    }
    public void DeleteMatch(int MatchID){
        boolean isFound = false;
        for (int i = 0; i < matches.size(); i++) {
            if (matches.get(i).getMatch_ID() == MatchID){
                matches.remove(i);
                isFound = true;
                FilterMatchByTime();
                break;
            }
        }
        if (!isFound){
            System.out.println("Invalid Match ID");
        }
    }
    public void DeleteStadium(String stadium){
        boolean isFound = false;
        for (int i = 0; i < stadiums.size(); i++) {
            if (stadiums.get(i).getStadiumName() .equals(stadium)){
                stadiums.remove(i);
                isFound = true;
                FilterMatchByTime();
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
            teamNames.add(team.getName());
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
    public Boolean searchStadiumBool(int Stadium_ID){
        for (Stadium stadium : stadiums){
            if (stadium.getStadiumID() == Stadium_ID){
                return true;
            }
        }
        return  false;
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
    public boolean searchStadiumBool(String stadiumName){
        for (Stadium stadium : stadiums){
            if (stadium.getStadiumName().equalsIgnoreCase(stadiumName)){
                return false;
            }
        }
        return  true;
    }
    public Match searchMatch(int MatchID){
        for (Match match : matches){
            if (match.getMatch_ID() == MatchID){
                return match;
            }
        }
        return null;
    }
    public void ResetLeague(){
        teams.removeAll(teams);
        matches.removeAll(matches);
        referees.removeAll(referees);
        stadiums.removeAll(stadiums);
    }
}



