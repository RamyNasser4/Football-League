package Team;

import player.Player;

public class Team {
    public String Name;
    protected int Team_ID;
    protected Player[] Players;
    protected Player Captain;
    //protected Match[] Matches;
    protected int Total_score;
    protected int noOfPlayers;

    public static int noOfTeams = 0;

    public Team(String Name, Player[] Players, Player Captain, int Total_score, int noOfPlayers) {
        ++noOfTeams;
        this.Name = Name;
        this.Team_ID = noOfTeams;
        this.Players = new Player[25];
        int i = 0;
        try {
            for (Player player : Players) {
                try {
                    this.Players[i] = player;
                } catch (NullPointerException exp) {
                    System.out.println("Null");
                }
                ++i;
            }
        } catch (NullPointerException exp) {
            System.out.println("Null");
        }
        try {
            this.Captain = new Player(Captain);
        } catch (NullPointerException exp) {
            System.out.println("Null");
        }
        this.Total_score = Total_score;
        this.noOfPlayers = noOfPlayers;
    }

    public Team(String Name, Player[] Players, Player Captain, int Total_score) {
        this(Name, Players, Captain, Total_score, 0);
    }

    public Team(String Name, Player[] Players, Player Captain) {
        this(Name, Players, Captain, 0);
    }

    public Team(String Name, Player[] Players) {
        this(Name, Players, null);
    }

    public Team(String Name) {
        this(Name, null);
    }

    public Team() {
        this("");
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

    public Player[] getPlayers() {
        return Players;

    }

    public void setPlayers(Player[] Players) {
        int i = 0;
        for (Player player : Players) {
            try {
                this.Players[i] = player;
            } catch (NullPointerException exp) {
                System.out.println("Null");
            }
            ++i;
        }
        this.noOfPlayers = i;
    }

    public Player getCaptain() {
        return Captain;
    }

    public void setCaptain(Player Captain) {
        this.Captain = Captain;
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
            Players[noOfPlayers] = new Player(player);
            ++noOfPlayers;
        } catch (NullPointerException exp) {
            System.out.println("Null");
        }
    }

    public void deletePlayer(int PlayerID) {
        boolean isFound = false;
        for (int i = 0; i < noOfPlayers; i++) {
            if (Players[i].getPlayerId() == PlayerID) {
                for (int j = i; j < noOfPlayers - 1; j++) {
                        Players[i] = Players[i + 1];
                }
                Players[noOfPlayers - 1] = null;
                --noOfPlayers;
                isFound = true;
                break;
            }
        }
        if(!isFound){
            System.out.println("Invalid ID");
        }
    }

    public void deletePlayer(String playerName) {
        boolean isFound = false;
        for (int i = 0; i < noOfPlayers; i++) {
            if (Players[i].getPlayerName().equals(playerName)) {
                for (int j = i; j < noOfPlayers - 1; j++) {
                    Players[i] = Players[i + 1];
                }
                Players[noOfPlayers - 1] = null;
                --noOfPlayers;
                isFound = true;
                break;
            }
        }
        if(!isFound){
            System.out.println("Invalid Name");
        }
    }
    public Player searchPlayer(String name) {
        for (int i = 0; i < noOfPlayers; i++) {
            if(Players[i].getPlayerName().equals(name)){
                return Players[i];
            }
        }
        return null;
    }

    public Player searchPlayer(int ID) {
        for (int i = 0; i < noOfPlayers; i++) {
            if(Players[i].getPlayerId() == ID){
                return Players[i];
            }
        }
        return null;
    }
}
