import java.util.Scanner;

public class PointOnBorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

        boolean lefts = (x == x1) && (y >= y1) && (y <= y2);
        boolean rights = (x == x2) && (y >= y1) && (y <= y2);
        boolean ups = (y == y1 ) && (x >= x1) && (x <= x2);
        boolean downs = (y == y2 ) && (x >= x1) && (x <= x2);
        if (lefts || rights || ups || downs) {
            System.out.println("Border");
        } else {
            System.out.println("Inside / Outside");
        }
    }
}
