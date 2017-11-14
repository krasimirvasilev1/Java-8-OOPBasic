package SecondLectureEncapsulation.FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String secondName;
    private int age;
    private double salary;

    public int getAge() {
        return age;
    }

    public Person(String firstName, String secondName, int age, double salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.salary = salary;
    }
}
