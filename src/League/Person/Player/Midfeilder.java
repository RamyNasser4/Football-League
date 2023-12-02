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

    public Midfeilder(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int keyPasses){super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,0);}
    public Midfeilder(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int keyPasses){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,0,keyPasses);}
    public Midfeilder(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int keyPasses){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,0,keyPasses);}
    public Midfeilder(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int keyPasses){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,0,keyPasses);}
    public Midfeilder(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int keyPasses){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,0,keyPasses);}
    public Midfeilder(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,int keyPasses){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,0.0,keyPasses);}
    public Midfeilder(String playerName,int playerAge,int playerSalary,String playerTeam,int keyPasses){this(playerName,playerAge,playerSalary,playerTeam,0,keyPasses);}
    public Midfeilder(String playerName,int playerAge,int playerSalary,int keyPasses){this(playerName,playerAge,playerSalary,"",keyPasses);}
    public Midfeilder(String playerName,int playerAge,int keyPasses){this(playerName,playerAge,0,keyPasses);}
    public Midfeilder(String playerName,int keyPasses){this(playerName,0,keyPasses);}



    public int GetKeyPasses() {
        return keyPasses;
    }

    public void SetKeyPasses(int keyPasses) {
        this.keyPasses = keyPasses;
    }

}
