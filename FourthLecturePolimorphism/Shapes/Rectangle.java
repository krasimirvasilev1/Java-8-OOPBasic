package FourthLecturePolimorphism.Shapes;

public class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public final double getHeight() {
        return height;
    }

    public final double getWidth() {
        return width;
    }

    @Override
    public void calculateArea() {
       setArea(getHeight() * getWidth());
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(getWidth() * 2 + getHeight()* 2);
    }
}
