package ExamNeedForSpeedMine.needForSpeed.Cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;

    private int horsePower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        setBrand(brand);
        setModel(model);
        setYearOfProduction(yearOfProduction);
        setHorsePower(horsePower);
        setAcceleration(acceleration);
        setSuspension(suspension);
        setDurability(durability);
    }

    public void increaseHorsePower (int additionalHorsePower){
        this.horsePower = this.horsePower + additionalHorsePower;
    }
    public void increaseSuspensionPower  (int additonalSuspension){
        this.suspension = this.suspension + additonalSuspension;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public int getDurability() {
        return durability;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
