package Shapes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape rect = new Rectangle(4d, 5d);
        Shape circleShape = new Circle(4d);
        Rectangle rectangle = new Rectangle(10d, 20d);
        Circle circle = new Circle(10d);
        List<Shape> shapes = new ArrayList<>();
        shapes.add(rect);
        shapes.add(circleShape);
        shapes.add(rectangle);
        shapes.add(circle);

        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
            System.out.println(shape.getPerimeter());
        }
    }
}
