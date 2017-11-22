package FourthExersicePolymorphism.WildFarm;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName, double animalWeight, String livingRegion,String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public void eat(Food food,int foodQuantity) {
        setFoodEaten(foodQuantity);
    }
}
