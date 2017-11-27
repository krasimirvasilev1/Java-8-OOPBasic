package ExamMay08Mine.Benders;

import ExamMay08Mine.Engine.CommandControler;

public class AirBender extends Bender {
    private double aerialIntegirty;

    public AirBender(String name, int power,double aerialIntegirty) {
        super(name, power);
        this.aerialIntegirty = aerialIntegirty;
    }

    @Override
    public double totalPower() {
        return super.getPower() * this.aerialIntegirty;
    }

    @Override
    public void addToAllBenders() {
        CommandControler nations = new CommandControler();
    }

    @Override
    public String toString() {
        return String.format("###Air Bender: %s, Power: %d, Aerial Integrity: %.2f",this.name,this.power,this.aerialIntegirty);
    }
}
