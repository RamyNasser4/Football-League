package League.Team;

import java.util.Comparator;

public class TeamGoalsComparator implements Comparator<Team> {

    @Override
    public int compare(Team team1, Team team2) {
        return (Integer.compare(team2.GetTeamGoals(), team1.GetTeamGoals()));
    }
}
