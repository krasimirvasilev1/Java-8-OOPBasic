package FirstExersiceDefiningClasses.RawData;

public class Car {
    private String model;
    private Engine engine;
    private Tires tires;
    private Cargo cargo;

    public Car(String model, Engine engine, Tires tires, Cargo cargo) {
        this.model = model;
        this.engine = engine;
        this.tires = tires;
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tires getTires() {
        return tires;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
