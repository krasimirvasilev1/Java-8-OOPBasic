package ExamPawIncMine.pawInc.Animals;

public class Dog extends Animal {
    private int amountOfCommands;

    public Dog(String name, int age, int amountOfCommands) {
        super(name, age);
        this.amountOfCommands = amountOfCommands;
    }
}
