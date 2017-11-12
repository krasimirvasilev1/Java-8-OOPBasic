package FirstExersiceDefiningClasses.FamilyTree;

import java.util.LinkedList;

public class Person {
    String name;
    String date;
    LinkedList<Child> children = new LinkedList<>();
    LinkedList<Parent> parents = new LinkedList<>();

    public Person() {
    }

    public Person(String date) {
        this.date = date;
    }

    public Person(LinkedList<Child> children, LinkedList<Parent> parents) {
        this.children = children;
        this.parents = parents;
    }

    public Person(String name, String date, LinkedList<Child> children, LinkedList<Parent> parents) {
        this(children, parents);
        setDate(date);
        setName(name);
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

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s %s%n", getName(), getDate()));
        output.append(String.format("Parents:"));
        if (!this.parents.isEmpty()) {
            for (Parent parent : parents) {
                output.append(String.format("%s %s%n", parent.getName(), parent.getDate()));
            }
        }
        output.append(String.format("Children:"));
        if (!this.children.isEmpty()) {
            for (Child child : children) {
                output.append(String.format("%s %s%n", child.getName(), child.getDate()));
            }
        }
        return output.toString();
    }
}
