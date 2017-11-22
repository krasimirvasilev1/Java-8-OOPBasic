package FourthExersicePolymorphism.VechiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] inputCar = console.readLine().split("\\s+");
        String[] inputTruck = console.readLine().split("\\s+");
        String[] inputBus = console.readLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(inputCar[1]), Double.parseDouble(inputCar[2]), Double.parseDouble(inputCar[3]));
        Vehicle truck = new Truck(Double.parseDouble(inputTruck[1]), Double.parseDouble(inputTruck[2]), Double.parseDouble(inputCar[3]));
        Vehicle bus = new Bus(Double.parseDouble(inputBus[1]), Double.parseDouble(inputBus[2]), Double.parseDouble(inputBus[3]));
        int numberOfiterations = Integer.parseInt(console.readLine());
        for (int i = 0; i < numberOfiterations; i++) {
            String[] input = console.readLine().split("\\s+");
            try {
                if (input[0].equalsIgnoreCase("Drive")) {
                    if (input[1].equalsIgnoreCase("Car")) {
                        car.distanceTraveled(Double.parseDouble(input[2]), false);
                    } else if (input[1].equalsIgnoreCase("Truck")) {
                        truck.distanceTraveled(Double.parseDouble(input[2]), false);
                    } else if (input[1].equalsIgnoreCase("Bus")) {
                        bus.distanceTraveled(Double.parseDouble(input[2]), false);
                    }
                } else if (input[0].equalsIgnoreCase("DriveEmpty")) {
                    bus.distanceTraveled(Double.parseDouble(input[2]), true);
                } else if (input[0].equalsIgnoreCase("Refuel")) {
                    if (input[1].equalsIgnoreCase("Car")) {
                        car.refuel(Double.parseDouble(input[2]));
                    } else if (input[1].equalsIgnoreCase("Truck")) {
                        truck.refuel(Double.parseDouble(input[2]));
                    } else if (input[1].equalsIgnoreCase("Bus")) {
                        bus.refuel(Double.parseDouble(input[2]));
                    }
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);

    }
}
