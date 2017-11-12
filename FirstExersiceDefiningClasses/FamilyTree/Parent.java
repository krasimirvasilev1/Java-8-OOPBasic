package FirstExersiceDefiningClasses.FamilyTree;

public class Parent {
    String name;
    String date;

    public Parent(String date) {
        this.date = date;
    }

    public Parent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
