package ExamNeedForSpeedMine.needForSpeed.Cars;

import needForSpeed.Cars.Car;

public class ShowCar extends Car {
    private int stars = 0;

    public ShowCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
    }

    public void setStars(int stars) {
        this.stars += stars;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s %d%n%d HP, 100 m/h in %d s%n%d Suspension force, %d Durability%n%d *%n",getBrand(),getModel(),getYearOfProduction(),getHorsePower(),getAcceleration(),getSuspension(),getDurability(),this.stars));

        return builder.toString();
    }
}
