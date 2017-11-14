package SecondExersiceEncapsulation.ShoppingSpree;

import java.util.LinkedList;
import java.util.List;

public class Person {
    String name;
    double money;
    List<Product> productList = new LinkedList<>();

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
    }

    public List<Product> getProductList() {
        return productList;
    }

    private void setProductList(Product product) {
        this.productList.add(product);
    }

    public double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.money = money;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");

        }
        else{
            this.name = name;
        }
    }

    void boughtItOrNot(Product product) {
        if (getMoney() >= product.getCost()) {
            setMoney(getMoney() - product.getCost());
            System.out.println(this.name + " bought " + product.getName());
            setProductList(product);
        } else {
            System.out.println(this.name + " can't afford " + product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (getProductList().size() == 0) {
            builder.append(String.format("%s - Nothing bought", getName()));
        } else {
            builder.append(String.format("%s - ", getName()));
            for (int i = 0; i < getProductList().size(); i++) {
                if (i == getProductList().size() - 1){
                    builder.append(String.format("%s",getProductList().get(i).getName()));
                }
                else{
                    builder.append(String.format("%s, ",getProductList().get(i).getName()));
                }
            }
        }
        return builder.toString();
    }
}
