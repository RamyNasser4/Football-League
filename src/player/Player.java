package player;

import Person.Person;

public class Player extends Person {
public Player(){

}
    protected int playerId;
    protected String playerTeam;
    protected int playerNumber;

    protected double playerScore;
    protected int playerRank;
    protected int goalsScored;
    protected int assits;
    protected int noOfYellowCards;
    protected int NoOfRedCards;
    public Player(String playerName,int playerId,String playerTeam,int playerNum,int playerAge,double playerScore,int playerRank){
        super();
        this.Name = playerName;
        this.playerId = playerId;
        this.playerTeam = playerTeam;
        this.playerNumber = playerNum;
        this.Age = playerAge;
        this.playerScore = playerScore;
        this.playerRank = playerRank;
        this.goalsScored=0;
        this.noOfYellowCards=0;
        this.NoOfRedCards=0;
        this.assits=0;
    }
    // Get
    public String getPlayerName() {
        return Name;
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
        return Age;
    }

    public double getPlayerScore() {
        return playerScore;
    }

    public int getPlayerRank() {
        return playerRank;
    }
    // Set

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }


    public void setPlayerScore(double playerScore) {
        this.playerScore = playerScore;
    }

    public void setPlayerRank(int playerRank) {
        this.playerRank = playerRank;
    }
public void MakeAssist(){
        assits++;
}

    public void makeGoal(){
        goalsScored++;
    }
    public void displayPlayer(String Name,int playerId){
        if(this.Name.equals(Name)){
            System.out.println("Player Name: " + Name);
            System.out.println("Player Id: " + playerId);
            System.out.println("Player Team: " + playerTeam);
            System.out.println("Player Shirt number: " + playerNumber);
            System.out.println("Player Age: " + Age);
            System.out.println("Player number of goals: " + goalsScored);
            System.out.println("Player Score: " + playerScore);
            System.out.println("Player Rank: " + playerRank);
        }
        if(this.playerId==playerId){
            System.out.println("Player Name: " + Name);
            System.out.println("Player Id: " + playerId);
            System.out.println("Player Team: " + playerTeam);
            System.out.println("Player Shirt number: " + playerNumber);
            System.out.println("Player Age: " + Age);
            System.out.println("Player number of goals: " + goalsScored);
            System.out.println("Player Score: " + playerScore);
            System.out.println("Player Rank: " + playerRank);
        }
        else{
            System.out.println("Not found");
        }

    }
}
