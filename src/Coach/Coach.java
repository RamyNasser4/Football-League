package Coach;

import Person.Person;

public class Coach extends Person {
    public String Nationality;
    // public Team Current_team;//

    public Coach(String name, int age, int salary, String nationality) {
        super(name, age, salary);
        this.Nationality = nationality;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

}
 /*  public Team getCurrent_team() {
        return Current_team;
    }

    public void setCurrent_team (Team currenTeam)
       {Current_team=currenTeam;
    }*/