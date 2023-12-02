package League.Person.Player;

public class Defender extends Player {
    protected int tackle;
    protected int cleanSheets;

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards, int tackles, int cleanSheets) {
        super(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, noOfRedCards);
        this.cleanSheets = cleanSheets;
        this.tackle = tackles;
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards, int tackles) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, noOfRedCards, tackles, 0);
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards, int noOfRedCards) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, noOfRedCards, 0);
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists, int noOfYellowCards) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, noOfYellowCards, 0);
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored, int assists) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, assists, 0);
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank, int goalsScored) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, goalsScored, 0);
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore, int playerRank) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, playerRank, 0);
    }

    public Defender(String playerName, int playerAge, int playerSalary, String playerTeam, int playerNumber, double playerScore) {
        this(playerName, playerAge, playerSalary, playerTeam, playerNumber, playerScore, 0);
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
        this(playerName, 0);
    }

    public Defender() {
        this("");
    }
    public int GetTackle() {
        return tackle;
    }

    public void SetTackle(int tackle) {
        this.tackle = tackle;
    }

    public int getCleanSheets() {
        return cleanSheets;
    }

    public void setCleanSheets(int cleanSheets) {
        this.cleanSheets = cleanSheets;
    }
}
