package FirstExersiceDefiningClasses.CatLady;

public class StreetExtraOrdinary {
    String name;
    double decibelsOfMeows;

    public StreetExtraOrdinary(String name, double decibelsOfMeows) {
        this.name = name;
        this.decibelsOfMeows = decibelsOfMeows;
    }
    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f",this.name,this.decibelsOfMeows);
    }
}
