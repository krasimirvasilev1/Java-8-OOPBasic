package FourthLecturePolimorphism.OverloadOperations;

public class Main {
    public static void main(String[] args) {
        MathOperation mathOperation = new MathOperation();
        System.out.println(mathOperation.add(2,2));
        System.out.println(mathOperation.add(2,3,4));
        System.out.println(mathOperation.add(2,3,4,5));
    }
}
