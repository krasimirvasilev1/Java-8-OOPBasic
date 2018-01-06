package NeedForSpeed.models.races;

import NeedForSpeed.models.cars.Car;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private Map<Integer,Car> cars;

    protected Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.cars = new LinkedHashMap<>();
    }

    protected int getLength(){
        return this.length;
    }

    protected int getPrizePool(){
        return this.prizePool;
    }

    protected String getRoute(){
        return this.route;
    }

    public Map<Integer, Car> getCars() {
        return this.cars;
    }

    public void addCarAsAParticipant(int carId , Car car){
        this.cars.put(carId,car);
    }

    public abstract String determineRaceWinners ();
}
