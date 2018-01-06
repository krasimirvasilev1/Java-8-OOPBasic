package NeedForSpeed.models.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    protected void setHorsePower(int horsePower) {
        super.setHorsePower(horsePower + (int)(horsePower * 0.50));
    }

    @Override
    protected void setSuspension(int suspension) {
        super.setSuspension(suspension - (int)(suspension * 0.25));
    }

    @Override
    public void additionTuneBySpecificTypeOfCar(int tuneIndex, String adds) {
        this.addOns.add(adds);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s %d%n",getBrand(),getModel(),getYearOfProduction()));
        builder.append(String.format("%d HP, 100 m/h in %d s%n",getHorsePower(),getAcceleration()));
        builder.append(String.format("%s Suspension force, %d Durability%n",getSuspension(),getDurability()));
        builder.append("Add-ons: ");
        if (this.addOns.isEmpty()){
            builder.append(String.format("None %n"));
        }
        else{
            builder.append(String.format("%s%n",String.join(", ",this.addOns)));
        }

        return builder.toString().trim();
    }
}
