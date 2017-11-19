package ThirdExersiceInheritance.Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] student = console.readLine().split("\\s+");
            Human student1 = new Student(student[0], student[1], student[2]);
            String[] worker = console.readLine().split("\\s+");
            Human worker1 = new Worker(worker[0], worker[1], Double.parseDouble(worker[2]), Double.parseDouble(worker[3]));

            System.out.println(student1);
            System.out.println(worker1);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
