package ThirdLectureInheritance.FragileBaseClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Predator p = new Predator() ;
        p.eat(new Food ());
        System.out.println(p.getHealth());
        p.eatAll(new Food []{new Food(),new Food(),new Food()});
        System.out.println(p.getHealth());
    }
}
