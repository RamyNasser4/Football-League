package League.Person.Player;

public class Goalkeeper extends Player {
    protected int saves;
    protected int cleanSheets;

    public Goalkeeper() {
        super();
        this.saves = 0;
        this.cleanSheets = 0;
    }

    public Goalkeeper(int saves, int cleanSheets) {
        super();
        this.saves = saves;
        this.cleanSheets = cleanSheets;
    }

    public Goalkeeper(int saves,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int noOfRedCards){super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,noOfRedCards);}
    public Goalkeeper(int saves,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards){this(saves,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,0);}
    public Goalkeeper(int saves,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists){this(saves,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,0);}
    public Goalkeeper(int saves,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored){this(saves,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,0);}
    public Goalkeeper(int saves,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank){this(saves,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,0);}
    public Goalkeeper(int saves,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore){this(saves,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,0);}
    public Goalkeeper(int saves,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber){this(saves,cleanSheets,playerName,playerAge,playerSalary,playerTeam,playerNumber,0.0);}
    public Goalkeeper(int saves,int cleanSheets,String playerName,int playerAge,int playerSalary,String playerTeam){this(saves,cleanSheets,playerName,playerAge,playerSalary,playerTeam,0);}
    public Goalkeeper(int saves,int cleanSheets,String playerName,int playerAge,int playerSalary){this(saves,cleanSheets,playerName,playerAge,playerSalary,"");}
    public Goalkeeper(int saves,int cleanSheets,String playerName,int playerAge){this(saves,cleanSheets,playerName,playerAge,0);}
    public Goalkeeper(int saves,int cleanSheets,String playerName){this(saves,cleanSheets,playerName,0);}



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
