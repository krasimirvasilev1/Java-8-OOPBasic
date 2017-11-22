package FourthExersicePolymorphism.WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (true) {
            if ("End".equalsIgnoreCase(line = console.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");
            Animal animal = createAnimal(tokens);
            System.out.println(animal.makeSound());
            System.out.println(animal);
        }
    }

    private static Animal createAnimal(String[] tokens) {
        switch (tokens[0]) {
            case "Cat":
                return new Cat(tokens[1], tokens[0], Double.parseDouble(tokens[3]), tokens[4], tokens[5]);
            case "Tiger":
                return new Tiger(tokens[1],tokens[0],Double.parseDouble(tokens[2]),tokens[3]);
            case "Zebra":
                return new Zebra(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]);
            case "Mouse":
                return new Mouse(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]);
                default:
                    return null;
        }
    }
}
