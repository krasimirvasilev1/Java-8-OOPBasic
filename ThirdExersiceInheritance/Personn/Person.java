package ThirdExersiceInheritance.Personn;

public class Person {
    String name;
    int age;

    public Person(String name,int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    protected void setAge(int age) {
        if (age >= 0){
            this.age = age;
        }
        else{
            throw new IllegalArgumentException("Age must be positive");
        }
    }

    protected void setName(String name){
        if (name.length() > 2){
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
    }

}
