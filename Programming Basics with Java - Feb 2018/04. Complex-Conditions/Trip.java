import java.util.Scanner;

public class Trip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine().toLowerCase();
        double amount = 0.0;
        String destination;
        String accomodation;

        if (budget <= 100) {
            destination = "Bulgaria";
            if (season.equals("summer")) {
                amount = budget * 0.3;
                accomodation = "Camp";
                System.out.println("Somewhere in " + destination );
                System.out.printf("%s - %.2f", accomodation, amount);
            } else if (season.equals("winter")) {
                amount = budget * 0.7;
                accomodation = "Hotel";
                System.out.println("Somewhere in " + destination );
                System.out.printf("%s - %.2f", accomodation, amount);
            }
        } else if (budget <= 1000) {
            destination = "Balkans";
            if (season.equals("summer")) {
                amount = budget * 0.4;
                accomodation = "Camp";
                System.out.println("Somewhere in " + destination );
                System.out.printf("%s - %.2f", accomodation, amount);
            } else if (season.equals("winter")) {
                amount = budget * 0.8;
                accomodation = "Hotel";
                System.out.println("Somewhere in " + destination );
                System.out.printf("%s - %.2f", accomodation, amount);
            }
        } else if (budget > 1000) {
            destination = "Europe";
            accomodation = "Hotel";
            amount = budget * 0.9;
            System.out.println("Somewhere in " + destination );
            System.out.printf("%s - %.2f", accomodation, amount);
        }
    }
}
