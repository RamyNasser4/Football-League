package League;

import Match.Match;
import Team.Team;

public interface League {

        Match[] matches=new Match[34];
        Team[] teams=new Team[18];

        void DisplayTopScorers();
        void DisplayTopGoalKeepers();
        void DisplayByGoals(int numOfGoals);
        void DisplayByAge(int age);
        void DisplayByDate(String date);


}
