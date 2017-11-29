package ExamNeedForSpeedMine.needForSpeed;

import needForSpeed.Box.Garage;
import needForSpeed.Cars.Car;
import needForSpeed.Cars.PerformanceCar;
import needForSpeed.Cars.ShowCar;
import needForSpeed.Races.CasualRace;
import needForSpeed.Races.DragRace;
import needForSpeed.Races.DriftRace;
import needForSpeed.Races.Race;

import java.util.*;
import java.util.stream.Collectors;

public class CarManager {

    private Map<Integer, Car> allcars;
    private Map<Integer, Race> allraces;
    private Garage garage;

    public CarManager() {
        this.allcars = new LinkedHashMap<>();
        this.garage = new Garage();
        this.allraces = new HashMap<>();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        if (type.equalsIgnoreCase("Performance")) {
            PerformanceCar performanceCar = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            this.allcars.put(id, performanceCar);
        } else {
            ShowCar showCar = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            this.allcars.put(id, showCar);
        }
    }

    public String check(int id) {
            if (this.allcars.containsKey(id)) {
                Car car = this.allcars.get(id);
                return car.toString();
            }
            else{
                return "";
            }
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        if (type.equalsIgnoreCase("Casual")) {
            CasualRace casualRace = new CasualRace(length, route, prizePool);
            this.allraces.put(id, casualRace);
        } else if (type.equalsIgnoreCase("Drag")) {
            DragRace dragRace = new DragRace(length, route, prizePool);
            this.allraces.put(id, dragRace);

        } else {
            DriftRace driftRace = new DriftRace(length, route, prizePool);
            this.allraces.put(id, driftRace);
        }
    }

    public void participate(int carId, int raceId) {
        if (this.allcars.containsKey(carId)) {
            Car carFromGivenId = this.allcars.get(carId);
            if (this.garage.isTheCarPresent(carId, carFromGivenId)) {
                return;
            }
            addACarToARace(carFromGivenId, raceId);
        } else {
            return;
        }
    }

    public String start(int id) {
        StringBuilder builder = new StringBuilder();
        if (this.allraces.containsKey(id)) {
            Race startARace = this.allraces.get(id);
            if (startARace.getParticipants().size() == 0) {
                throw new IllegalArgumentException("Cannot start the race with zero participants.");
            }
            builder.append(String.format(startARace.getRoute() + " - " + startARace.getLenght() + "%n"));

            List<Car> winners = new LinkedList<>();
            if (startARace instanceof CasualRace) {
                List<Car> winnersCasual = startARace.getParticipants().stream().sorted((x, y) -> Integer.compare((y.getHorsePower() / y.getAcceleration()) + (y.getSuspension() + y.getDurability()), (x.getHorsePower() / x.getAcceleration()) + (x.getSuspension() + x.getDurability()))).
                        limit(3).collect(Collectors.toList());
                winners = winnersCasual;

                int counter = 1;
                int prizeMoney = 0;
                for (Car winner : winners) {
                    if (counter == 1) {
                        prizeMoney = (int) (startARace.getPrizePool() * 0.50);
                    } else if (counter == 2) {
                        prizeMoney = (int) (startARace.getPrizePool() * 0.30);
                    } else if (counter == 3) {
                        prizeMoney = (int) (startARace.getPrizePool() * 0.20);
                    }
                    builder.append(String.format(counter + ". " + winner.getBrand() + " " + winner.getModel() + " " + ((winner.getHorsePower() / winner.getAcceleration()) + (winner.getSuspension() + winner.getDurability())) + "PP - $" + prizeMoney + "%n"));
                    counter++;
                }
            } else if (startARace instanceof DragRace) {
                List<Car> winnersDrag = startARace.getParticipants().stream().sorted((x, y) -> Integer.compare(y.getHorsePower() / y.getAcceleration(), x.getHorsePower() / x.getAcceleration())).
                        limit(3).collect(Collectors.toList());
                winners = winnersDrag;

                int counter = 1;
                int prizeMoney = 0;
                for (Car winner : winners) {
                    if (counter == 1) {
                        prizeMoney = (int) (startARace.getPrizePool() * 0.50);
                    } else if (counter == 2) {
                        prizeMoney = (int) (startARace.getPrizePool() * 0.30);
                    } else if (counter == 3) {
                        prizeMoney = (int) (startARace.getPrizePool() * 0.20);
                    }
                    builder.append(String.format(counter + ". " + winner.getBrand() + " " + winner.getModel() + " " + winner.getHorsePower() / winner.getAcceleration() + "PP - $" + prizeMoney + "%n"));
                    counter++;
                }
            } else if (startARace instanceof DriftRace) {
                List<Car> winnersDrift = startARace.getParticipants().stream().sorted((x, y) -> Integer.compare(y.getSuspension() + y.getDurability(), x.getSuspension() + x.getDurability())).
                        limit(3).collect(Collectors.toList());
                winners = winnersDrift;

                int counter = 1;
                int prizeMoney = 0;
                for (Car winner : winners) {
                    if (counter == 1) {
                        prizeMoney = (int) (startARace.getPrizePool() * 0.50);
                    } else if (counter == 2) {
                        prizeMoney = (int) (startARace.getPrizePool() * 0.30);
                    } else if (counter == 3) {
                        prizeMoney = (int) (startARace.getPrizePool() * 0.20);
                    }
                    builder.append(String.format(counter + ". " + winner.getBrand() + " " + winner.getModel() + " " + winner.getSuspension() + winner.getDurability() + "PP - $" + prizeMoney + "%n"));
                    counter++;
                }
            }
            this.allraces.remove(id);
        } else {
            return "";
        }
        return builder.toString();
    }

    public void park(int id) {
        if (this.allcars.containsKey(id)) {
            Car carToBeParked = this.allcars.get(id);
            for (Integer integer : this.allraces.keySet()) {
                Race newRace = this.allraces.get(integer);
                if (newRace.getParticipants().contains(carToBeParked)) {
                    return;
                }
            }
            this.garage.addACarInTheGarage(id, carToBeParked);
        } else {
            return;
        }
    }

    public void unpark(int id) {
        if (this.garage.tuneAllCars().containsKey(id)) {
            this.allcars.put(id, this.garage.takeACarFromGarage(id));

            this.garage.removeACarFromPark(id);
        }
    }

    public void tune(int tuneIndex, String tuneAddOn) {
        if (this.garage.tuneAllCars().isEmpty()) {
            return;
        }
        for (Integer integer : this.garage.tuneAllCars().keySet()) {
            Car modifyCar = this.garage.takeACarFromGarage(integer);
            modifyCar.increaseHorsePower(tuneIndex);
            modifyCar.increaseSuspensionPower((int) (tuneIndex * 0.50));
            if (modifyCar instanceof ShowCar) {
                ((ShowCar) modifyCar).setStars(tuneIndex);
            } else if (modifyCar instanceof PerformanceCar) {
                ((PerformanceCar) modifyCar).setAddOns(tuneAddOn);
            }
            this.garage.addACarInTheGarage(integer, modifyCar);
        }
    }

    private void addACarToARace(Car car, int raceId) {
        if (this.allraces.containsKey(raceId)) {
            this.allraces.get(raceId).addParticipant(car);
        }
    }
}
