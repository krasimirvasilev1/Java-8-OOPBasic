package FirstExersiceDefiningClasses.CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int numberOfEngines = Integer.parseInt(console.readLine());
        HashMap<String,Engine> engines = new HashMap<>();
        LinkedList<Car> allCars = new LinkedList<>();
        for (int i = 0; i < numberOfEngines; i++) {
            String[] input = console.readLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            Engine engine = new Engine(model,power);
            switch (input.length) {
                case 3:
                    if (Character.isDigit(input[2].charAt(0))){
                        engine.setDisplacement(input[2]);
                    }
                    else{
                        engine.setEfficiency(input[2]);
                    }
                    break;
                case 4:
                    engine.setDisplacement(input[2]);
                    engine.setEfficiency(input[3]);
                    break;
            }
            engines.put(model,engine);
        }
        int numberOfCars = Integer.parseInt(console.readLine());
        for (int i = 0; i < numberOfCars; i++) {
            String [] input = console.readLine().split("\\s+");
            String model = input[0];
            String engine = input[1];
            Car newCar = new Car(model,engine);
            switch (input.length){
                case 3:
                    if (Character.isDigit(input[2].charAt(0))){
                        newCar.setWeight(input[2]);
                    }
                    else{
                        newCar.setColour(input[2]);
                    }
                    break;
                case 4:
                    newCar.setWeight(input[2]);
                    newCar.setColour(input[3]);
                    break;
            }
            allCars.add(newCar);
        }

        for (Car allCar : allCars) {
            System.out.print(allCar);
            Engine carsEngine = engines.get(allCar.getEngine());
            System.out.print(carsEngine);
            System.out.println("  Weight: "+allCar.getWeight());
            System.out.println("  Color: "+allCar.getColour());
        }
    }
}
