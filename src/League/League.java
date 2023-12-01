package League;

import League.Match.Match;
import League.Person.Player.Goalkeeper;
import League.Person.Player.Player;
import League.Team.Team;
import League.Team.*;

import java.util.Arrays;

public interface League {

    Match[] matches = new Match[34];
    Team[] teams = new Team[18];

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
      /*  public Player[] DisplayTopGoalKeepers() {
                Player[] topKeepers = new Player[3];
                int max = 0;
                for (int i=0;i<3;i++) {
                        for (int j = 0; j < teams.length; j++) {
                                for (int k = 0; k < teams[j].getTotal(); k++) {
                                        if (teams[j].getPlayers()[k] instanceof Goalkeeper) {
                                                topKeepers[i] = (Goalkeeper) teams[j].getPlayers()[k];
                                                if (max < ((Goalkeeper) teams[j].getPlayers()[k]).GetSaves()) {
                                                        max = ((Goalkeeper) teams[j].getPlayers()[k]).GetSaves();
                                                        topKeepers[i + 1] = topKeepers[i];
                                                        topKeepers[i] = (Goalkeeper) teams[j].getPlayers()[k];
                                                }

                                        }
                                }
                        }
                }
                return topKeepers;
        }*/
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

}



