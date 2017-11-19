package ThirdExersiceInheritance.Animals;

public class Animal extends ProduceSound {
    String name;
    int age;
    String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public Animal(String name, int age) {
        this.name = name;
        setAge(age);
    }

    private void setAge(int age) {
        if (age >= 0){
            this.age = age;
        }
        else{
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public void setName(String name) {
        if (name.trim().length() == 0){
            throw new IllegalArgumentException("Invalid input");
        }
        else{
            this.name = name;
        }
    }

    public void setGender(String gender) {
        if (gender.trim().length() == 0){
            throw new IllegalArgumentException("Invalid input");
        }
        else{
            this.gender = gender;
        }
    }

    @Override
    public String toString() {
        return String.format(this.getClass().getSimpleName()+"%n"+this.name+" "+this.age+" "+this.gender+"%n"+produceSound(this.getClass().getSimpleName()));

    }
}
