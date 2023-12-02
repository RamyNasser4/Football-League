package League.Person.Referee;
import League.Person.Person;

public class Referee extends Person {
    public  int  noYellowCards;
    public  int noRedCards;

    public Referee(String refereeName, int refereeAge, int Salary, int noYellowCards, int noRedCards) {
        super(refereeName, refereeAge, Salary);
        this.noYellowCards = noYellowCards;
        this.noRedCards = noRedCards;
    }

    public Referee(String refereeName, int refereeAge, int Salary, int noYellowCards) {
        this(refereeName, refereeAge, Salary, noYellowCards, 0);
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
    /*public Referee() {
        super(refereeName,refereeAge,Salary);

    }*/

    public Referee(Referee Ref) {
        try {
            this.Name=Ref.Name;
            this.Age=Ref.Age;
            this.Salary=Ref.Salary;
            noYellowCards=0;
            noRedCards=0;
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
}
