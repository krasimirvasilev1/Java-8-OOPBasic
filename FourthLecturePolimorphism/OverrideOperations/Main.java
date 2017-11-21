package FourthLecturePolimorphism.OverrideOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        List<Rectangle> rectangleList = new ArrayList<>();
        int numberOfFigures = Integer.parseInt(console.readLine());

        for (int i = 0; i < numberOfFigures; i++) {
            String[] input = console.readLine().split("\\s+");
            if (input.length == 1){
                Square square = new Square(Double.parseDouble(input[0]),0);
                rectangleList.add(square);
            }
            else{
                Rectangle rectangle = new Rectangle(Double.parseDouble(input[0]),Double.parseDouble(input[1]));
                rectangleList.add(rectangle);
            }
        }

        for (Rectangle rectangle : rectangleList) {
            System.out.println(rectangle.area());
        }


    }
}
