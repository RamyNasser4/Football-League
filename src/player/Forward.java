package player;

public class Forward extends Player {
    protected int shots;

    public Forward() {
        super();
        this.shots=0;
    }

    public Forward(int shots, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore, int playerRank) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore, playerRank);
    }
    /*public Forward(int shots, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore);
        this.playerRank=0;
    }
    public Forward(int shots, String Name, int playerId, String playerTeam, int playerNum, int Age) {
        super(Name, playerId, playerTeam, playerNum, Age);
        this.playerRank=0;
        this.playerScore=0;

    }
    public Forward(int shots, String Name, int playerId, String playerTeam, int playerNum) {
        super(Name, playerId, playerTeam, playerNum);
        this.playerRank=0;
        this.playerScore=0;
this.Age=0;
    }
    public Forward(int shots, String Name, int playerId, String playerTeam) {
        super(Name, playerId, playerTeam);
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.playerNumber=0;
    }
    public Forward(int shots, String Name, int playerId) {
        super(Name, playerId);
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.playerTeam=null;
    }
    public Forward(int shots, String Name) {
        super(Name);
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
