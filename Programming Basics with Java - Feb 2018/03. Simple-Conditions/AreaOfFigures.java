import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figure = (scanner.nextLine().toLowerCase());
        double a = Double.parseDouble(scanner.nextLine());

        if (figure.equals("square")) {
            System.out.printf("%.3f",a * a);
        } else if (figure.equals("rectangle")) {
            double b = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f", a * b);
        } else if (figure.equals("circle")) {
            System.out.printf("%.3f", Math.PI * a * a);
        } else if (figure.equals("triangle")) {
            double b = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f", a * b / 2);
        }
    }
}
