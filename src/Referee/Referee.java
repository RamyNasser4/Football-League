package Referee;
import Match.*;
public class Referee {
    private String RefereeName;
    private int RefereeAge;
    public Match match ;
    public  int  noYellowCards=0;
    public  int noRedCards=0;

    public Referee() {
        RefereeName = null;
        RefereeAge=0;
        noYellowCards=0;
        noRedCards=0;
    }

    public Referee(String refereeName) {
        this();
        RefereeName = refereeName;

    }

    public Referee(String refereeName,int refereeAge)
    {
        this(refereeName);
        RefereeAge = refereeAge;
    }

    public Referee(String refereeName, int refereeAge, Match match) {
        this(refereeName,refereeAge);
      this.match = match;
        noYellowCards=0;
        noRedCards=0;
    }

    public  void makeYellowCards(){

        noYellowCards++;
    }
    public  void makeRedCards(){

        noRedCards++;
    }

    public String getRefereeName() {
        return RefereeName;
    }

    public void setRefereeName(String refereeName) {
        this.RefereeName = refereeName;
    }

    public int getRefreeAge() {
        return RefereeAge;
    }

    public void setRefreeAge(int refreeAge) {
        this.RefereeAge = refreeAge;
    }
    public void display (){
        System.out.println("the Referee name:  ");
        System.out.println(RefereeName);
        System.out.println("the Referee age:  ");
        System.out.println(RefereeAge);
        System.out.println("the number of yellow cards in this match:  ");
        System.out.println(noYellowCards);
        System.out.println("the number of red cards in this match:  ");
        System.out.println(noRedCards);
    }
}
