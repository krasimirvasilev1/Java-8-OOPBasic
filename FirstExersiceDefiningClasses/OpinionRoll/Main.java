package FirstExersiceDefiningClasses.OpinionRoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Person> newList = new ArrayList<>();
        int numberOfLinesInput = Integer.parseInt(console.readLine());
        for (int i = 0; i < numberOfLinesInput; i++) {
            String [] input = console.readLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name,age);
            newList.add(person);
        }

        newList.stream().filter(x -> x.getAge() > 30).sorted(Comparator.comparing(Person::getName)).forEach(x -> System.out.println(x.getName()+" - "+x.getAge()));
    }
}
