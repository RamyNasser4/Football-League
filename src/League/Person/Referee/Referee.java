package League.Person.Referee;
import League.Match.Match;
import League.Person.Person;

import java.util.ArrayList;

public class Referee extends Person {
    public  int  noYellowCards;
    public  int noRedCards;
    protected int RefereeID;
    private static int noOfReferees = 0;
    protected ArrayList<Match> matches;

    public Referee(String refereeName, int refereeAge, int Salary, int noYellowCards, int noRedCards,ArrayList<Match> matches) {
        super(refereeName, refereeAge, Salary);
        ++noOfReferees;
        this.RefereeID = noOfReferees;
        this.noYellowCards = noYellowCards;
        this.noRedCards = noRedCards;
        this.matches = matches;
    }
    public Referee(String refereeName, int refereeAge, int Salary, int noYellowCards, int noRedCards) {
        this(refereeName, refereeAge, Salary, noYellowCards, 0,new ArrayList<>());
    }

    public Referee(String refereeName, int refereeAge, int Salary, int noYellowCards) {
        this(refereeName, refereeAge, Salary, noYellowCards, 0);
    }
    public Referee(String refereeName, int refereeAge, int Salary) {
        this(refereeName, refereeAge, Salary,0);
    }
    public Referee(String refereeName, int refereeAge) {
        this(refereeName, refereeAge,0);
    }
    public Referee(String refereeName) {
        this(refereeName, 0);
    }
    public Referee(){
        this("");
    }
    public Referee(Referee Ref) {
        try {
            this.Name=Ref.Name;
            this.Age=Ref.Age;
            this.Salary=Ref.Salary;
            noYellowCards=0;
            noRedCards=0;
            this.RefereeID = ++noOfReferees;
            this.matches = Ref.matches;
        }
             catch (Exception e) {

            System.out.println("Null");
        }
    }
    public  void makeYellowCards(){

        noYellowCards++;
    }
    public  void makeRedCards(){

        noRedCards++;
    }

    public void display (){
        System.out.println("the Referee name:  ");
        System.out.println(Name);
        System.out.println("the Referee age:  ");
        System.out.println(Age);
        System.out.println("the number of yellow cards in this match:  ");
        System.out.println(noYellowCards);
        System.out.println("the number of red cards in this match:  ");
        System.out.println(noRedCards);
    }
    public String WriteReferee(){
        return this.Name + "\t" + this.Age + "\t" + this.Salary + "\t" + noYellowCards + "\t" + noRedCards;
    }

    public int getRefereeID() {
        return RefereeID;
    }

    public void setRefereeID(int refereeID) {
        RefereeID = refereeID;
    }
    public boolean checkAvailability(String date){
        for (Match match : matches){
            if (match.getMatchDate().equalsIgnoreCase(date)){
                return false;
            }
        }
        return true;
    }
    public void AddMatch(Match match){
        try {
            matches.add(match);
        }catch (Exception exp){
            System.out.println("Invalid Match");
        }
    }
    public void deleteMatch(int MatchID){
        for (Match match : matches){
            if (match.getMatch_ID() == MatchID){
                matches.remove(match);
            }
        }
    }
}
