package League.Person.Player;

import javax.tools.ForwardingFileObject;

public class Forward extends Player {
    protected int shots;

    public Forward() {
        super();
        this.shots = 0;
    }

/*public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int noOfRedCards){
    super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,noOfRedCards);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards){this(shots,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists){this(shots,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored){this(shots,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank){this(shots,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore){this(shots,playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber){this(shots,playerName,playerAge,playerSalary,playerTeam,playerNumber,0.0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam){this(shots,playerName,playerAge,playerSalary,playerTeam,0);}
    public Forward(int shots,String playerName,int playerAge,int playerSalary){this(shots,playerName,playerAge,playerSalary,"");}
    public Forward(int shots,String playerName,int playerAge){this(shots,playerName,playerAge,0);}
    public Forward(int shots,String playerName){this(shots,playerName,0);}*/
public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int noOfRedCards){
    super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,noOfRedCards);
}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards);
        this.NoOfRedCards=0;
}
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
    }
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
    }
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
    }
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
        this.playerRank=0;
    }
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber){
        super(playerName,playerAge,playerSalary,playerTeam,playerNumber);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
        this.playerRank=0;
        this.playerScore=0;
    }
    public Forward(int shots,String playerName,int playerAge,int playerSalary,String playerTeam){
        super(playerName,playerAge,playerSalary,playerTeam);
        this.NoOfRedCards=0;
        this.noOfYellowCards=0;
        this.assists=0;
        this.goalsScored=0;
        this.playerRank=0;
        this.playerScore=0;
        this.playerNumber=0;
    }
    public Forward(int shots,String playerName,int playerAge,int playerSalary){
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
    public Forward(int shots,String playerName,int playerAge){
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
    public Forward(int shots,String playerName){
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
    public Forward(int shots){
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
    public int GetShots() {
        return shots;
    }

    public void SetShots(int shots) {
        this.shots = shots;
    }
}
