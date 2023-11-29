package League.Person.Player;

public class Forward extends Player {
    protected int shots;

    public Forward() {
        super();
        this.shots = 0;
    }

public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int noOfRedCards){super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,noOfRedCards);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards){this(shots,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists){this(shots,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored){this(shots,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank){this(shots,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore){this(shots,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber){this(shots,playerName,playerAge,playerSalary,playerTeam,playerNumber,0.0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam){this(shots,playerName,playerAge,playerSalary,playerTeam,0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary){this(shots,playerName,playerAge,playerSalary,"");}
    public Forward(int shots,String playerName,int playerAge){this(shots,playerName,playerAge,0);}
    public Forward(int shots,String playerName){this(shots,playerName,0);}


    public int GetShots() {
        return shots;
    }

    public void SetShots(int shots) {
        this.shots = shots;
    }
}
