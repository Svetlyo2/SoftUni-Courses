import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String kind = "Prime";

        if (n<2) {
            System.out.println("Not Prime");
        } else {
            for (int i = 2; i <= Math.sqrt(n) ; i++) {
                if (n%i ==0) {
                    kind="Not Prime";
                    break;
                }
            } System.out.println(kind);
        }
    }
}
