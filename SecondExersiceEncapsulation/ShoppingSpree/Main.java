package SecondExersiceEncapsulation.ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> allPeople = new LinkedHashMap<>();
        Map<String, Product> allProducts = new LinkedHashMap<>();
        String[] inputPeople = console.readLine().split(";");
        String[] inputProducts = console.readLine().split(";");

        for (int i = 0; i < inputPeople.length; i++) {
            String[] nameAndMoney = inputPeople[i].split("=");
            try{
                Person person = new Person(nameAndMoney[0], Double.parseDouble(nameAndMoney[1]));
                allPeople.put(nameAndMoney[0], person);
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

        for (int i = 0; i < inputProducts.length; i++) {
            String[] nameAndPrice = inputProducts[i].split("=");
            Product product = new Product(nameAndPrice[0], Double.parseDouble(nameAndPrice[1]));
            allProducts.put(nameAndPrice[0], product);
        }

        while (true) {
            String comand = console.readLine();
            if (comand.equalsIgnoreCase("end")) {
                break;
            }
            String[] info = comand.split("\\s+");

            if (allPeople.containsKey(info[0])){
                allPeople.get(info[0]).boughtItOrNot(allProducts.get(info[1]));
            }
        }
        for (Person person : allPeople.values()) {
            {
                System.out.println(person);
            }
        }
    }
}
