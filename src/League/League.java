package League;

import League.Match.Match;
import League.Team.Team;

public interface League {

        Match[] matches=new Match[34];
        Team[] teams=new Team[18];

        void DisplayTopScorers();
        void DisplayTopGoalKeepers();
        void DisplayByGoals();
        void DisplayByAge();
        void DisplayByDate(String date);


}
