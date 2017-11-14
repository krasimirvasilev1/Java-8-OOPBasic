package SecondExersiceEncapsulation.PizzaCalories;

public class Pizza {
    String name;
    Dough dough;
    Toppings toppings;
    int numberOfToppings;
    double caloriesOfThePizza;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setNumberOfToppings(numberOfToppings);
    }

    public Pizza() {
    }

    public void setName(String name) {
        if (name.length() > 0 && name.length() <= 15){
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public String getName() {
        return name;
    }

    public void setNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings >= 0 && numberOfToppings <= 10){
            this.numberOfToppings = numberOfToppings;
        }
        else{
            throw  new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public void setCaloriesOfThePizza(double additionalCalories) {
        this.caloriesOfThePizza += additionalCalories;
    }

    public double getCaloriesOfThePizza() {
        return caloriesOfThePizza;
    }
}
