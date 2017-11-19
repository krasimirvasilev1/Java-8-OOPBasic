package ThirdExersiceInheritance.MordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] foods = console.readLine().toUpperCase().split("\\s+");
        GandalfTheGray gandalf = new GandalfTheGray(foods);

        System.out.println(gandalf);
    }
}
