package SecondLectureEncapsulation.SortPersonByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();
        int number = Integer.parseInt(console.readLine());
        for (int i = 0; i < number; i++) {
            String [] input = console.readLine().split(" ");
            Person person = new Person(input[0],input[1],Integer.parseInt(input[2]));
            people.add(person);
        }

        Collections.sort(people,(firstPerson,secondPerson) -> {
            int firstCompare = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
            if (firstCompare != 0){
                return firstCompare;
            }
            else{
                return Integer.compare(firstPerson.getAge(),secondPerson.getAge());
            }
        });

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
