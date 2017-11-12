package FirstExersiceDefiningClasses.Google;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Person> people = new LinkedHashMap<>();
        while (true) {
            String input = console.readLine();
            if (input.equals("End")) {
                break;
            }
            String[] info = input.split(" ");
            Person person = new Person(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
            String personName = info[0];
            String typeOfInfo = info[1];
            person.setName(personName);
            List<Pokemon> pokemons = new ArrayList<>();
            List<Parents> parents = new ArrayList<>();
            List<Children> children = new ArrayList<>();
            Car car = new Car();
            Company company = new Company();
            if (people.containsKey(personName)) {

                switch (typeOfInfo) {
                    case "company":
                        Company newCompany = new Company(info[2],info[3], Double.parseDouble(info[4]));
                        people.get(personName).setCompany(newCompany);
                        break;
                    case "pokemon":
                        Pokemon pokemon = new Pokemon(info[2], info[3]);
                        people.get(personName).getPokemons().add(pokemon);
                        break;
                    case "parents":
                        Parents parent = new Parents(info[2], info[3]);
                        people.get(personName).getParents().add(parent);
                        break;
                    case "children":
                        Children child = new Children(info[2], info[3]);
                        people.get(personName).getChildrenList().add(child);
                        break;
                    case "car":
                        Car newCar = new Car(info[2], Integer.parseInt(info[3]));
                        people.get(personName).setCar(newCar);
                        break;
                }
            } else {
                switch (typeOfInfo) {
                    case "company":
                        Company newCompany = new Company(info[2],info[3], Double.parseDouble(info[4]));
                        person.setCompany(newCompany);
                        break;
                    case "pokemon":
                        Pokemon pokemon = new Pokemon(info[2], info[3]);
                        pokemons.add(pokemon);
                        person.setPokemons(pokemons);
                        break;
                    case "parents":
                        Parents parent = new Parents(info[2], info[3]);
                        parents.add(parent);
                        person.setParents(parents);
                        break;
                    case "children":
                        Children child = new Children(info[2], info[3]);
                        children.add(child);
                        person.setChildrenList(children);
                        break;
                    case "car":
                        Car newCar = new Car(info[2], Integer.parseInt(info[3]));
                        person.setCar(newCar);
                        break;
                }
                people.put(personName, person);
            }
        }

        String nameThatWeAreLoookingFor = console.readLine();

        Person outputPerson = people.get(nameThatWeAreLoookingFor);
        System.out.print(outputPerson);
        System.out.println("Pokemon:");
        for (Pokemon pokemon : outputPerson.getPokemons()) {
            System.out.print(pokemon);
        }
        System.out.println("Parents:");
        for (Parents parents : outputPerson.getParents()) {
            System.out.print(parents);
        }
        System.out.println("Children:");
        for (Children children : outputPerson.getChildrenList()) {
            System.out.print(children);
        }
    }
}
