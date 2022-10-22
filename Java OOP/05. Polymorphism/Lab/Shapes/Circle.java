package Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        // include methods in constructor for the fields of Shape
        this.calculatePerimeter();
        this.calculateArea();
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        this.setPerimeter(Math.PI*2*radius);
    }

    @Override
    protected void calculateArea() {
        this.setArea(Math.PI*2*radius*radius);
    }
}
