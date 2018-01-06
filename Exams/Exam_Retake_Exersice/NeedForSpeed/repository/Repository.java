package NeedForSpeed.repository;

import NeedForSpeed.models.cars.Car;
import NeedForSpeed.models.garage.Garage;
import NeedForSpeed.models.races.Race;

import java.util.List;
import java.util.Map;

public interface Repository {
    Map<Integer,Car> getParkedCars();

    Map<Integer,Car> getCars();

    Map<Integer,Race> getRaces();

    Garage getGarage ();
}
