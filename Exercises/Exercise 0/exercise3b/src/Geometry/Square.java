package geometry;

import java.io.Serializable;

public class Square extends Shape implements Serializable {
    private static final long serialVersionUID = 1L;
    private double side;

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}
