package player;

public class Defender extends Player {
    protected int tackle;
    protected int cleanSheets;

    public Defender() {
        super();
        this.tackle=0;
        this.cleanSheets=0;
    }
public Defender(int tackle,int cleanSheets){
        this.tackle=tackle;
        this.cleanSheets=cleanSheets;

}

    public Defender(int tackle, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore, int playerRank) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore, playerRank);
    }
   /* public Defender(int tackle, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore);
        this.playerRank=0;
    }
    public Defender(int tackle, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum, int Age) {
        super(Name, playerId, playerTeam, playerNum, Age);
        this.playerRank=0;
        this.playerScore=0;
    }
    public Defender(int tackle, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum) {
        super(Name, playerId, playerTeam, playerNum);
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
    }
    public Defender(int tackle, int cleansSheets, String Name, int playerId, String playerTeam) {
        super(Name, playerId, playerTeam);
        this.playerRank=0;
        this.playerScore=0;
        this.playerScore=0;
        this.Age=0;
    }
    public Defender(int tackle, int cleansSheets, String Name, int playerId) {
        super(Name, playerId);
        this.playerRank = 0;
        this.playerScore = 0;
        this.playerScore = 0;
        this.Age = 0;
        this.playerTeam = null;
    }
    public Defender(int tackle, int cleansSheets, String Name) {
        super(Name);
        this.playerRank = 0;
        this.playerScore = 0;
        this.playerScore = 0;
        this.Age = 0;
        this.playerTeam = null;
        this.playerId=0;
    }*/

    public int GetTackle() {
        return tackle;
    }

    public void SetTackle(int tackle,int cleanSheets) {
        this.tackle = tackle;

    }


}