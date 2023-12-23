package League.Person.Player;

import League.Person.Person;

public class Player extends Person {
    protected static int playersSerialNum = 0;
    private int playerId;
    protected String playerTeam;
    protected int playerNumber;
    protected double playerScore;
    protected int playerRank;
    protected int goalsScored;
    protected int assists;
    protected int noOfYellowCards;
    protected int NoOfRedCards;
    protected Boolean isCaptain;
    public static int totalPlayers;


    public Player(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards, Boolean isCaptain) {
        super(playerName, playerAge, playerSalary);
        this.playerTeam = playerTeam;
        this.playerNumber = playerNumber;
        this.playerScore = playerScore;
        this.playerRank = playerRank;
        this.goalsScored = goalsScored;
        this.noOfYellowCards = noOfYellowCards;
        this.NoOfRedCards = noOfRedCards;
        this.assists = assists;
        this.playerId = ++playersSerialNum;
        this.isCaptain = isCaptain;
        ++totalPlayers;
    }

    public Player(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, noOfRedCards, false);
    }

    public Player(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, 0);
    }

    public Player(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, 0);
    }

    public Player(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, 0);
    }

    public Player(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, 0);
    }

    public Player(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, 0);
    }

    public Player(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, 0.0);
    }

    public Player(String playerName, int playerAge, int playerSalary, String playerTeam) {
        this(playerName, playerAge, playerSalary, playerTeam, 0);
    }

    public Player(String playerName, int playerAge, int playerSalary) {
        this(playerName, playerAge, playerSalary, "");
    }

    public Player(String playerName, int playerAge) {
        this(playerName, playerAge, 0);
    }

    public Player(String playerName) {
        this(playerName, 0);
    }

    public Player() {
        this("");
    }

    public Player(Player player) {
        super();
        this.playerId = ++playersSerialNum;
        ++totalPlayers;
        try {
            this.Name = player.Name;
            this.playerTeam = player.playerTeam;
            this.playerNumber = player.playerNumber;
            this.Age = player.Age;
            this.playerScore = player.playerScore;
            this.playerRank = player.playerRank;
            this.goalsScored = player.goalsScored;
            this.isCaptain = player.isCaptain;
            this.noOfYellowCards = player.noOfYellowCards;
            this.NoOfRedCards = player.NoOfRedCards;
            this.assists = player.assists;
        } catch (NullPointerException exp) {
            System.out.println("Null");
        }
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

    public Boolean getCaptain() {
        return isCaptain;
    }

    public void setCaptain(Boolean captain) {
        isCaptain = captain;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getAssists() {
        return assists;
    }

    public int getNoOfYellowCards() {
        return noOfYellowCards;
    }

    public int getNoOfRedCards() {
        return NoOfRedCards;
    }

// Set

    public void setNoOfYellowCards(int noOfYellowCards) {
        this.noOfYellowCards = noOfYellowCards;
    }

    public void setNoOfRedCards(int noOfRedCards) {
        NoOfRedCards = noOfRedCards;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setPlayerId(int playerId) {
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

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public void MakeAssist() {
        assists++;
    }

    public void ScoreGoal() {
        goalsScored++;
    }

    public void MakeYellowCard() {
        ++noOfYellowCards;
    }

    public void MakeRedCard() {
        ++NoOfRedCards;
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
    public  int  CalculateSalary(){
        return Salary/playerRank+5000;
    }
}