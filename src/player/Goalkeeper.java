package player;

public class Goalkeeper extends Player {
    protected int saves;
    protected int cleanSheets;

    public Goalkeeper() {
        super();
        this.saves=0;
        this.cleanSheets=0;
    }
    public  Goalkeeper(int saves,int cleanSheets){
        this.saves=saves;
        this.cleanSheets=cleanSheets;
    }

    public Goalkeeper(int saves, int cleansSheets, String playerName, int playerId, String playerTeam, int playerNum, int Age, double playerScore, int playerRank) {
        super(playerName, playerId, playerTeam, playerNum, Age, playerScore, playerRank);
    }
   /*public Goalkeeper(int saves, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore);
        this.playerRank=0;
    }
    public Goalkeeper(int saves, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum, int Age) {
        super(Name, playerId, playerTeam, playerNum, Age);
        this.playerRank=0;
        this.playerScore=0;
    }
    public Goalkeeper(int saves, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum) {
        super(Name, playerId, playerTeam, playerNum);
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
    }
    public Goalkeeper(int saves, int cleansSheets, String Name, int playerId, String playerTeam) {
        super(Name, playerId, playerTeam);
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.Name=null;
    }
    public Goalkeeper(int saves, int cleansSheets, String Name, int playerId) {
        super(Name, playerId);
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.Name=null;
        this.playerTeam=null;
    }
    public Goalkeeper(int saves, int cleansSheets, String Name) {
        super(Name);
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
        this.Name=null;
        this.playerTeam=null;
        this.playerId=0;
    }*/
    public int GetSaves() {
        return saves;
    }

    public void SetSaves(int saves) {
        this.saves = saves;
    }

    public int GetCleanSheets() {
        return cleanSheets;
    }

    public void GetCleanSheets(int cleanSheets) {
        this.cleanSheets = cleanSheets;
    }
}
