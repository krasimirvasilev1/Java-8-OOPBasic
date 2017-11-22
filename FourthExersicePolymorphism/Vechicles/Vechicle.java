package FourthExersicePolymorphism.Vechicles;

abstract public class Vechicle {
    protected double fuelQuantity;
    protected double fuelConsumptionByKilometer;

    public Vechicle(double fuelQuantity, double fuelConsumptionByKilometer) {
        this.fuelQuantity = fuelQuantity;
        setFuelConsumptionByKilometer(fuelConsumptionByKilometer);
    }


    public void setFuelConsumptionByKilometer(double fuelConsumptionByKilometer) {
        this.fuelConsumptionByKilometer = fuelConsumptionByKilometer;
    }

    abstract void distanceTraveled(double distanceToBeTraveled);
    abstract void refuel(double additionalFuel);

}
