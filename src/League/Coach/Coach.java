package League.Coach;

import League.Person.Person;
import League.Team.Team;
public class Coach extends Person {
    public String Nationality;
    public Team CurrentTeam;

    public Coach(String name, int age, int salary, String nationality, Team CurrentTeam) {
        super(name, age, salary);
        this.Nationality = nationality;
        try{
            this.CurrentTeam=CurrentTeam;
        }catch (NullPointerException exp){
            System.out.println("Null Team");
        }

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
        try {
            CurrentTeam = currentTeam;
        }catch (NullPointerException exp){
            System.out.println("Null Match");
        }
    }
    public Coach(Coach otherCoach) throws NullPointerException {
        super();
        try {
            this.Name = otherCoach.Name;
            this.Age = otherCoach.Age;
            this.Salary = otherCoach.Salary;
            this.Nationality= otherCoach.Nationality;
            try {
                this.CurrentTeam=otherCoach.CurrentTeam;
            }catch (NullPointerException exp){
                System.out.println("Null coach team");
            }
        }catch (NullPointerException exp){
            System.out.println("Null obj coach");
        }
    }
}
