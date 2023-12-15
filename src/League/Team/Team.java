package League.Team;

import League.Match.Match;
import League.Person.Coach.Coach;
import League.Person.Player.Goalkeeper;
import League.Person.Player.Player;

import java.util.ArrayList;

public class Team {
    protected static int noOfTeams = 0;
    public String Name;
    public ArrayList<Player> Players;
    //can be final
    protected int Team_ID;
    protected Player Captain;
    protected Coach Coach;
    protected int Total_score;
    protected int noOfPlayers;
    protected int noOfGoalkeepers;
    protected ArrayList<Match> Matches;


    public Team(String Name, ArrayList<Player> Players, Player Captain, Coach Coach, ArrayList<Match> Matches, int Total_score, int noOfPlayers, int noOfGoalkeepers) {
        ++noOfTeams;
        this.Name = Name;
        this.Team_ID = noOfTeams;
        this.Players = new ArrayList<>(Players);
        try {
            this.Captain = Captain;
        } catch (NullPointerException exp) {
            System.out.println("Null");
        }
        try {
            this.Coach = Coach;
        } catch (NullPointerException exp) {
            System.out.println("Null coach");
        }
        this.Matches = new ArrayList<>(Matches);
        this.Total_score = Total_score;
        this.noOfPlayers = noOfPlayers;
        this.noOfGoalkeepers = noOfGoalkeepers;
    }

    public Team(String Name, ArrayList<Player> Players, Player Captain, Coach Coach, ArrayList<Match> Matches, int Total_score, int noOfPlayers) {
        this(Name, Players, Captain, Coach, Matches, Total_score, noOfPlayers, 0);
    }

    public Team(String Name, ArrayList<Player> Players, Player Captain, Coach Coach, ArrayList<Match> Matches, int Total_score) {
        this(Name, Players, Captain, Coach, Matches, Total_score, 0);
    }

    public Team(String Name, ArrayList<Player> Players, Player Captain, Coach Coach, ArrayList<Match> Matches) {
        this(Name, Players, Captain, Coach, Matches, 0);
    }

    public Team(String Name, ArrayList<Player> Players, Player Captain, Coach Coach) {
        this(Name, Players, Captain, Coach, new ArrayList<>());
    }

    public Team(String Name, ArrayList<Player> Players, Player Captain) {
        this(Name, Players, Captain, null);
    }

    public Team(String Name, ArrayList<Player> Players) {
        this(Name, Players, null);
    }

    public Team(String Name) {
        this(Name, new ArrayList<>());
    }

    public Team() {
        this("");
    }

    public Team(Team team) {
        try {
            this.Name = team.Name;
            this.Team_ID = team.Team_ID;
            this.Players = new ArrayList<>(team.Players);
            try {
                this.Captain = new Player(team.Captain);
            } catch (NullPointerException exp) {
                System.out.println("Null captain");
            }
            try {
                this.Coach = new Coach(team.Coach);
            } catch (NullPointerException exp) {
                System.out.println("Null coach");
            }
            this.Matches = new ArrayList<>(team.Matches);
            this.Total_score = team.Total_score;
            this.noOfPlayers = team.noOfPlayers;
        } catch (NullPointerException exp) {
            System.out.println("Null object");
        }
    }

    public static int getNoOfTeams() {
        return noOfTeams;
    }

    public static void setNoOfTeams(int noOfTeams) {
        Team.noOfTeams = noOfTeams;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getTeam_ID() {
        return Team_ID;
    }

    public void setTeam_ID(int Team_ID) {
        this.Team_ID = Team_ID;
    }

    public ArrayList<Player> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<Player> Players) {
        this.Players = new ArrayList<>(Players);
        this.noOfPlayers = Players.size();
    }

    public Player getCaptain() {
        return Captain;
    }

    public void setCaptain(Player Captain) {
        try {
            this.Captain = new Player(Captain);
        } catch (NullPointerException exp) {
            System.out.println("Null captain");
        }
    }

    public Coach getCoach() {
        return Coach;
    }

    public void setCoach(Coach coach) {
        try {
            Coach = coach;
        } catch (NullPointerException exp) {
            System.out.println("Null coach");
        }
    }

    public int getTotal_score() {
        return Total_score;
    }

    public void setTotal_score(int Total_score) {
        this.Total_score = Total_score;
    }

    public int getTotal() {
        return noOfPlayers;
    }

    public void setNoOfPlayers(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }

    public double GetAvgTeamAge() {
        double avgAge = 0;
        for (Player player : Players) {
            avgAge += player.getPersonAge();
        }
        return (avgAge /= noOfPlayers);
    }

    public int GetTeamGoals() {
        int teamGoals = 0;
        for (Player player : Players) {
            teamGoals += player.getGoalsScored();
        }
        return teamGoals;
    }

    public void display() {
        //
    }

    public void displayPlayers() {
        //
    }

    public void displayMatches() {
        //
    }

    public void addPlayer(Player player) throws NullPointerException {
        try {
            if (noOfPlayers < 25) {
                if (player instanceof Goalkeeper && noOfGoalkeepers < 3) {
                    Players.add(player);
                    ++noOfPlayers;
                    ++noOfGoalkeepers;
                } else if (!(player instanceof Goalkeeper)) {
                    Players.add(player);
                    ++noOfPlayers;
                } else {
                    throw new Exception("Maximum capacity of goalkeepers reached");
                }
            } else {
                throw new Exception("Maximum capacity of players reached");
            }
        } catch (NullPointerException exp) {
            System.out.println("Null");
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }

    public void deletePlayer(int PlayerID) {
        boolean isFound = false;
        for (int i = 0; i < noOfPlayers; i++) {
            if (Players.get(i).GetPlayerId() == PlayerID) {
                Players.remove(i);
                --noOfPlayers;
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Invalid ID");
        }
    }

    public void deletePlayer(String playerName) {
        boolean isFound = false;
        for (int i = 0; i < noOfPlayers; i++) {
            if (Players.get(i).GetPlayerName().equals(playerName)) {
                Players.remove(i);
                --noOfPlayers;
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Invalid Name");
        }
    }

    public Player searchPlayer(String name) {
        for (int i = 0; i < noOfPlayers; i++) {
            if (Players.get(i).GetPlayerName().equals(name)) {
                return Players.get(i);
            }
        }
        return null;
    }

    public Player searchPlayer(int ID) {
        for (int i = 0; i < noOfPlayers; i++) {
            if (Players.get(i).GetPlayerId() == ID) {
                return Players.get(i);
            }
        }
        return null;
    }
    public String WriteTeam(){
        return Name + "\t" + Total_score + "\t" + noOfPlayers + "\t" + noOfGoalkeepers;
    }
}
