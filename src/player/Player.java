package player;

import Person.Person;

public class Player extends Person {
    protected int playerId;
    protected String playerTeam;
    protected int playerNumber;
    protected double playerScore;
    protected int playerRank;
    protected int goalsScored;
    protected int assits;
    protected int noOfYellowCards;
    protected int NoOfRedCards;
    public Player() {

    }

    public Player(String playerName, int playerId, String playerTeam, int playerNum, int playerAge, double playerScore, int playerRank) {
        super();
        this.Name = playerName;
        this.playerId = playerId;
        this.playerTeam = playerTeam;
        this.playerNumber = playerNum;
        this.Age = playerAge;
        this.playerScore = playerScore;
        this.playerRank = playerRank;
        this.goalsScored = 0;
        this.noOfYellowCards = 0;
        this.NoOfRedCards = 0;
        this.assits = 0;
    }

    public Player(Player player) {
        super();
        this.Name = player.Name;
        this.playerId = player.playerId;
        this.playerTeam = player.playerTeam;
        this.playerNumber = player.playerNumber;
        this.Age = player.Age;
        this.playerScore = player.playerScore;
        this.playerRank = player.playerRank;
        this.goalsScored = player.goalsScored;
        this.noOfYellowCards = player.noOfYellowCards;
        this.NoOfRedCards = player.NoOfRedCards;
        this.assits = player.assits;
    }

    // Get
    public String GetPlayerName() {
        return Name;
    }

    public int GetPlayerId() {
        return playerId;
    }

    public String GetPlayerTeam() {
        return playerTeam;
    }

    public int GetPlayerNumber() {
        return playerNumber;
    }

    public int GetPlayerAge() {
        return Age;
    }

    public double GetPlayerScore() {
        return playerScore;
    }

    public int GetPlayerRank() {
        return playerRank;
    }
    // Set

    public void SetPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void SetPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public void SetPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }


    public void SetPlayerScore(double playerScore) {
        this.playerScore = playerScore;
    }

    public void SetPlayerRank(int playerRank) {
        this.playerRank = playerRank;
    }

    public void MakeAssist() {
        assits++;
    }

    public void ScoreGoal() {
        goalsScored++;
    }

    public void DisplayPlayer(String Name, int playerId) {
        if (this.Name.equals(Name)) {
            System.out.println("Player Name: " + Name);
            System.out.println("Player Id: " + playerId);
            System.out.println("Player Team: " + playerTeam);
            System.out.println("Player Shirt number: " + playerNumber);
            System.out.println("Player Age: " + Age);
            System.out.println("Player number of goals: " + goalsScored);
            System.out.println("Player Score: " + playerScore);
            System.out.println("Player Rank: " + playerRank);
        }
        if (this.playerId == playerId) {
            System.out.println("Player Name: " + Name);
            System.out.println("Player Id: " + playerId);
            System.out.println("Player Team: " + playerTeam);
            System.out.println("Player Shirt number: " + playerNumber);
            System.out.println("Player Age: " + Age);
            System.out.println("Player number of goals: " + goalsScored);
            System.out.println("Player Score: " + playerScore);
            System.out.println("Player Rank: " + playerRank);
        } else {
            System.out.println("Not found");
        }

    }


}
