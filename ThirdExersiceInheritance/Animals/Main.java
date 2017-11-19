package ThirdExersiceInheritance.Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                String typeOfAnimal = console.readLine();
                if (typeOfAnimal.equals("Beast!")) {
                    break;
                }
                String[] charactersitics = console.readLine().split("\\s+");
                if (typeOfAnimal.equalsIgnoreCase("cat")) {
                    Cat cat = new Cat(charactersitics[0], Integer.parseInt(charactersitics[1]), charactersitics[2]);
                    System.out.println(cat);
                } else if (typeOfAnimal.equalsIgnoreCase("animal")) {
                    Animal animal = new Animal(charactersitics[0], Integer.parseInt(charactersitics[1]), charactersitics[2]);
                    System.out.println(animal);
                } else if (typeOfAnimal.equalsIgnoreCase("dog")) {
                    Dog dog = new Dog(charactersitics[0], Integer.parseInt(charactersitics[1]), charactersitics[2]);
                    System.out.println(dog);
                } else if (typeOfAnimal.equalsIgnoreCase("frog")) {
                    Frog frog = new Frog(charactersitics[0], Integer.parseInt(charactersitics[1]), charactersitics[2]);
                    System.out.println(frog);
                } else if (typeOfAnimal.equalsIgnoreCase("kitten")) {
                    Kitten kitten = new Kitten(charactersitics[0], Integer.parseInt(charactersitics[1]), charactersitics[2]);
                    System.out.println(kitten);
                } else if (typeOfAnimal.equalsIgnoreCase("tomcat")) {
                    Tomcat tomcat = new Tomcat(charactersitics[0], Integer.parseInt(charactersitics[1]), charactersitics[2]);
                    System.out.println(tomcat);
                }
                else{
                    throw new IllegalArgumentException("Invalid input!");
                }
            }
            catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }
    }
}
