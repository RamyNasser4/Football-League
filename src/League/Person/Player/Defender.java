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


    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards){super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists){this(tackle,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored){this(tackle,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank){this(tackle,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore){this(tackle,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber){this(tackle,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,0.0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam){this(tackle,cleanSheets,playerName,playerAge,playerSalary,playerTeam,0);}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge,int playerSalary){this(tackle,cleanSheets,playerName,playerAge,playerSalary,"");}
    public Defender(int tackle,int cleanSheets,String playerName,int playerAge){this(tackle,cleanSheets,playerName,playerAge,0);}
    public Defender(int tackle,int cleanSheets,String playerName){this( tackle,cleanSheets,playerName,0);}


    public int GetTackle() {
        return tackle;
    }

    public void SetTackle(int tackle, int cleanSheets) {
        this.tackle = tackle;

    }


}
