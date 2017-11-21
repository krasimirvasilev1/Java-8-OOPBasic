package FourthLecturePolimorphism.Shapes;

abstract public class Shape {
    private double perimeter;
    private double area;

    public final double getPerimeter() {
        return perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public final double getArea() {
        return area;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    abstract protected void calculateArea();
    abstract protected void calculatePerimeter();
}
