package Person;

public abstract class Person {
    public String personName;
    public int personAge;
    public int personSalary;
    /*public Person() {

       this.personName = "Default Name";
       this.personAge = 0;
       this.personSalary = 0;
    }
 public Person(String personName,int personAge,int personSalary){
    this.personName=personName;
    this.personAge=personAge;
    this.personSalary=personSalary;
 }*/
    public String getPersonName() {
        return personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public int getPersonSalary() {
        return personSalary;
    }
}
