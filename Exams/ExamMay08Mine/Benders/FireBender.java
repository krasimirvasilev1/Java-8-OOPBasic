package ExamMay08Mine.Benders;

import ExamMay08Mine.Engine.CommandControler;

public class FireBender extends Bender {
    private double heatAggression;

    public FireBender(String name, int power,double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    @Override
    public double totalPower() {
        return super.getPower() * this.heatAggression;
    }

    @Override
    public void addToAllBenders() {
        CommandControler nations = new CommandControler();
    }

    @Override
    public String toString() {
        return String.format("###Fire Bender: %s, Power: %d, Heat Aggression: %.2f",this.name,this.power,this.heatAggression);
    }
}
