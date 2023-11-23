package Referee;

public class Referee {
    private String RefereeName;
    private int RefereeAge;
//   public Match match =new Match();
    public static int  noYellowCards=0;
    public static int noRedCards=0;

    public Referee(String refereeName, int refereeAge/*, Match match*/) {
        RefereeName = refereeName;
        RefereeAge = refereeAge;
//        this.match = match;
    }

    public void makeYellowCards(){

        noYellowCards++;
    }
    public void makeRedCards(){

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
}
