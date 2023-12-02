package League.Person.Player;

import javax.tools.ForwardingFileObject;

public class Forward extends Player {
    protected int shots;

    public Forward() {
        super();
        this.shots = 0;
    }


public Forward(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int noOfRedCards,int shots){
    super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,noOfRedCards);}
    public Forward(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int shots){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,0,shots);}
    public Forward(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int shots){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,0,shots);}
    public Forward(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int shots){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,0,shots);}
    public Forward(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int shots){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,0,shots);}
    public Forward(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int shots){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,0,shots);}
    public Forward(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,int shots){this(playerName,playerAge,playerSalary,playerTeam,playerNumber,0.0,shots);}
    public Forward(String playerName,int playerAge,int playerSalary,String playerTeam,int shots){this(playerName,playerAge,playerSalary,playerTeam,0,shots);}
    public Forward(String playerName,int playerAge,int playerSalary,int shots){this(playerName,playerAge,playerSalary,"",shots);}
    public Forward(String playerName,int playerAge,int shots){this(playerName,playerAge,0,shots);}
    public Forward(String playerName,int shots){this(playerName,0,shots);}

    public int GetShots() {
        return shots;
    }

    public void SetShots(int shots) {
        this.shots = shots;
    }
}
