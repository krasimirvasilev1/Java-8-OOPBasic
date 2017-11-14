package SecondLectureEncapsulation.SalaryIncrease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int numberOfEmployees = Integer.parseInt(console.readLine());
        List<Person> people = new LinkedList<>();
        for (int i = 0; i < numberOfEmployees; i++) {
            String [] info = console.readLine().split(" ");
            Person person = new Person(info[0],info[1],Integer.parseInt(info[2]),Double.parseDouble(info[3]));
            people.add(person);
        }
        double bonus = Double.parseDouble(console.readLine());
        for (Person person : people) {
            person.getBonus(bonus);
            System.out.println(person);
        }
    }
}
