package League.Person.Player;

public class Midfeilder extends Player {
    protected int keyPasses;

    public Midfeilder() {
        super();
        this.keyPasses = 0;

    }

    public Midfeilder(int keyPasses) {
        this.keyPasses = keyPasses;
    }
//MISSING CONSTRUCTOR IN PARENT CLASS
     public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam, int playerNum, int Age,int playerSalary, double playerScore, int playerRank ,int assists,int noOfYellowCards,int noOfRedCards) {
         super(Name, playerId, playerTeam, playerNum, Age, playerSalary, playerScore, playerRank,assists,noOfYellowCards,noOfRedCards);
     }
     public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam, int playerNum, int Age,int playerSalary, double playerScore, int playerRank ,int assists,int noOfYellowCards) {
         super(Name, playerId, playerTeam, playerNum, Age, playerSalary, playerScore, playerRank,assists,noOfYellowCards);
         this.NoOfRedCards=0;
     }
     public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam, int playerNum, int Age,int playerSalary, double playerScore, int playerRank ,int assists) {
         super(Name, playerId, playerTeam, playerNum, Age,playerSalary, playerScore, playerRank,assists);
         this.NoOfRedCards=0;
         this.noOfYellowCards=0;
     }
    public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam, int playerNum, int Age,int playerSalary, double playerScore, int playerRank) {
        super(Name, playerId, playerTeam, playerNum, Age,playerSalary, playerScore, playerRank);
        this.NoOfRedCards = 0;
        this.noOfYellowCards = 0;
        this.assists = 0;
    }

    public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam, int playerNum, int Age,int playerSalary, double playerScore) {
        super(Name, playerId, playerTeam, playerNum, Age,playerSalary, playerScore);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.playerRank=0;
    }
    public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam, int playerNum, int Age,int playerSalary) {
        super(Name, playerId, playerTeam, playerNum, Age,playerSalary);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.playerRank=0;
    }
    public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam, int playerNum, int Age) {
        super(Name, playerId, playerTeam, playerNum, Age);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.playerRank=0;
        this.playerScore=0;

    }
    public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam, int playerNum) {
        super(Name, playerId, playerTeam, playerNum);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;

    }
    public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam) {
        super(Name, playerId, playerTeam);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.playerNumber=0;

    }
    public Midfeilder(int keyPasses, String Name, int playerId) {
        super(Name, playerId);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.playerNumber=0;
        this.playerTeam=null;
    }
    public Midfeilder(int keyPasses, String Name) {
        super(Name);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.playerNumber=0;
        this.playerTeam=null;
        this.playerId=0;
    }
    public int GetKeyPasses() {
        return keyPasses;
    }

    public void SetKeyPasses(int keyPasses) {
        this.keyPasses = keyPasses;
    }

}
