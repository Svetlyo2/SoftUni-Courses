import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String yearType = scanner.nextLine().toLowerCase();
        double holidays = Integer.parseInt(scanner.nextLine());
        double weekendsHome = Integer.parseInt(scanner.nextLine());
        double trainings = ((48 - weekendsHome) * 3.0 / 4 + weekendsHome + holidays * 2.0 / 3);

        if (yearType.equals("leap")) {
            trainings = trainings * 1.15;
        }
        System.out.printf("%.0f", Math.floor(trainings));
    }
}
