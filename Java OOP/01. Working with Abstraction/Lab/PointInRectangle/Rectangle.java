package PointInRectangle;

public class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public boolean contains(Point point){
        boolean isInHorizontal=point.getX()>=this.getTopLeft().getX() && point.getX()<=this.getBottomRight().getX();
        boolean isInVertical =point.getY()>=this.getTopLeft().getY() && point.getY()<=this.getBottomRight().getY();
        return isInHorizontal&&isInVertical;
    }
}
