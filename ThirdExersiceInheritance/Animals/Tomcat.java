package ThirdExersiceInheritance.Animals;

public class Tomcat extends Cat {

    public Tomcat(String name, int age, String gender) {
        super(name, age);
        setGender(gender);
    }

    @Override
    public void setGender(String gender) {
        if (!gender.equalsIgnoreCase("Male")){
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
