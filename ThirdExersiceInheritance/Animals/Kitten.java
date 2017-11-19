package ThirdExersiceInheritance.Animals;

public class Kitten extends Cat {

    public Kitten(String name, int age, String gender) {
        super(name, age);
        setGender(gender);
    }

    @Override
    public void setGender(String gender) {
        if (!gender.equalsIgnoreCase("Female")){
            throw new IllegalArgumentException("Invalid input!");
        }
        if (gender.trim().length() == 0){
            throw new IllegalArgumentException("Invalid input");
        }
        else{
            this.gender = gender;
        }
    }
}
