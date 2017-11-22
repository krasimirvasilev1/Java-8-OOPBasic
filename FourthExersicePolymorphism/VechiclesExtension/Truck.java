package FourthExersicePolymorphism.VechiclesExtension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumptionByKilometer, double fuelCapacity) {
        super(fuelQuantity, fuelConsumptionByKilometer, fuelCapacity);
    }

    @Override
    public void setFuelConsumptionByKilometer(double fuelConsumptionByKilometer) {
        this.fuelConsumptionByKilometer = fuelConsumptionByKilometer + 1.6;
    }

    @Override
    void distanceTraveled(double distanceToBeTraveled, boolean isEmpty) {
        double fuelQuantityConsumed = distanceToBeTraveled * this.fuelConsumptionByKilometer;
        if (fuelQuantityConsumed > this.fuelQuantity) {
            System.out.println(getClass().getSimpleName() + " needs refueling");
        } else {
            this.fuelQuantity -= fuelQuantityConsumed;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            System.out.println(getClass().getSimpleName() + " travelled " + decimalFormat.format(distanceToBeTraveled) + " km");
        }
    }

    @Override
    void refuel(double addition) {
        if (addition <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (addition + this.fuelQuantity > this.fuelCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += addition * 0.95;

    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), this.fuelQuantity);
    }
}
