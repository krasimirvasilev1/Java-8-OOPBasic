package FirstExersiceDefiningClasses.FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

       // HashMap<String,ListParent> parents = new LinkedHashMap<>();
        LinkedList<Parent> parentsList = new LinkedList<>();
        LinkedList<Child> childList = new LinkedList<>();

        String text = console.readLine();
        Person person = new Person();
        if (text.contains("/")) {
            person = new Person(text);
        } else {
            person = new Person(new LinkedList<>(), new LinkedList<>());
            person.setName(text);
        }

        while (true) {
            String input = console.readLine();
            if ("end".equalsIgnoreCase(input)) {
                break;
            }
            if (input.contains(" - ")) {
                String[] parentChildren = input.split(" - ");
                String parentString = parentChildren[0];
                String childrenString = parentChildren[1];
                Parent parent = new Parent();
                if (parentChildren[0].contains("/")) {
                    parent = new Parent(parentString);
                } else {
                    parent = new Parent();
                    parent.setName(parentString);
                }
                parentsList.add(parent);
                Child child = new Child();
                if (parentChildren[1].contains("/")) {
                    child = new Child(childrenString);
                } else {
                    child = new Child();
                    child.setName(childrenString);
                }
                childList.add(child);
            } else {
                String[] nameAndBornYear = input.split("\\s+");
                String name = nameAndBornYear[0] + " " + nameAndBornYear[1];
                String bornDate = nameAndBornYear[2];
                boolean isParentOrChild = false;
                for (Parent parent : parentsList) {
                    if (parent.getDate().equals(bornDate)) {
                        parent.setName(name);
                        isParentOrChild = true;
                    } else if (parent.getName().equals(name)) {
                        parent.setDate(bornDate);
                        isParentOrChild = true;
                    }
                }
                for (Child child : childList) {
                    if (child.getDate().equals(bornDate)) {
                        child.setName(name);
                        isParentOrChild = true;
                    } else if (child.getName().equals(name)) {
                        child.setDate(bornDate);
                        isParentOrChild = true;
                    }
                }
                if (isParentOrChild == false) {
                    if (person.getName().equals(name)) {
                        person.setDate(bornDate);
                    } else if (person.getDate().equals(bornDate)) {
                        person.setName(name);
                    }
                }
            }
        }
        Person personFamilyTie = new Person(person.getName(), person.getDate(), childList, parentsList);
        System.out.println(personFamilyTie);
    }
}
