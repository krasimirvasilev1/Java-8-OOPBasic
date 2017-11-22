package FourthExersicePolymorphism.Vechicles;

import java.text.DecimalFormat;

public class Car extends Vechicle{
    public Car(double fuelQuantity, double fuelConsumptionByKilometer) {
        super(fuelQuantity, fuelConsumptionByKilometer);
    }

    @Override
    public void setFuelConsumptionByKilometer(double fuelConsumptionByKilometer){
        this.fuelConsumptionByKilometer = fuelConsumptionByKilometer + 0.9;
    }
    @Override
    void distanceTraveled(double distanceToBeTraveled) {
        if (distanceToBeTraveled * this.fuelConsumptionByKilometer > this.fuelQuantity){
            System.out.println("Car needs refueling");
        }
        else{

            this.fuelQuantity -= distanceToBeTraveled * this.fuelConsumptionByKilometer;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            System.out.println(getClass().getSimpleName()+" travelled "+decimalFormat.format(distanceToBeTraveled) + " km");
        }
    }

    @Override
    void refuel(double addition) {
        this.fuelQuantity += addition;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",getClass().getSimpleName(),this.fuelQuantity);
    }
}
