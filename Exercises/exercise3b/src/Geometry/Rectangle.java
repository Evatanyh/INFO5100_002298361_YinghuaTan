package geometry;

import java.io.Serializable;

public class Rectangle extends Shape implements Serializable {
    private static final long serialVersionUID = 1L;
    private double length, width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}
