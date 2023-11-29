package League.Person.Player;

import League.Person.Person;

public class Player extends Person

{
    protected static int numberOfPlayers=0;
    protected final int playerId;
    protected String playerTeam;
    protected int playerNumber;
    protected double playerScore;
    protected int playerRank;
    protected int goalsScored;
    protected int assists;
    protected int noOfYellowCards;
    protected int NoOfRedCards;


   public Player(String playerName,int playerAge, int playerSalary,String playerTeam,int playerNumber, double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards, int noOfRedCards){
       super(playerName,playerAge,playerSalary);
       this.playerTeam = playerTeam;
       this.playerNumber = playerNumber;
       this.playerScore = playerScore;
       this.playerRank = playerRank;
       this.goalsScored=goalsScored;
       this.noOfYellowCards=noOfYellowCards;
       this.NoOfRedCards=noOfRedCards;
       this.assists=assists;
       this.playerId=++numberOfPlayers;
   }

    public Player(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,0);}
    public Player(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,0);}
    public Player(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,0);}
    public Player(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,0);}
    public Player(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,0);}
    public Player(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,0.0);}
    public Player(String playerName,int playerAge,int playerSalary,String playerTeam){this(playerName,playerAge,playerSalary,playerTeam,0);}
    public Player(String playerName,int playerAge,int playerSalary){this(playerName,playerAge,playerSalary,"");}
    public Player(String playerName,int playerAge){this(playerName,playerAge,0);}
    public Player(String playerName){this(playerName,0);}
    public Player(){this("");}

    // additional constructor
    public Player(String playerName,String playerTeam,int playerNum,int playerAge,int playerSalary,double playerScore,int playerRank,int assists,int noOfYellowCards,int noOfRedCards)
    {
        super(playerName,playerAge,playerSalary);

        this.playerTeam = playerTeam;
        this.playerNumber = playerNum;
        this.playerScore = playerScore;
        this.playerRank = playerRank;
        this.assists=assists;
        this.noOfYellowCards=noOfYellowCards;
        this.NoOfRedCards=noOfRedCards;
    }
    public Player(String playerName,String playerTeam,int playerNumber,int playerAge,int playerSalary,double playerScore,int playerRank,int assists,int noOfYellowCards){this(playerName,playerTeam,playerNumber,playerAge,playerSalary,playerScore,playerRank,assists,noOfYellowCards,0);}
    public Player(String playerName,String playerTeam,int playerNumber,int playerAge,int playerSalary,double playerScore,int playerRank,int assists){this(playerName,playerTeam,playerNumber,playerAge,playerSalary,playerScore,playerRank,assists,0);}
    public Player(Player player) {
        super();
        try {
            this.Name = player.Name;
            this.playerId=++numberOfPlayers;
            this.playerTeam = player.playerTeam;
            this.playerNumber = player.playerNumber;
            this.Age = player.Age;
            this.playerScore = player.playerScore;
            this.playerRank = player.playerRank;
            this.goalsScored = player.goalsScored;
            this.noOfYellowCards = player.noOfYellowCards;
            this.NoOfRedCards = player.NoOfRedCards;
            this.assists = player.assists;
        }
        catch (NullPointerException exp){
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

    public int getGoalsScored() {
        return goalsScored;
    }
    // Set

    /*public void SetPlayerId(int playerId) {
        this.playerId = playerId;
    }*/

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
