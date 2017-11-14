package SecondExersiceEncapsulation.AnimalFarm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String name = console.readLine();
        int age = Integer.parseInt(console.readLine());

        try{
            Chicken chicken = new Chicken(name,age);
            System.out.println(chicken);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
