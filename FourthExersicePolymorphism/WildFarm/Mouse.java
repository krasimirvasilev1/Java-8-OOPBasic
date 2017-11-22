package FourthExersicePolymorphism.WildFarm;

public class Mouse extends Mammal {
    public Mouse(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    public void eat(Food food, int foodQuantity) {
        if (!food.getClass().getSimpleName().equalsIgnoreCase("Vegetable")) {
        throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        this.setFoodEaten(foodQuantity);
    }
}
