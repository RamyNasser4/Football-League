package League;

import League.Match.Match;
import League.Person.Player.Player;
import League.Team.Team;


import java.util.Arrays;

public interface League {

        Match[] matches=new Match[34];
        Team[] teams=new Team[18];
        void DisplayTopScorers();
        void DisplayTopGoalKeepers();
        void DisplayByGoals();
        void DisplayByAge();
        void DisplayByDate(String date);

       default void DisplayTeamByAvgAge(){
           double min=0;
           Team[] teamscopy= Arrays.copyOf(teams,teams.length);
                for(Team teams:teamscopy){
                   Arrays.sort(teamscopy);
                }
           for(Team teams:teamscopy){
               System.out.println(teams.getName()+" Average Age is "+teams.AvgTeamAge());
           }
        }


}
