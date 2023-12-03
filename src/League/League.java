package League;

import League.Match.Match;
import League.Person.Player.Goalkeeper;
import League.Person.Player.Player;
import League.Team.Team;
import League.Team.TeamAgeComparator;
import League.Team.TeamGoalsComparator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Date;

public class League {
    public int matchCount;
    public Date DATE;
    ArrayList<Match> matches;
    ArrayList<Team> teams;
    ArrayList<Player> searchByNameAndTeam;
    public League(ArrayList<Match> matches, ArrayList<Team> teams, int matchCount, Date Date) {
        this.matches = new ArrayList<>(matches);
        this.teams = new ArrayList<>(teams);
        this.matchCount = matchCount;
        this.DATE = Date;
    }

    public League(ArrayList<Match> matches, ArrayList<Team> teams, int matchCount) {
        this(matches, teams, matchCount, null);
    }

    public League(ArrayList<Match> matches, ArrayList<Team> teams) {
        this(matches, teams, 0);
    }

    public League(ArrayList<Match> matches) {
        this(matches, null);
    }

    public League() {
        this(null);
    }

    public Player[] DisplayTopScorers() {
            Player[] topScorers = new Player[3];
            for (int i = 0; i < 3; i++) {
                    int maxGoals = -1;
                for (int j = 0; j < teams.size(); j++) {
                    for (int k = 0; k < teams.get(j).getTotal(); k++) {
                        if (teams.get(j).getPlayers().get(k).getGoalsScored() > maxGoals &&
                                teams.get(j).getPlayers().get(k) != topScorers[0] &&
                                teams.get(j).getPlayers().get(k) != topScorers[1])
                                    {
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

    void DisplayTeamByAvgAge() {
        ArrayList<Team> teamscopy = new ArrayList<>(teams);
        TeamAgeComparator comparator = new TeamAgeComparator();
        Collections.sort(teamscopy, comparator);
        for (Team teams : teamscopy) {
            System.out.println(teams.getName() + " Average Age is " + teams.GetAvgTeamAge());
        }
    }

    public void DisplayTeamsByGoals() {
        ArrayList<Team> teamscopy = new ArrayList<>(teams);
        TeamGoalsComparator comparator = new TeamGoalsComparator();
        Collections.sort(teamscopy, comparator);
    }
    public void AddMatch(Match match) {
        try {
            if (match == null) {
                throw new NullPointerException("Null");
            } else {
                matches.add(match);
                matchCount++;
            }
        }
        catch (NullPointerException e) {
            System.out.println("Objects cant be null");
        }

    }

    public void Display_match_ByDateFN(String date) {
        ArrayList<Match> matchesByDate = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date currentDate = dateFormat.parse(date);
            for (Match match : matches) {
                if (match.matchdate.equals(currentDate)) {
                    matchesByDate.add(match);
                }
            }
        } catch (Throwable throwable) {
            System.out.println("Wrong input");
        }
    }
//Function to filter matches as held or to be held
protected void FilterMatchByTime(Match match) {
   for (Match m : matches) {
        ArrayList<Match> upcomingMatches = new ArrayList<>();
        ArrayList<Match> pastMatches = new ArrayList<>();
        Date now = new Date();
        if (m.matchdate.before(now)) {
            System.out.println("Match time:Past");
            try {
                pastMatches.add(match);
            } catch (NullPointerException exp) {
                System.out.println("Null");
            }

        } else if (m.matchdate.after(now)) {
            System.out.println("Match time:upcoming");
            try {
                upcomingMatches.add(match);
            } catch (NullPointerException exp) {
                System.out.println("Null");
            }
        } else {
            System.out.println("Match time:now");
        }
    }
}
//when called pass team.name and player.name
protected void SearchByNameAndTeam(String teamname,String playername){
    searchByNameAndTeam.clear();
        for (Team t: teams){
            if(teamname.equals(t.Name)){
                for (Player p: t.Players){
                    if(playername.equals(p.Name)){
                      searchByNameAndTeam.add(p);
                    }
                }
            }
        }
    int resultCount =  searchByNameAndTeam.size();
    if(resultCount==0){
        System.out.println("No results Found");
    }
    else if(resultCount==1){
        System.out.println(resultCount +" result found");
    }
    else{
        System.out.println(resultCount +" results found");
    }
    for(Player p: searchByNameAndTeam){
        //to be replaced in gui
        System.out.println(p);
    }
    }





}



