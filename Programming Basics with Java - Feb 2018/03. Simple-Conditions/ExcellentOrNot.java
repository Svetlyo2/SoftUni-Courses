import java.util.Scanner;

public class ExcellentOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = Double.parseDouble(scanner.nextLine());

        if (result >= 5.50) {
            System.out.println("Excellent!");
        } else {
            System.out.println("Not excellent.");
        }
    }
}
