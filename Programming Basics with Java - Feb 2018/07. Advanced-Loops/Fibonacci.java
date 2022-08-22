import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int f0 = 1;
        int f1 = 1;
        int sum = 0;
        int i = 2;
        if (n < 2) {
            System.out.println("1");
        } else {
            while (i <= n) {
                sum = f0 + f1;
                f0 = f1;
                f1 = sum;
                i++;
            }
            System.out.println(sum);
        }
    }
}
