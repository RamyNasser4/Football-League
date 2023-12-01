package League;

import League.Match.Match;
import League.Person.Player.Goalkeeper;
import League.Person.Player.Player;
import League.Team.Team;
import League.Team.*;
import java.text.SimpleDateFormat;

import java.util.Comparator;
import java.util.Date;

import java.math.MathContext;
import java.util.Arrays;

public class League {

    Match[] matches = new Match[34];
    Team[] teams = new Team[18];
    public static int matchCount=0;
    public String DATE;

    /*public Player[] DisplayTopScorers(){
            Player[] topScorers = new Player[3];
            int currentTopScorer = 0;
            for (int i = 0; i < 3; i++) {
                    int maxGoals = -1;
                    for (int j = 0; j < teams.length; j++) {
                            for (int k = 0; k < teams[j].getTotal(); k++) {
                                    if(teams[j].getPlayers()[k].getGoalsScored()>maxGoals &&
                                            teams[j].getPlayers()[k] != topScorers[0] &&
                                            teams[j].getPlayers()[k] != topScorers[1] )
                                    {
                                            maxGoals = teams[j].getPlayers()[k].getGoalsScored();
                                            topScorers[currentTopScorer] = teams[j].getPlayers()[k];
                                            ++currentTopScorer;
                                    }
                            }
                    }
            }
            return topScorers;
    }*/
      public Player[] DisplayTopGoalKeepers() {
                Player[] topKeepers = new Player[3];
                int max = 0;
                topKeepers[0] = (Goalkeeper) teams[0].getPlayers()[0];
                topKeepers[1] = (Goalkeeper) teams[0].getPlayers()[0];
                topKeepers[2] = (Goalkeeper) teams[0].getPlayers()[0];

                        for (int j = 0; j < teams.length; j++) {
                                for (int k = 0; k < teams[j].getTotal(); k++) {
                                        if (teams[j].getPlayers()[k] instanceof Goalkeeper) {

                                                if (max < ((Goalkeeper) teams[j].getPlayers()[k]).GetSaves()) {
                                                        max = ((Goalkeeper) teams[j].getPlayers()[k]).GetSaves();
                                                        topKeepers[2] = topKeepers[1];
                                                        topKeepers[1] = topKeepers[0];

                                                        topKeepers[0] = (Goalkeeper) teams[j].getPlayers()[k];
                                                }

                                        }
                                }

                }
                return topKeepers;
        }
    void DisplayByGoals();

    void DisplayByAge();

    void DisplayByDate(String date);

    default void DisplayTeamByAvgAge() {
        double min = 0;
        Team[] teamscopy = Arrays.copyOf(teams, teams.length);
        for (Team teams : teamscopy) {
            Arrays.sort(teamscopy);
        }
        for (Team teams : teamscopy) {
            System.out.println(teams.getName() + " Average Age is " + teams.AvgTeamAge());
        }
    }

    default void DisplayTeamsByGoals() {
        int[] teamGoals = new int[teams.length];
        int totalTeamGoals = -1;
        for (int i = 0; i < teams.length; i++) {
            for (int j = 0; j < teams[i].getTotal(); j++) {
                teamGoals[i] += teams[i].getPlayers()[j].getGoalsScored();
            }
            if (teamGoals[i] > totalTeamGoals) {
                totalTeamGoals = teamGoals[i];
            }

        }
        // option 1
        /*Arrays.sort(teams, Comparator.comparingInt((Team team) -> teamGoals[Arrays.asList(teams).indexOf(team)]).reversed());*/
        // option 2
        for (int i = 0; i < teams.length; i++) {
            for (int j = i; j < teams.length; j++) {
                if (teamGoals[i] < teamGoals[j]) {
                    Team temp = teams[i];
                    teams[i] = teams[j];
                    teams[j] = temp;
                    int tempGoals = teamGoals[i];
                    teamGoals[i] = teamGoals[j];
                    teamGoals[j] = tempGoals;
                }
            }
        }
    }
    public void AddMatch(Match match) {
        try {
                matches[matchCount] = new Match(match);
                matchCount++;
            }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("OUT OF ARRAY BOUNDS");
        }
        catch (NullPointerException e) {
            System.out.println("Objects cant be null");
        }

    }


    public void Display_match_ByDateFN(String DATE){
             int counter =0;
        Match[] match  = new Match[matches.length];
        for (int i = 0; i < matches.length; i++) {
           if (matches[i].dateOfMatch.equals(DATE))
            {
                match[counter]=new Match(matches[i]);
                counter++;
            }

        }
    }





}



