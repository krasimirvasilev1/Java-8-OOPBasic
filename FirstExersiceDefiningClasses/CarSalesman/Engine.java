package FirstExersiceDefiningClasses.CarSalesman;

public class Engine {
    String model;
    int power;
    String displacement = "n/a";
    String efficiency = "n/a";

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    @Override
    public String toString() {
        return String.format("    Power: %d%n    Displacement: %s%n    Efficiency: %s%n",this.power,getDisplacement(),getEfficiency());
    }
}
