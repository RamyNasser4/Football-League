package Person;

public class Player extends Person {
    private String playerName;
    private int playerId;
    private String playerTeam;
    private int playerNumber;
    private int playerAge;
    private double playerScore;
    private int playerRank;
    private int goalsScored;
    private int noOfYellowCards;
    private int NoOfRedCards;
    public Player(String playerName,int playerId,String playerTeam,int playerNum,int playerAge,double playerScore,int playerRank){
        this.playerName = playerName;
        this.playerId = playerId;
        this.playerTeam = playerTeam;
        this.playerNumber = playerNum;
        this.playerAge = playerAge;
        this.playerScore = playerScore;
        this.playerRank = playerRank;
        this.goalsScored=0;
        this.noOfYellowCards=0;
        this.NoOfRedCards=0;
    }
    // Get
    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public double getPlayerScore() {
        return playerScore;
    }

    public int getPlayerRank() {
        return playerRank;
    }
    // Set
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public void setPlayerScore(double playerScore) {
        this.playerScore = playerScore;
    }

    public void setPlayerRank(int playerRank) {
        this.playerRank = playerRank;
    }

    public void makeGoal(){
        goalsScored++;
    }
    public void displayPlayer(){
        System.out.println("Player Name: " + playerName);
        System.out.println("Player Id: " + playerId);
        System.out.println("Player Team: " + playerTeam);
        System.out.println("Player Shirt number: " + playerNumber);
        System.out.println("Player Age: " + playerAge);
        System.out.println("Player number of goals: " + goalsScored);
        System.out.println("Player Score: " + playerScore);
        System.out.println("Player Rank: " + playerRank);
    }
}
