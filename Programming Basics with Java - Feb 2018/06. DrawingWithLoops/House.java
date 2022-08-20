import java.util.Scanner;

public class House {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean even = (n % 2 == 0);
        int asterix = 0;
        Integer minus = (n - 2) / 2;

        for (int i = 0; i < (n + 1) / 2; i++) {
            if (even) {
                asterix += 2;
                System.out.print(repeatStr("-", (n-asterix)/2));
                System.out.print(repeatStr("*", asterix));
                System.out.println(repeatStr("-", (n-asterix)/2));
            } else {
                asterix = 1;
                System.out.print(repeatStr("-", (n-asterix)/2-i));
                System.out.print(repeatStr("*", asterix+i*2));
                System.out.println(repeatStr("-", (n-asterix)/2-i));

            }
        }
        for (int wall = 0; wall < n/2; wall++) {
            System.out.print("|");
            System.out.print(repeatStr("*", n-2));
            System.out.println("|");
            
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
