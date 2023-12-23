package League.Person.Coach;

import League.Person.Person;

public class Coach extends Person {
    public String Nationality;
    public String TeamName;

    public Coach(String name, int age, int salary, String nationality,String TeamName) {
        super(name, age, salary);
        this.Nationality = nationality;
        this.TeamName = TeamName;
    }
    public Coach(String name, int age, int salary, String nationality){
        this(name,age,salary,nationality,"0");
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

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String writeCoach(){
        return this.Name + "\t" + this.Age + "\t" + this.Salary + "\t" + this.Nationality + "\t" + TeamName;
    }

    public Coach(Coach otherCoach) throws NullPointerException {
        super();
        try {
            this.Name = otherCoach.Name;
            this.Age = otherCoach.Age;
            this.Salary = otherCoach.Salary;
            this.Nationality= otherCoach.Nationality;
            this.TeamName = otherCoach.TeamName;
        }catch (NullPointerException exp){
            System.out.println("Null obj coach");
        }
    }
    public  int  CalculateSalary(){
        return Salary+10000;
    }
}
