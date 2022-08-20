import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sumOdd = 0;
        int sumEven = 0;
        int difference = 0;

        for (int i=0; i<n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (i%2==0) {
                sumOdd += number;
            } else { sumEven += number;}
        } difference = Math.abs(sumEven-sumOdd);
        if (difference==0) {
            System.out.printf("Yes\nSum = %d", sumEven);
        } else {
            System.out.printf("No\nDiff = %d", difference);
        }
    }
}
