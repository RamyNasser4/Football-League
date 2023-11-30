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

    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards){super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,0);}
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists){this(keyPasses,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,0);}
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored){this(keyPasses,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,0);}
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank){this(keyPasses,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,0);}
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore){this(keyPasses,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,0);}
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber){this(keyPasses,playerName,playerAge,playerSalary,playerTeam,playerNumber,0.0);}
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam){this(keyPasses,playerName,playerAge,playerSalary,playerTeam,0);}
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary){this(keyPasses,playerName,playerAge,playerSalary,"");}
    public Midfeilder(int keyPasses,String playerName,int playerAge){this(keyPasses,playerName,playerAge,0);}
    public Midfeilder(int keyPasses,String playerName){this(keyPasses,playerName,0);}



    public int GetKeyPasses() {
        return keyPasses;
    }

    public void SetKeyPasses(int keyPasses) {
        this.keyPasses = keyPasses;
    }

}
