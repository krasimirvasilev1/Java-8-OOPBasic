package FourthExersicePolymorphism.VechiclesExtension;

abstract public class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumptionByKilometer;
    protected double fuelCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumptionByKilometer,double fuelCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumptionByKilometer(fuelConsumptionByKilometer);
        this.fuelCapacity = fuelCapacity;
    }
    public void setFuelConsumptionByKilometer(double fuelConsumptionByKilometer) {
        this.fuelConsumptionByKilometer = fuelConsumptionByKilometer;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity > 0){
            this.fuelQuantity += fuelQuantity;
        }
        else{
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }
    abstract void distanceTraveled(double distanceToBeTraveled,boolean isEmptyOrNot);
    abstract void refuel(double additionalFuel);

}
