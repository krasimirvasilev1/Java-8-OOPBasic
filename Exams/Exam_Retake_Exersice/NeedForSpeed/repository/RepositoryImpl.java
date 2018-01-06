package NeedForSpeed.repository;

import NeedForSpeed.models.cars.Car;
import NeedForSpeed.models.garage.Garage;
import NeedForSpeed.models.races.Race;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RepositoryImpl implements Repository {
    private Map<Integer,Car> cars;
    private Map<Integer,Race> races;
    private Garage garage;

    public RepositoryImpl() {
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    @Override
    public Garage getGarage (){
        return this.garage;
    }

    @Override
    public Map<Integer,Car> getParkedCars() {
        return this.garage.getParkedCars();
    }

    @Override
    public Map<Integer, Car> getCars() {
        return this.cars;
    }

    @Override
    public Map<Integer, Race> getRaces() {
        return this.races;
    }
}
