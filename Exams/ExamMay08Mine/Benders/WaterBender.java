package ExamMay08Mine.Benders;

import ExamMay08Mine.Engine.CommandControler;

public class WaterBender extends Bender {
    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    @Override
    public double totalPower() {
        return super.getPower() * this.waterClarity;
    }

    @Override
    public void addToAllBenders() {
        CommandControler nations = new CommandControler();
    }

    @Override
    public String toString() {
        return String.format("###Water Bender: %s, Power: %d, Water Clarity: %.2f",this.name,this.power,this.waterClarity);
    }
}
