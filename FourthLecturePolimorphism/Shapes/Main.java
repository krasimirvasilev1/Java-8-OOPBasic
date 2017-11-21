package FourthLecturePolimorphism.Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(13.5,13.4);
        Shape circle = new Circle(4);
        rectangle.calculateArea();
        rectangle.calculatePerimeter();
        circle.calculateArea();
        circle.calculatePerimeter();
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
        System.out.println();
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}
