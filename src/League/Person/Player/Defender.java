package League.Person.Player;

public class Defender extends Player {
    protected int tackle;
    protected int cleanSheets;

    public Defender() {
        super();
        this.tackle = 0;
        this.cleanSheets = 0;
    }

    public Defender(int tackle, int cleanSheets) {
        super();
        this.tackle = tackle;
        this.cleanSheets = cleanSheets;

    }


   /* public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards){super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists){this(tackle,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored){this(tackle,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank){this(tackle,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore){this(tackle,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber){this(tackle,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,0.0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam){this(tackle,cleanSheets,playerName,playerAge,playerSalary,playerTeam,0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary){this(tackle,cleanSheets,playerName,playerAge,playerSalary,"");}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge){this(tackle,cleanSheets,playerName,playerAge,0);}
    public Defender(int tackle,int cleanSheets,String playerName){this( tackle,cleanSheets,playerName,0);}*/
   public Defender(int tackles,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int noOfRedCards){
       super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,noOfRedCards);
   }
    public Defender(int tackles,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards);
        this.NoOfRedCards=0;
    }
    public Defender(int tackles,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
    }
    public Defender(int tackles,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
    }
    public Defender(int tackles,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
    }
    public Defender(int tackles,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
        this.playerRank=0;
    }
    public Defender(int tackles,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
        this.playerRank=0;
        this.playerScore=0;
    }
    public Defender(int tackles,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam){
        super(playerName,playerAge,playerSalary,playerTeam);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
        this.playerRank=0;
        this.playerScore=0;
        this.playerNumber=0;
    }
    public Defender(int tackles,int cleanSheets,String playerName,int playerAge,int playerSalary){
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
    public Defender(int tackles,int cleanSheets,String playerName,int playerAge){
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
    public Defender(int tackles,int cleanSheets,String playerName){
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
    public Defender(int shots){
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

    public int GetTackle() {
        return tackle;
    }

    public void SetTackle(int tackle, int cleanSheets) {
        this.tackle = tackle;

    }


}
