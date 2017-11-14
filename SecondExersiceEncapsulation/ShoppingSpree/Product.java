package SecondExersiceEncapsulation.ShoppingSpree;

public class Product {
    String name;
    double cost;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }


    }
