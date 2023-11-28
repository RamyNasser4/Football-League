package League.Person.Refree;
import League.Match.Match;
import League.Person.Person;

public class Referee extends Person {

    public  int  noYellowCards;
    public  int noRedCards;

    public Referee() {
        super();
        noYellowCards=0;
        noRedCards=0;
    }

    public Referee(String refereeName) {
     super(refereeName);
        noYellowCards=0;
        noRedCards=0;
    }

    public Referee(String refereeName,int refereeAge)
    {
       super(refereeName,refereeAge);
        noYellowCards=0;
        noRedCards=0;
    }
    public Referee(String refereeName, int refereeAge, int Salary) {
        super(refereeName,refereeAge,Salary);
        noYellowCards=0;
        noRedCards=0;
    }

    public Referee(Referee Ref) {
        this(Ref.Name, Ref.Age, Ref.Salary);
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
}
