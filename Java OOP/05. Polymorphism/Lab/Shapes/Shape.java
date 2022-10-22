package Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getPerimeter() {
        return perimeter;
    }
    protected void setArea(Double area) {
        this.area = area;
    }

    public Double getArea() {
        return area;
    }

    abstract void calculatePerimeter();
    abstract void calculateArea();
}
