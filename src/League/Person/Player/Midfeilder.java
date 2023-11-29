package League.Person.Player;

public class Midfeilder extends Player {
    protected int keyPasses;

    public Midfeilder() {
        super();
        this.keyPasses = 0;

    }

    /*public Midfeilder(int keyPasses) {
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
    public Midfeilder(int keyPasses,String playerName){this(keyPasses,playerName,0);}*/
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int noOfRedCards){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,noOfRedCards);
    }
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards);
        this.NoOfRedCards=0;
    }
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
    }
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
    }
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
    }
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
        this.playerRank=0;
    }
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
        this.playerRank=0;
        this.playerScore=0;
    }
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary,String playerTeam){
        super(playerName,playerAge,playerSalary,playerTeam);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
        this.playerRank=0;
        this.playerScore=0;
        this.playerNumber=0;
    }
    public Midfeilder(int keyPasses,String playerName,int playerAge,int playerSalary){
        super(playerName,playerAge,playerSalary);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
        this.playerRank=0;
        this.playerScore=0;
        this.playerNumber=0;
        this.playerTeam=null;
    }
    public Midfeilder(int keyPasses,String playerName,int playerAge){
        super(playerName,playerAge);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
        this.playerRank=0;
        this.playerScore=0;
        this.playerNumber=0;
        this.playerTeam=null;
        this.Salary=0;
    }
    public Midfeilder(int keyPasses,int shots,String playerName){
        super(playerName);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
        this.playerRank=0;
        this.playerScore=0;
        this.playerNumber=0;
        this.playerTeam=null;
        this.Salary=0;
        this.Age=0;
    }
    public Midfeilder(int keyPasses){
        super();
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
        this.playerRank=0;
        this.playerScore=0;
        this.playerNumber=0;
        this.playerTeam=null;
        this.Salary=0;
        this.Age=0;
        this.Name=null;
    }
    public int GetKeyPasses() {
        return keyPasses;
    }

    public void SetKeyPasses(int keyPasses) {
        this.keyPasses = keyPasses;
    }

}
