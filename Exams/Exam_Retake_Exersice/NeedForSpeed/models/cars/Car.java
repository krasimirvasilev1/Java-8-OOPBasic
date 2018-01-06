package NeedForSpeed.models.cars;

import java.util.List;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        setHorsePower(horsePower);
        this.acceleration = acceleration;
        setSuspension(suspension);
        this.durability = durability;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getYearOfProduction() {
        return this.yearOfProduction;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public int getSuspension() {
        return this.suspension;
    }

    public int getDurability() {
        return this.durability;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public void increaseHorsePowerByTune(int tuneIndex){
        this.horsePower = this.getHorsePower() + tuneIndex;
    }

    public void increaseSuspensionByTune(int tuneIndex){
        this.suspension = this.getSuspension() + (int)(tuneIndex * 0.50);
    }

    public abstract void additionTuneBySpecificTypeOfCar(int tuneIndex,String addOns);

    @Override
    public String toString() {
        return super.toString();
    }
}
