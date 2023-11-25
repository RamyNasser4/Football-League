package player;

public class Midfeilder extends Player {
    protected int keyPasses;

    public Midfeilder() {
        super();
        this.keyPasses=0;

    }
public Midfeilder(int keyPasses){
        this.keyPasses=keyPasses;
}

    public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore, int playerRank) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore, playerRank);
    }
    /*public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore);
        this.playerRank=0;
    }
    public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam, int playerNum, int Age) {
        super(Name, playerId, playerTeam, playerNum, Age);
        this.playerRank=0;
        this.playerScore=0;

    }
    public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam, int playerNum) {
        super(Name, playerId, playerTeam, playerNum);
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;

    }
    public Midfeilder(int keyPasses, String Name, int playerId, String playerTeam) {
        super(Name, playerId, playerTeam);
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.playerNumber=0;

    }
    public Midfeilder(int keyPasses, String Name, int playerId) {
        super(Name, playerId);
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.playerNumber=0;
        this.playerTeam=null;
    }
    public Midfeilder(int keyPasses, String Name) {
        super(Name);
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.playerNumber=0;
        this.playerTeam=null;
        this.playerId=0;
    }*/
    public int GetKeyPasses() {
        return keyPasses;
    }

    public void SetKeyPasses(int keyPasses) {
        this.keyPasses = keyPasses;
    }

}
