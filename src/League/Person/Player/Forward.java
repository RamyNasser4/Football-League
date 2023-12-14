package League.Person.Player;

public class Forward extends Player {
    protected int shots;


    public Forward(String playerName,int playerAge,int playerSalary,String playerTeam,int playerNumber,double playerScore,int playerRank,int goalsScored,int assists,int noOfYellowCards,int noOfRedCards,int shots,Boolean isCaptain){
    super(playerName,playerAge,playerSalary,playerTeam,playerNumber,playerScore,playerRank,goalsScored,assists,noOfYellowCards,noOfRedCards,isCaptain);
    this.shots=shots;
    }
    public Forward(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards,int shots) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, noOfRedCards,shots,false);
    }
    public Forward(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, noOfRedCards,0);
    }
    public Forward(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards,0);
    }
    public Forward(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists,0);
    }
    public Forward(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored,0);
    }
    public Forward(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank,0);
    }
    public Forward(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore,0);
    }
    public Forward(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber,0);
    }
    public Forward(String playerName, int playerAge, int playerSalary, String playerTeam) {
        this(playerName, playerAge, playerSalary, playerTeam,0);
    }
    public Forward(String playerName, int playerAge, int playerSalary) {
        this(playerName, playerAge, playerSalary,"");
    }
    public Forward(String playerName, int playerAge) {
        this(playerName, playerAge,0);
    }
    public Forward(String playerName){
        this(playerName,0);
    }
    public Forward(){
        this("");
    }
    public Forward(Forward forward){
        super();
        try {
            this.Name = forward.Name;
            this.Salary = forward.Salary;
            this.playerTeam = forward.playerTeam;
            this.playerNumber = forward.playerNumber;
            this.Age = forward.Age;
            this.playerScore = forward.playerScore;
            this.playerRank = forward.playerRank;
            this.isCaptain = forward.isCaptain;
            this.goalsScored = forward.goalsScored;
            this.noOfYellowCards = forward.noOfYellowCards;
            this.NoOfRedCards = forward.NoOfRedCards;
            this.assists = forward.assists;
            this.shots = forward.shots;
        } catch (NullPointerException exp){
            System.out.println("Null");
        }
    }
    public String WriteForward(){
        return Name + "\t" + Age + "\t" + Salary + "\t" + playerTeam + "\t" + playerNumber + "\t" + playerScore + "\t"  + playerRank + "\t" + goalsScored + "\t" + assists + "\t" + noOfYellowCards + "\t" + NoOfRedCards + "\t" + shots + "\t" + isCaptain;
    }
    public int GetShots() {
        return shots;
    }

    public void SetShots(int shots) {
        this.shots = shots;
    }
}
