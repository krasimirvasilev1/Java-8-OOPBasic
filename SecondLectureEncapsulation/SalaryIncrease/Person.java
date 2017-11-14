package SecondLectureEncapsulation.SalaryIncrease;

public class Person {
    private String firstName;
    private String secondName;
    private int age;
    private double salary;


    public Person(String firstName, String secondName, int age, double salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.salary = salary;
    }

        void getBonus (double bonus){
        double receivedBonus = bonus / 100;
        if (this.age < 30){
            this.salary += this.salary * (receivedBonus / 2);
        }
        else{
            this.salary += this.salary * receivedBonus;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva",this.firstName,this.secondName,this.salary);
    }
}
