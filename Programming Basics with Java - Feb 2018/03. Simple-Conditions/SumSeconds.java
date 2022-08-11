import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstPlayer = Integer.parseInt(scanner.nextLine());
        int secondPlayer = Integer.parseInt(scanner.nextLine());
        int thirdPlayer = Integer.parseInt(scanner.nextLine());
        int totalTime = firstPlayer + secondPlayer + thirdPlayer;

        int minutes = totalTime / 60;
        int seconds = totalTime %60;
        System.out.printf("%d:%02d", minutes, seconds);
    }
}
