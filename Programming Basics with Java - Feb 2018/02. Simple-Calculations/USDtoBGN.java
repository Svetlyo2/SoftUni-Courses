import java.util.Scanner;

public class USDtoBGN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double dollars = Double.parseDouble(scanner.nextLine());
        double convertedBGN = dollars * 1.79549;
        System.out.printf("%.2f", convertedBGN);
    }
}
