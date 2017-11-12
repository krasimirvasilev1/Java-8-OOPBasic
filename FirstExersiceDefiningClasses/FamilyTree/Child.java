package FirstExersiceDefiningClasses.FamilyTree;

import java.util.LinkedList;

public class Child {
    String name;
    String date;


    public Child(String date) {
        this.date = date;
    }

    public Child() {
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
