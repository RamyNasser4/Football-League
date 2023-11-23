package Person;

public abstract class Person {
    public String Name;
    public int Age;
    public int Salary;
public Person() {


    }
 public Person(String Name,int Age,int Salary){
    this.Name=Name;
    this.Age=Age;
    this.Salary=Salary;
 }
    public String getPersonName() {
        return Name;
    }

    public int getPersonAge() {
        return Age;
    }

    public int getPersonSalary() {
        return Salary;
    }
}
