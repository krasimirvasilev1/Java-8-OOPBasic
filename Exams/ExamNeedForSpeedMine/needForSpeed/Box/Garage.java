package ExamNeedForSpeedMine.needForSpeed.Box;

import needForSpeed.Cars.Car;

import java.util.HashMap;
import java.util.Map;

public class Garage {
    private Map<Integer, Car> parkedCars;

    public Garage() {
        this.parkedCars = new HashMap<>();
    }

    public void addACarInTheGarage(int id, Car car) {
        this.parkedCars.put(id, car);
    }

    public Car takeACarFromGarage(int id) {
        return this.parkedCars.get(id);
    }

    public void removeACarFromPark(int id) {
        this.parkedCars.remove(id);
    }

    public boolean isTheCarPresent(int id, Car car) {
        if (this.parkedCars.containsKey(id)) {
            if (this.parkedCars.get(id).equals(car)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public Map<Integer, Car> tuneAllCars() {
        return this.parkedCars;
    }
}
