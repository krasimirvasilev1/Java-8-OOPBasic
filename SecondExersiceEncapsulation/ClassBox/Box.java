package SecondExersiceEncapsulation.ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
    }

    public double lateralSurfaceAreaValue(double length, double height, double width) {
        return (2 * length * height) + (2 * width * height);
    }

    public double surfaceAreaValue(double length, double height, double width) {
        return (2 * length * width) + lateralSurfaceAreaValue(length, height, width);
    }

    public double volume(double length, double height, double width) {
        return (length * height * width);
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f", surfaceAreaValue(getLength(), getHeight(), getWidth()), lateralSurfaceAreaValue(getLength(), getHeight(), getWidth()), volume(getLength(), getHeight(), getWidth()));
    }
}
