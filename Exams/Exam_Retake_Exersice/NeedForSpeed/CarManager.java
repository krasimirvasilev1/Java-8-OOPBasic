package NeedForSpeed;

import NeedForSpeed.models.cars.Car;
import NeedForSpeed.models.cars.PerformanceCar;
import NeedForSpeed.models.cars.ShowCar;
import NeedForSpeed.models.races.CasualRace;
import NeedForSpeed.models.races.DragRace;
import NeedForSpeed.models.races.DriftRace;
import NeedForSpeed.models.races.Race;
import NeedForSpeed.repository.Repository;
import NeedForSpeed.repository.RepositoryImpl;

import java.util.Map;

public class CarManager {
    private Repository repository;

    public CarManager() {
        this.repository = new RepositoryImpl();
    }

    public Repository getRepository() {
        return this.repository;
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car;
        switch (type) {
            case "Performance":
                car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case "Show":
                car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            default:
                car = null;
                break;
        }

        if (car != null) {
            this.getRepository().getCars().put(id, car);
        }
    }

    public String check(int id) {
        if (this.getRepository().getCars().containsKey(id)) {
            return this.getRepository().getCars().get(id).toString();
        }

        return null;
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = null;
        switch (type) {
            case "Casual":
                race = new CasualRace(length, route, prizePool);
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool);
                break;
            case "Drift":
                race = new DriftRace(length, route, prizePool);
                break;
            default:
                race = null;
                break;
        }

        if (race != null) {
            this.getRepository().getRaces().put(id, race);
        }
    }

    public void participate(int carId, int raceId) {
        if (this.getRepository().getCars().containsKey(carId)) {
            if (this.getRepository().getRaces().containsKey(raceId)) {
                if (!this.getRepository().getParkedCars().containsKey(carId)) {
                    Car car = this.getRepository().getCars().get(carId);

                    this.getRepository().getRaces().get(raceId).addCarAsAParticipant(carId, car);
                }
            }
        }
    }

    public String start(int id) {
        if (this.getRepository().getRaces().containsKey(id)) {
            String resultOfRace = this.getRepository().getRaces().get(id).determineRaceWinners();

            this.getRepository().getRaces().remove(id);

            return resultOfRace;
        }

        return null;
    }

    public void park(int id) {
        if (this.getRepository().getCars().containsKey(id)) {
            if (!isTheCarParticipatingInARace(id)) {
                Car car = this.getRepository().getCars().get(id);
                this.getRepository().getParkedCars().put(id, car);
            }
        }
    }

    public void unpark(int id) {
        if (this.getRepository().getCars().containsKey(id)) {
            if (this.getRepository().getParkedCars().containsKey(id)) {
                Car car = this.getRepository().getParkedCars().get(id);
                this.getRepository().getCars().put(id , car);
                this.getRepository().getParkedCars().remove(id);
            }
        }
    }

    public void tune(int tuneIndex, String addOn) {
        if (this.getRepository().getParkedCars().size() != 0){
           this.getRepository().getGarage().tuneAllCarsInTheGarage(tuneIndex , addOn);
        }
    }

    private boolean isTheCarParticipatingInARace(int carId) {
        for (Map.Entry<Integer, Race> integerRaceEntry : this.getRepository().getRaces().entrySet()) {
            for (Map.Entry<Integer, Car> integerCarEntry : integerRaceEntry.getValue().getCars().entrySet()) {
                if (integerCarEntry.getKey() == carId) {
                    return true;
                }
            }
        }
        return false;
    }
}
