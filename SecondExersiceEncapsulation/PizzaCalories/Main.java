package SecondExersiceEncapsulation.PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] pizzaCommand = console.readLine().split("\\s+");
            String[] doughCommand = console.readLine().split("\\s+");
            Pizza pizza = new Pizza();
            Dough dough = new Dough();
            if (pizzaCommand[0].equalsIgnoreCase("pizza")){
                pizza = new Pizza(pizzaCommand[1], Integer.parseInt(pizzaCommand[2]));
            }
            else{
                dough = new Dough(pizzaCommand[1], pizzaCommand[2], Double.parseDouble(pizzaCommand[3]));
            }
            if (doughCommand[0].equalsIgnoreCase("dough")){
                dough = new Dough(doughCommand[1], doughCommand[2], Double.parseDouble(doughCommand[3]));
            }
            else{
                pizza = new Pizza(doughCommand[1], Integer.parseInt(doughCommand[2]));
            }
            pizza.setCaloriesOfThePizza(dough.getCaloriesOfDough(dough));
            while(true){
                String toppingText = console.readLine();
                if ("end".equalsIgnoreCase(toppingText)){
                    break;
                }
                String[] toppingCommand = toppingText.split("\\s+");
                Toppings toppings = new Toppings(toppingCommand[1],Double.parseDouble(toppingCommand[2]));
                pizza.setCaloriesOfThePizza(toppings.getToppingCalories(toppings));
            }
            System.out.printf("%s - %.2f",pizza.getName(),pizza.getCaloriesOfThePizza());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
