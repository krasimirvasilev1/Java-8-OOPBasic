package FourthExersicePolymorphism.WildFarm;

public class Tiger  extends Felime{
    public Tiger(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eat(Food food, int foodQuantity) {
        if (!food.getClass().getSimpleName().equalsIgnoreCase("Meat")){
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        this.setFoodEaten(foodQuantity);
    }
}
