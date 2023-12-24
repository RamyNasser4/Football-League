package League.Person;

public abstract class Person {
    public String Name;
    public int Age;
    public int Salary;
   public Person(String Name, int Age, int Salary){
        this.Name = Name;
        this.Age = Age;
        this.Salary= Salary;
   }
    public Person(String Name,int Age){this(Name,Age,0);}
    public Person(String Name){this(Name,0);}
    public Person() {this("");}

    public String getPersonName() {
        return Name;
    }

    public int getPersonAge() {
        return Age;
    }

    public int getPersonSalary() {
        return Salary;
    }

    public void setPersonName(String Name) {
         this.Name=Name;
    }

    public void setPersonAge(int Age) {

       this.Age=Age;
    }

    public void setPersonSalary(int Salary) {
        this.Salary=Salary;
    }
    public abstract int CalculateSalary();
}
