package FourthLecturePolimorphism.OverrideOperations;

public class Rectangle{
    protected double sideOne;
    protected double sideTwo;

    public Rectangle(double sideOne, double sideTwo) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
    }

    protected double area (){
        return this.sideOne * this.sideTwo;
    }
}
