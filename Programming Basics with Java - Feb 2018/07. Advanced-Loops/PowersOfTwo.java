import java.util.Scanner;

public class PowersOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Integer num=1;
        System.out.println(num);
        for (int i = 0; i < n; i++) {
            num *=2;
            System.out.println(num);
        }
    }
}
