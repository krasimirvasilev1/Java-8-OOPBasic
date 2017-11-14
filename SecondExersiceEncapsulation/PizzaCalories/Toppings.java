package SecondExersiceEncapsulation.PizzaCalories;

public class Toppings {
    String typeOfTopping;
    double toppingWeight;
    double modificatorOfCalories;

    public Toppings(String typeOfTopping, double toppingWeight) {
        setTypeOfTopping(typeOfTopping);
        setToppingWeight(toppingWeight);
    }

    public void setTypeOfTopping(String typeOfTopping) {
        switch (typeOfTopping.toLowerCase()) {
            case "meat":
                this.modificatorOfCalories = 1.2;
                this.typeOfTopping = typeOfTopping;
                break;
            case "veggies":
                this.modificatorOfCalories = 0.8;
                this.typeOfTopping = typeOfTopping;
                break;
            case "cheese":
                this.modificatorOfCalories = 1.1;
                this.typeOfTopping = typeOfTopping;
                break;
            case "sauce":
                this.modificatorOfCalories = 0.9;
                this.typeOfTopping = typeOfTopping;
                break;
            default:
                throw new IllegalArgumentException("Cannot place " + typeOfTopping + " on top of your pizza.");
        }
    }

    public void setToppingWeight(double toppingWeight) {
        if (toppingWeight >= 1 && toppingWeight <= 50){
            this.toppingWeight = toppingWeight;
        }
        else{
            throw new IllegalArgumentException(this.typeOfTopping +" weight should be in the range [1..50].");
        }
    }

    public double getToppingWeight() {
        return toppingWeight;
    }

    public double getModificatorOfCalories() {
        return modificatorOfCalories;
    }

    public double getToppingCalories (Toppings toppings){
        return (2 * toppings.getToppingWeight()) * toppings.getModificatorOfCalories();
    }
}
