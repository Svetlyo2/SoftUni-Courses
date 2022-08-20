import java.util.Scanner;

public class Sunglasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());
        boolean even = (n % 2 == 0);

        System.out.print(repeatStr("*", n * 2));
        System.out.print(repeatStr(" ", n));
        System.out.println(repeatStr("*", n * 2));

        for (int row = 0; row < n-2; row++) {
            System.out.print("*");
            System.out.print(repeatStr("/", n * 2 - 2));
            System.out.print("*");

            if (even && row==n/2-2) {
                System.out.print(repeatStr("|", n));
            } else if (!even && row==n/2-1){
                System.out.print(repeatStr("|", n));

            } else System.out.print(repeatStr(" ",n));
            System.out.print("*");
            System.out.print(repeatStr("/", n * 2 - 2));
            System.out.println("*");
        } System.out.print(repeatStr("*", n * 2));
        System.out.print(repeatStr(" ", n));
        System.out.println(repeatStr("*", n * 2));
    }

    static String repeatStr(String text, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(text);
        }
        return sb.toString();
    }
}