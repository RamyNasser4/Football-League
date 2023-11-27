package League.Coach;

import League.Person.Person;
import League.Team.Team;
public class Coach extends Person {
    public String Nationality;
    public Team CurrentTeam;

    public Coach(String name, int age, int salary, String nationality, Team CurrentTeam) {
        super(name, age, salary);
        this.Nationality = nationality;
        this.CurrentTeam=CurrentTeam;
    }
    public Coach(String name, int age, int salary, String nationality){
        this(name,age,salary,nationality,null);
    }
    public Coach(String name, int age, int salary){
        this(name,age,salary,"");
    }
    public Coach(String name, int age){
        this(name,age,0);
    }
    public Coach(String name){
        this(name,0);

    }
    public Coach(){
        this("");
    }
    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }


    public Team getCurrentTeam() {
        return CurrentTeam;
    }

    public void setCurrentTeam(Team currentTeam) {
        CurrentTeam = currentTeam;
    }

    public Coach(Coach otherCoach) {
        super(otherCoach.Name, otherCoach.Age,otherCoach.Salary);
                this.Nationality= otherCoach.Nationality;
                 this.CurrentTeam=otherCoach.CurrentTeam;
    }
}
