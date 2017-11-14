package SecondExersiceEncapsulation.ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        double length = Double.parseDouble(console.readLine());
        double width = Double.parseDouble(console.readLine());
        double height = Double.parseDouble(console.readLine());

        try{
            Box box = new Box(length, width, height);
            System.out.print(box);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
