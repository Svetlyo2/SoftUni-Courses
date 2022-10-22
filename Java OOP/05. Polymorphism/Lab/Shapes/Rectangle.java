package Shapes;

public class Rectangle extends Shape{
    private Double height;
    private Double width ;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }
    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    protected void calculatePerimeter() {
        this.setPerimeter ((this.height+this.width)*2);
    }

    @Override
    protected void calculateArea() {
        this.setArea( this.height*this.width);
    }
}
