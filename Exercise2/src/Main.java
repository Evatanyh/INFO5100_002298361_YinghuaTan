import geometry.*;

public class Main {
    public static void main(String[] args) {
        Shape triangle = new Triangle("Red", 3, 4, 5);
        Shape rectangle = new Rectangle("Blue", 5, 6);
        Shape circle = new Circle("Green", 4);
        Shape square = new Square("Yellow", 5);

        triangle.displayInfo();
        rectangle.displayInfo();
        circle.displayInfo();
        square.displayInfo();
    }
}