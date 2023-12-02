package League.Team;

import java.util.Comparator;

public class TeamAgeComparator implements Comparator<Team> {
    @Override
    public int compare(Team team1, Team team2) {
        return (Double.compare(team1.GetAvgTeamAge(), team2.GetAvgTeamAge()));
    }
}
