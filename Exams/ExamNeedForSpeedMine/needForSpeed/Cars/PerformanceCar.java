package ExamNeedForSpeedMine.needForSpeed.Cars;

import needForSpeed.Cars.Car;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns = new ArrayList<>();

        public PerformanceCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
    }

    @Override
    public void setHorsePower(int horsePower) {
        super.setHorsePower(horsePower + (int)(horsePower * 0.50));
    }

    @Override
    public void setSuspension(int suspension) {
        super.setSuspension(suspension - (int)(suspension * 0.25));
    }

    public void setAddOns(String addOns) {
        this.addOns.add(addOns);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s %d%n%d HP, 100 m/h in %d s%n%d Suspension force, %d Durability%nAdd-ons: ",getBrand(),getModel(),getYearOfProduction(),getHorsePower(),getAcceleration(),getSuspension(),getDurability()));
        if (this.addOns.isEmpty()){
            builder.append("None");
        }
        else{
            builder.append(String.join(", ",this.addOns));
        }
        builder.append(String.format("%n"));
        return builder.toString();
    }
}
