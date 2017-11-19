package ThirdExersiceInheritance.Personn;

public class Child extends Person {
    String name;
    int age;

    public Child(String name, int age) {
        super(name,age);
    }

    @Override
    protected void setAge(int age) {
        if (age > 15){
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        else{
           super.setAge(age);
        }
    }
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s, Age: %d",this.getName(),this.getAge()));
        return  builder.toString();
    }
}
