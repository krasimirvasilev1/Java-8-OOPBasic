package FourthExersicePolymorphism.Vechicles;

import java.text.DecimalFormat;

public class Truck extends Vechicle{

    public Truck(double fuelQuantity, double fuelConsumptionByKilometer) {
        super(fuelQuantity, fuelConsumptionByKilometer);
    }

    @Override
    public void setFuelConsumptionByKilometer(double fuelConsumptionByKilometer){
        this.fuelConsumptionByKilometer = fuelConsumptionByKilometer + 1.6;
    }
    @Override
    void distanceTraveled(double distanceToBeTraveled) {
        if (distanceToBeTraveled * this.fuelConsumptionByKilometer > this.fuelQuantity){
            System.out.println(getClass().getSimpleName()+" needs refueling");
        }
        else{
            this.fuelQuantity -= distanceToBeTraveled * this.fuelConsumptionByKilometer;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            System.out.println(getClass().getSimpleName()+" travelled "+decimalFormat.format(distanceToBeTraveled)+" km");
        }
    }

    @Override
    void refuel(double additionalFuel) {
        this.fuelQuantity += additionalFuel * 0.95;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",getClass().getSimpleName(),this.fuelQuantity);
    }
}
