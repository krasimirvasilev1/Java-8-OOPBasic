package FourthExersicePolymorphism.WildFarm;

public class Zebra extends Mammal {
    public Zebra(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }


    @Override
    public String makeSound() {
        return "Zs";
    }

    @Override
    public void eat(Food food, int foodQuantity) {
        if(!food.getClass().getSimpleName().equalsIgnoreCase("Vegetable")) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        this.setFoodEaten(foodQuantity);
    }
}
