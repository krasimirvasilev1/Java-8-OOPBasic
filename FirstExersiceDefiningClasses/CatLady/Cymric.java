package FirstExersiceDefiningClasses.CatLady;

public class Cymric {
    String name;
    double furLenght;

    public Cymric(String name, double furLenght) {
        this.name = name;
        this.furLenght = furLenght;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f",this.name,this.furLenght);
    }
}
