package NeedForSpeed.models.cars;

import java.util.List;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
        this.stars = 0;
    }

    @Override
    public void additionTuneBySpecificTypeOfCar(int tuneIndex, String addOns) {
        this.stars += tuneIndex;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s %d%n", getBrand(), getModel(), getYearOfProduction()));
        builder.append(String.format("%d HP, 100 m/h in %d s%n", getHorsePower(), getAcceleration()));
        builder.append(String.format("%s Suspension force, %d Durability%n", getSuspension(), getDurability()));
        builder.append(String.format("%d *%n", this.stars));

        return builder.toString().trim();
    }
}
