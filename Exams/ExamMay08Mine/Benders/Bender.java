package ExamMay08Mine.Benders;

abstract public class Bender {
    protected String name;
    protected int power;

    public Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public abstract double totalPower();

    public abstract void addToAllBenders();
}
