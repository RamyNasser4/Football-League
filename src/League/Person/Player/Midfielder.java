package League.Person.Player;

public class Midfielder extends Player {
    protected int keyPasses;

    public Midfielder(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards, int keyPasses,Boolean isCaptain) {
        super(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, noOfRedCards,isCaptain);
        this.keyPasses = keyPasses;
    }
    public Midfielder(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards,int keyPasses) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, noOfRedCards, keyPasses,false);
    }
    public Midfielder(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, noOfRedCards, 0);
    }


    public Midfielder(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, 0);
    }

    public Midfielder(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, 0);
    }

    public Midfielder(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, 0);
    }

    public Midfielder(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, 0);
    }

    public Midfielder(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, 0);
    }


    public Midfielder(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, 0);
    }

    public Midfielder(String playerName, int playerAge, int playerSalary, String playerTeam) {
        this(playerName, playerAge, playerSalary, playerTeam, 0);
    }


    public Midfielder(String playerName, int playerAge, int playerSalary) {
        this(playerName, playerAge, playerSalary," ");
    }
    public Midfielder(String playerName, int playerAge) {
        this(playerName, playerAge,0);
    }
    public Midfielder(String playerName) {
        this(playerName,0);
    }
    public Midfielder(){
        this("");
    }
    public Midfielder(Midfielder midfielder){
        super();
        try {
            this.Name = midfielder.Name;
            this.playerTeam = midfielder.playerTeam;
            this.playerNumber = midfielder.playerNumber;
            this.Age = midfielder.Age;
            this.playerScore = midfielder.playerScore;
            this.playerRank = midfielder.playerRank;
            this.isCaptain = midfielder.isCaptain;
            this.goalsScored = midfielder.goalsScored;
            this.noOfYellowCards = midfielder.noOfYellowCards;
            this.NoOfRedCards = midfielder.NoOfRedCards;
            this.assists = midfielder.assists;
            this.keyPasses = midfielder.keyPasses;
        } catch (NullPointerException exp){
            System.out.println("Null");
        }
    }
    public String WriteMidfielder(){
        return Name + "\t" + Age + "\t" + Salary + "\t" + playerTeam + "\t" + playerNumber + "\t" + playerScore + "\t"  + playerRank + "\t" + goalsScored + "\t" + assists + "\t" + noOfYellowCards + "\t" + NoOfRedCards + "\t" + keyPasses + "\t" + isCaptain;
    }
    public int GetKeyPasses() {
        return keyPasses;
    }

    public void SetKeyPasses(int keyPasses) {
        this.keyPasses = keyPasses;
    }

}
