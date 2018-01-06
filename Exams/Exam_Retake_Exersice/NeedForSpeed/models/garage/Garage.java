package NeedForSpeed.models.garage;

import NeedForSpeed.models.cars.Car;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Garage {
    private Map<Integer,Car> parkedCars;

    public Garage() {
        this.parkedCars = new LinkedHashMap<>();
    }

    public Map<Integer,Car> getParkedCars() {
        return this.parkedCars;
    }

    public void tuneAllCarsInTheGarage(int index , String addOns){
        for (Car car : parkedCars.values()) {
            car.increaseHorsePowerByTune(index);
            car.increaseSuspensionByTune(index);
            car.additionTuneBySpecificTypeOfCar(index,addOns);
        }
    }
}
