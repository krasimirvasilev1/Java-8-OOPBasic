package FourthLecturePolimorphism.Shapes;

public class Circle extends Shape{
    private double radius;


    public Circle(double radious) {
        this.radius = radious;
    }

    public final double getRadius() {
        return radius;
    }

    @Override
    public void calculateArea() {
        setArea(Math.PI * Math.pow(getRadius(),2));
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(2 * Math.PI * getRadius());
    }
}
