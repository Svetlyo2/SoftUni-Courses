import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < n + 1; row++) {
            System.out.print(repeatStr(" ", n - row));
            System.out.print(repeatStr("*", row));
            System.out.print(" | ");
            System.out.print(repeatStr("*", row));
            System.out.print(repeatStr(" ", n - row));
            System.out.println();
        }
    } static String repeatStr (String text,int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(text);
        }
        return sb.toString();
    }
}
