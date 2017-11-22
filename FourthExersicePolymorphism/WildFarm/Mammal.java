package FourthExersicePolymorphism.WildFarm;

public abstract class  Mammal extends Animal {
    protected String livingRegion;

    protected Mammal(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

}
