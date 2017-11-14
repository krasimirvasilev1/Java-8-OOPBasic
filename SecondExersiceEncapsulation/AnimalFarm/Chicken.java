package SecondExersiceEncapsulation.AnimalFarm;

public class Chicken {
    private int age;
    private String name;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 15){
            this.age = age;
        }
        else{
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    public void setName(String name) {
        if (name == null || name.length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        else{
            this.name = name;
        }
    }

    private double productionOfEggsPerDay (int age){
        if (age < 6){
            return 2;
        }
        else if (age <= 12){
            return 1;
        }
        else{
            return 0.75;
        }
    }

    @Override
    public String toString() {
        if (productionOfEggsPerDay(this.age) > 0.75){
            return String.format("Chicken %s (age %d) can produce %.0f eggs per day.",this.name,this.age,productionOfEggsPerDay(this.age));
        }
        else{
            return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",this.name,this.age,productionOfEggsPerDay(this.age));
        }
    }
}
