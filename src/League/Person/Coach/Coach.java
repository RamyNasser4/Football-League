package League.Person.Coach;

import League.Person.Person;
import League.Team.Team;
public class Coach extends Person {
    public String Nationality;
    public int TeamID;

    public Coach(String name, int age, int salary, String nationality, int TeamID) {
        super(name, age, salary);
        this.Nationality = nationality;
        this.TeamID = TeamID;
    }
    public Coach(String name, int age, int salary, String nationality){
        this(name,age,salary,nationality,0);
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


    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }
    public String writeCoach(){
        return this.Name + "\t" + this.Age + "\t" + this.Salary + "\t" + this.Nationality;
    }

    public Coach(Coach otherCoach) throws NullPointerException {
        super();
        try {
            this.Name = otherCoach.Name;
            this.Age = otherCoach.Age;
            this.Salary = otherCoach.Salary;
            this.Nationality= otherCoach.Nationality;
            this.TeamID = otherCoach.TeamID;
        }catch (NullPointerException exp){
            System.out.println("Null obj coach");
        }
    }
}
