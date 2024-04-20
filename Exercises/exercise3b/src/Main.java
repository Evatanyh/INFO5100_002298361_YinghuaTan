import java.io.*;

import geometry.Circle;
import geometry.Rectangle;
import geometry.Shape;
import geometry.Square;
import geometry.Triangle;

public class Main {
    public static void main(String[] args) {
        // Create objects
        Shape triangle = new Triangle("Red", 3, 4, 5);
        Shape rectangle = new Rectangle("Blue", 5, 6);
        Shape circle = new Circle("Green", 4);
        Shape square = new Square("Yellow", 5);

        // Serialize objects
        serializeObject("triangle.ser", triangle);
        serializeObject("rectangle.ser", rectangle);
        serializeObject("circle.ser", circle);
        serializeObject("square.ser", square);

        // Deserialize objects
        Shape deserializedTriangle = deserializeObject("triangle.ser");
        Shape deserializedRectangle = deserializeObject("rectangle.ser");
        Shape deserializedCircle = deserializeObject("circle.ser");
        Shape deserializedSquare = deserializeObject("square.ser");

        // Display deserialized objects
        deserializedTriangle.displayInfo();
        deserializedRectangle.displayInfo();
        deserializedCircle.displayInfo();
        deserializedSquare.displayInfo();
    }

    private static void serializeObject(String fileName, Object obj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + fileName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private static Shape deserializeObject(String fileName) {
        Shape obj = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = (Shape) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
