package FourthLecturePolimorphism.OverrideOperations;

public class Square extends Rectangle{

    public Square(double sideOne, double sideTwo) {
        super(sideOne, sideTwo);
    }

    @Override
    protected double area(){
        return this.sideOne * this.sideOne;
    }
}
