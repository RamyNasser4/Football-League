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

    public Goalkeeper(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int noOfRedCards,int saves,int cleanSheets){super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,noOfRedCards);}
    public Goalkeeper(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int saves,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,0,saves,cleanSheets);}
    public Goalkeeper(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int saves,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,0,saves,cleanSheets);}
    public Goalkeeper(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int saves,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,0,saves,cleanSheets);}
    public Goalkeeper(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int saves,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,0,saves,cleanSheets);}
    public Goalkeeper(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int saves,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,0,saves,cleanSheets);}
    public Goalkeeper(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,int saves,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,0.0,saves,cleanSheets);}
    public Goalkeeper(String playerName,int playerAge,int playerSalary,String playerTeam,int saves,int cleanSheets){this(playerName,playerAge,playerSalary,playerTeam,0,saves,cleanSheets);}
    public Goalkeeper(String playerName,int playerAge,int playerSalary,int saves,int cleanSheets){this(playerName,playerAge,playerSalary,"",saves,cleanSheets);}
    public Goalkeeper(String playerName,int playerAge,int saves,int cleanSheets){this(playerName,playerAge,0,saves,cleanSheets);}
    public Goalkeeper(String playerName,int saves,int cleanSheets){this(playerName,0,saves,cleanSheets);}



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
