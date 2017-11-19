package ThirdExersiceInheritance.Personn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String name = console.readLine();
        int age = Integer.parseInt(console.readLine());

        try{
            Child child = new Child(name,age);
            System.out.println(child.toString());
            String personClassName = Person.class.getSimpleName();
            String childClassName = Child.class.getSimpleName();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}