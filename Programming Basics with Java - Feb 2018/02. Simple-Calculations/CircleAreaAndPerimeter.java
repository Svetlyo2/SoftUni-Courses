import java.util.Scanner;

public class CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());
        double circleArea = Math.PI * r * r;
        double circlePerimeter = 2 * Math.PI * r;

        System.out.println(circleArea);
        System.out.println(circlePerimeter);
    }
}
