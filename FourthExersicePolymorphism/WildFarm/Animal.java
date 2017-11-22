package FourthExersicePolymorphism.WildFarm;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    protected Animal(String animalType, String animalName, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected abstract String makeSound();
    protected abstract void eat(Food food,int foodQuantity);
}
