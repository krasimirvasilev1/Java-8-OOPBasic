package ExamMay08Mine.Benders;

import ExamMay08Mine.Engine.CommandControler;

public class EarthBender extends Bender {
    private double groundSaturation;

    public EarthBender(String name, int power,double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }

    @Override
    public double totalPower(){
        return super.getPower() * this.groundSaturation;
    }
    @Override
    public void addToAllBenders() {
        CommandControler nations = new CommandControler();
    }

    @Override
    public String toString() {
        return String.format("###Earth Bender: %s, Power: %d, Ground Saturation: %.2f",this.name,this.power,this.groundSaturation);
    }
}
