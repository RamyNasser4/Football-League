package player;

public class Defender extends Player {
    protected int tackle;
    protected int cleanSheets;

    public Defender() {
        super();
        this.tackle = 0;
        this.cleanSheets = 0;
    }

    public Defender(int tackle, int cleanSheets) {
        this.tackle = tackle;
        this.cleanSheets = cleanSheets;

    }

    /*public Defender(int tackle, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore, int playerRank,int assists,int noOfYellowCards,int noOfRedCards) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore, playerRank,assists,noOfYellowCards,noOfRedCards);
    }
    public Defender(int tackle, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore, int playerRank,int assists,int noOfYellowCards) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore, playerRank,assists,noOfYellowCards);
        this.NoOfRedCards=0;
    }
    public Defender(int tackle, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore, int playerRank,int assists) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore, playerRank,assists);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
    }*/
    public Defender(int tackle, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore, int playerRank) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore, playerRank);
        this.NoOfRedCards = 0;
        this.noOfYellowCards = 0;
        this.assists = 0;
    }
   /* public Defender(int tackle, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum, int Age, double playerScore) {
        super(Name, playerId, playerTeam, playerNum, Age, playerScore);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.playerRank=0;

    }
    public Defender(int tackle, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum, int Age) {
        super(Name, playerId, playerTeam, playerNum, Age);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.playerRank=0;
        this.playerScore=0;
    }
    public Defender(int tackle, int cleansSheets, String Name, int playerId, String playerTeam, int playerNum) {
        super(Name, playerId, playerTeam, playerNum);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.playerRank=0;
        this.playerScore=0;
        this.Age=0;
    }
    public Defender(int tackle, int cleansSheets, String Name, int playerId, String playerTeam) {
        super(Name, playerId, playerTeam);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.playerRank=0;
        this.playerScore=0;
        this.playerScore=0;
        this.Age=0;
    }
    public Defender(int tackle, int cleansSheets, String Name, int playerId) {
        super(Name, playerId);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.playerRank = 0;
        this.playerScore = 0;
        this.playerScore = 0;
        this.Age = 0;
        this.playerTeam = null;
    }
    public Defender(int tackle, int cleansSheets, String Name) {
        super(Name);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
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

    public void SetTackle(int tackle, int cleanSheets) {
        this.tackle = tackle;

    }


}
