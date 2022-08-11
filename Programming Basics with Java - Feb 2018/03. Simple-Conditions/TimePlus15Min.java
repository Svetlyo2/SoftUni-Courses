import java.util.Scanner;

public class TimePlus15Min {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());
        int min15 = min + 15;
        if (min15 >= 60) {
            min15 = min15 - 60;
            h = h + 1;
            if (h > 23) {
                h = 0;
            }
        }
        System.out.printf("%d:%02d", h, min15);
    }
}
