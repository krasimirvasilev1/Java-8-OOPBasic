package FirstExersiceDefiningClasses.CarSalesman;

public class Car {
    private String model;
    private String engine;
    String weight = "n/a";
    String colour = "n/a";

    public String getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Car(String model, String engine) {
        this.model = model;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return String.format("%s:%n  %s:%n",this.model,getEngine());
    }
}
