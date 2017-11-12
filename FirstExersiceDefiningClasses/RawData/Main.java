package FirstExersiceDefiningClasses.RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        LinkedList<Car> allCars = new LinkedList<>();

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(console.readLine());
        for (int i = 0; i < number; i++) {
            String[] input = console.readLine().split(" ");
            Cargo cargo = new Cargo(Integer.parseInt(input[3]), input[4]);
            Engine engine = new Engine(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            Tires tires = new Tires(Integer.parseInt(input[6]), Integer.parseInt(input[8]), Integer.parseInt(input[10]), Integer.parseInt(input[12]),
                    Double.parseDouble(input[5]), Double.parseDouble(input[7]), Double.parseDouble(input[9]), Double.parseDouble(input[11]));
            Car car = new Car(input[0], engine, tires, cargo);
            allCars.add(car);
        }
        String command = console.readLine();
        if (command.equals("fragile")) {
            allCars.stream().filter(x -> x.getCargo().cargoType.equals("fragile")).filter(x -> x.getTires().tireOnePressure < 1
                    || x.getTires().tireTwoPressure < 1 || x.getTires().tireThreePressure < 1 || x.getTires().tireFourPressure < 1)
                    .forEach(x -> System.out.println(x));
        }
        else if(command.equals("flamable")){
            allCars.stream().filter(x -> x.getCargo().cargoType.equals("flamable")).filter(x -> x.getEngine().enginePower > 250)
                    .forEach(x -> System.out.println(x));
        }

    }
}
