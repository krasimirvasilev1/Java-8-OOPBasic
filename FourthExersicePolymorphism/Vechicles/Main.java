package FourthExersicePolymorphism.Vechicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] inputCar = console.readLine().split("\\s+");
        String[] inputTruck = console.readLine().split("\\s+");

        Vechicle car = new Car(Double.parseDouble(inputCar[1]),Double.parseDouble(inputCar[2]));
        Vechicle truck = new Truck(Double.parseDouble(inputTruck[1]),Double.parseDouble(inputTruck[2]));
        int numberOfiterations = Integer.parseInt(console.readLine());
        for (int i = 0; i < numberOfiterations; i++) {
            String[] input = console.readLine().split("\\s+");
            if (input[0].equalsIgnoreCase("Drive") && input[1].equalsIgnoreCase("Car")){
                car.distanceTraveled(Double.parseDouble(input[2]));
            }
            else if (input[0].equalsIgnoreCase("Drive") && input[1].equalsIgnoreCase("Truck")){
                truck.distanceTraveled(Double.parseDouble(input[2]));
            }
            else if (input[0].equalsIgnoreCase("Refuel") && input[1].equalsIgnoreCase("Car")){
                car.refuel(Double.parseDouble(input[2]));
            }
            else if (input[0].equalsIgnoreCase("Refuel") && input[1].equalsIgnoreCase("Truck")){
                truck.refuel(Double.parseDouble(input[2]));
            }
        }

        System.out.println(car);
        System.out.println(truck);

    }
}
