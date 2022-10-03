package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public double calculateSurfaceArea(){
        return 2*length*width+2*length*height+2*width*height;
    }
    public double calculateLateralSurfaceArea(){
        return 2*length*height+2*width*height;
    }
    public double calculateVolume(){
        return length*width*height;
    }
}
//Surface Area = 2lw + 2lh + 2wh
//Lateral Surface Area = 2lh + 2wh
//Rectangular Parallelepiped Volume = lwh
