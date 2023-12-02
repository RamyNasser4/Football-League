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
        this.tackle = tackle;
        this.cleanSheets = cleanSheets;

    }
    public Defender(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int noOfRedCards,int tackles,int cleanSheets){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,noOfRedCards);}
    public Defender(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int tackles,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,0,tackles,cleanSheets);}
    public Defender(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int tackles,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,0,tackles,cleanSheets);}
    public Defender(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int tackles,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,0,tackles,cleanSheets);}
    public Defender(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int tackles,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,0,tackles,cleanSheets);}
    public Defender(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int tackles,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,0,tackles,cleanSheets);}
    public Defender(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,int tackles,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,0.0,tackles,cleanSheets);}
    public Defender(String playerName,int playerAge,int playerSalary,String playerTeam,int tackles,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,0,tackles,cleanSheets);}
    public Defender(String playerName,int playerAge,int playerSalary,int tackles,int cleanSheets){this(playerName,playerAge,playerSalary,"",tackles,cleanSheets);}
    public Defender(String playerName,int playerAge,int tackles,int cleanSheets){this(playerName,playerAge,0,tackles,cleanSheets);}
    public Defender(String playerName,int tackles,int cleanSheets){this(playerName,0,tackles,cleanSheets);}

    public int GetTackle() {
        return tackle;
    }

    public void SetTackle(int tackle, int cleanSheets) {
        this.tackle = tackle;

    }


}
