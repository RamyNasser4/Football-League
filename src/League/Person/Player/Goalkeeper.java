package League.Person.Player;

/**
 * This class represents Goalkeepers
 */
public class Goalkeeper extends Player {
    /**
     *  Saves and clean sheets
     * uniquely identifies Goalkeepers
     */
    protected int GoalsConceded;

    public Goalkeeper(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int noOfRedCards,int GoalsConceded,Boolean isCaptain){super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,noOfRedCards,isCaptain);
        this.GoalsConceded = GoalsConceded;

    }
    public Goalkeeper(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards,int GoalsConceded) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, noOfRedCards,GoalsConceded, false);
    }
    public Goalkeeper(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, noOfRedCards,0);
    }
    public Goalkeeper(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, 0);
    }
    public Goalkeeper(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, 0);
    }
    public Goalkeeper(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, 0);
    }
    public Goalkeeper(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank,0);
    }
    public Goalkeeper(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore,0);
    }
    public Goalkeeper(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, 0);
    }
    public Goalkeeper(String playerName, int playerAge, int playerSalary, String playerTeam) {
        this(playerName, playerAge, playerSalary, playerTeam,0);
    }
    public Goalkeeper(String playerName, int playerAge, int playerSalary) {
        this(playerName, playerAge, playerSalary, " ");
    }
    public Goalkeeper(String playerName, int playerAge) {
        this(playerName, playerAge, 0);
    }
    public Goalkeeper(String playerName) {
        this(playerName,0);
    }
    public Goalkeeper(){
        this("");
    }
    public Goalkeeper(Goalkeeper goalkeeper){
        super();
        try {
            this.Name = goalkeeper.Name;
            this.playerTeam = goalkeeper.playerTeam;
            this.playerNumber = goalkeeper.playerNumber;
            this.Age = goalkeeper.Age;
            this.playerScore = goalkeeper.playerScore;
            this.playerRank = goalkeeper.playerRank;
            this.isCaptain = goalkeeper.isCaptain;
            this.goalsScored = goalkeeper.goalsScored;
            this.noOfYellowCards = goalkeeper.noOfYellowCards;
            this.NoOfRedCards = goalkeeper.NoOfRedCards;
            this.assists = goalkeeper.assists;
            this.GoalsConceded = goalkeeper.GoalsConceded;
        } catch (NullPointerException exp){
            System.out.println("Null");
        }
    }
    public String WriteGoalkeeper(){
        return "Goalkeeper" + "\t" + Name + "\t" + Age + "\t" + Salary + "\t" + playerTeam + "\t" + playerNumber + "\t" + playerScore + "\t"  + playerRank + "\t" + goalsScored + "\t" + assists + "\t" + noOfYellowCards + "\t" + NoOfRedCards + "\t" + GoalsConceded + "\t" +  "\t" + isCaptain;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.GoalsConceded = goalsConceded;
    }

    public int getGoalsConceded() {
        return GoalsConceded;
    }
}
