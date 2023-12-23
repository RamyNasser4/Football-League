package League.Person.Player;

/**
 * This class represents Defenders
 */
public class Defender extends Player {
    /**
     *  tackles and clean sheets
     * uniquely identifies Defenders 
     */


    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards,Boolean isCaptain) {
        super(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, noOfRedCards,isCaptain);

    }
    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, noOfRedCards, false);
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards,0);
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists,0);
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored,0);
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, 0);
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore,0);
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, 0);
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam) {
        this(playerName, playerAge, playerSalary, playerTeam, 0);
    }

    public Defender(String playerName, int playerAge, int playerSalary) {
        this(playerName, playerAge, playerSalary, "");
    }

    public Defender(String playerName, int playerAge) {
        this(playerName, playerAge, 0);
    }

    public Defender(String playerName) {
        this(playerName,0);
    }

    public Defender() {
        this("");
    }
    public Defender(Defender defender){
        super();
        try {
            this.Name = defender.Name;
            this.playerTeam = defender.playerTeam;
            this.playerNumber = defender.playerNumber;
            this.Age = defender.Age;
            this.playerScore = defender.playerScore;
            this.playerRank = defender.playerRank;
            this.isCaptain = defender.isCaptain;
            this.goalsScored = defender.goalsScored;
            this.noOfYellowCards = defender.noOfYellowCards;
            this.NoOfRedCards = defender.NoOfRedCards;
            this.assists = defender.assists;
        } catch (NullPointerException exp){
            System.out.println("Null");
        }
    }
    public String WriteDefender(){
        return "Defender" + "\t" + Name + "\t" + Age + "\t" + Salary + "\t" + playerTeam + "\t" + playerNumber + "\t" + playerScore + "\t"  + playerRank + "\t" + goalsScored + "\t" + assists + "\t" + noOfYellowCards + "\t" + NoOfRedCards + "\t" +  "\t" + isCaptain;
    }

}
