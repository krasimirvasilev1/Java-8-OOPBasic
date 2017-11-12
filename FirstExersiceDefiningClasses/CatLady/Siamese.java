package FirstExersiceDefiningClasses.CatLady;

public class Siamese {
    String name;
    double earSize;

    public Siamese(String name, double earSize) {
        this.name = name;
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f",this.name,this.earSize);
    }
}
