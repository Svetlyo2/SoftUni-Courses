import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine().toLowerCase();
        double r = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());
        double revenue = 0;

        switch (projection) {
            case "premiere":
                revenue = r * c * 12;
                break;
            case "normal":
                revenue = r * c * 7.5;
                break;
            case "discount":
                revenue = r * c * 5;
                break;
        } System.out.printf("%.2f leva", revenue);
    }
}
