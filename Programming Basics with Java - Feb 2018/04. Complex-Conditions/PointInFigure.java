import java.util.Scanner;

public class PointInFigure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = Integer.parseInt(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

        if ((x>0 && x<(h*3) && y>0 && y<h) || (x>h && x < (2*h) && y>=h && y<(4*h))) {
            System.out.println("inside");
        } else if ((x == 0.0 || x == h * 3) && y>=0 && y<=h) {
            System.out.println("border");
        } else if ((x>=0 && x<=h*3) && y==0 ) {
            System.out.println("border");
        } else if (((x>=0 && x<=h) || (x>=2*h && x<=h*3)) && y==h) {
            System.out.println("border");
        } else if ((x==h || x==h*2) &&  y>=h && y<=4*h ) {
            System.out.println("border");
        } else if ((x>=h && x<=h*2) &&  y==4*h ) {
            System.out.println("border");
        } else if (x>=h && x<=h*2 && y==4*h) {
            System.out.println("border");
        } else System.out.println("outside");
    }
}
