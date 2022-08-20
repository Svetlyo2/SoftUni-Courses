import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        int leftRight = (int) Math.floor(((n - 1) / 2));
        int midDash = (int) Math.floor(n - 2 * leftRight - 2);
        double topRows = 0.0;
        Integer asterix = 1;

        if (n % 2 == 0) {
            topRows = n / 2.0;
        } else topRows = n / 2 + 1.0;

        if (n == 1) {
            System.out.println("*");
        } else if (n == 2) {
            System.out.println("**");
        } else if (n > 2) {
            for (int i = 0; i < topRows; i++) {

                System.out.print(repeatStr("-", leftRight - i));
                System.out.print(repeatStr("-", (midDash + i * 2)));
                if (midDash >= 0) {
                    System.out.print("*");
                }
                System.out.println(repeatStr("-", leftRight - i));
            }
        }
        int lowRows = (int) (topRows - 1);
        for (int i = 0; i < lowRows; i++) {
            System.out.print(repeatStr("-", leftRight - i));
            if (midDash >= 0) {
                System.out.print("*");
                System.out.print(repeatStr("-", (midDash + i * 2)));
                System.out.print("*");
                System.out.println(repeatStr("-", leftRight - i));
            } else {
                System.out.print("*");
                System.out.println(repeatStr("-", leftRight - i));
            }
        }
    }

    static String repeatStr(String text, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(text);
        }
        return sb.toString();
    }
}
