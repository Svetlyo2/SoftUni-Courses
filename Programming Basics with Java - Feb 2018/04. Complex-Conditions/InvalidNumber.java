import java.util.Scanner;

public class InvalidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer a = Integer.parseInt(scanner.nextLine());

        boolean isValid = (a >=100) && (a<=200) || (a==0);
        if (!isValid) System.out.println("invalid");
    }
}
