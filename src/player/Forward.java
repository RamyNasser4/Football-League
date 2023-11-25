package player;

public class Forward extends Player {
    protected int shots;

    public Forward() {
        super();
        this.shots = 0;
    }

   /* public Forward(int shots, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore, int playerRank ,int assists,int noOfYellowCards,int noOfRedCards) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore, playerRank,assists,noOfYellowCards,noOfRedCards);
    }
    public Forward(int shots, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore, int playerRank ,int assists,int noOfYellowCards) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore, playerRank,assists,noOfYellowCards);
        this.NoOfRedCards=0;

    }
    public Forward(int shots, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore, int playerRank ,int assists) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore, playerRank,assists);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;

    }
    public Forward(int shots, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore, int playerRank ) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore, playerRank);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
    }
    /*public Forward(int shots, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.playerRank=0;
    }
    public Forward(int shots, String Name, int playerId, String playerTeam, int playerNum, int Age) {
        super(Name, playerId, playerTeam, playerNum, Age);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.playerRank=0;
        this.playerScore=0;

    }
    public Forward(int shots, String Name, int playerId, String playerTeam, int playerNum) {
        super(Name, playerId, playerTeam, playerNum);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.playerRank=0;
        this.playerScore=0;
this.Age=0;
    }
    public Forward(int shots, String Name, int playerId, String playerTeam) {
        super(Name, playerId, playerTeam);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.playerNumber=0;
    }
    public Forward(int shots, String Name, int playerId) {
        super(Name, playerId);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.playerTeam=null;
    }
    public Forward(int shots, String Name) {
        super(Name);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.playerTeam=null;
        this.playerId=0;
    }*/


    public int GetShots() {
        return shots;
    }

    public void SetShots(int shots) {
        this.shots = shots;
    }
}
