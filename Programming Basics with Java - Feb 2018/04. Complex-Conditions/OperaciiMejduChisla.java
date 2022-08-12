import java.util.Scanner;

public class OperaciiMejduChisla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n1 = Integer.parseInt(scanner.nextLine());
        Integer n2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        double result = -1;

        switch (operator) {
            case "+":
                result = n1 + n2;
                System.out.printf("%d %s %d = %.0f - ", n1, operator, n2, result);

                if (result % 2 == 0) {
                    System.out.println("even");
                } else {
                    System.out.println("odd");
                }
                break;
            case "-":
                result = n1 - n2;
                System.out.printf("%d %s %d = %.0f - ", n1, operator, n2, result);

                if (result % 2 == 0) {
                    System.out.println("even");
                } else {
                    System.out.println("odd");
                }
                break;
            case "*":
                result = n1 * n2;
                System.out.printf("%d %s %d = %.0f - ", n1, operator, n2, result);

                if (result % 2 == 0) {
                    System.out.println("even");
                } else {
                    System.out.println("odd");
                }
                break;
            case "/":
                if (n2 == 0) {
                    System.out.printf("Cannot divide %d by zero", n1);
                } else {
                    result = (double) n1 / n2;
                    System.out.printf("%d %s %d = %.2f ", n1, operator, n2, result);
                }
                break;
            case "%":
                if (n2 == 0) {
                    System.out.printf("Cannot divide %d by zero", n1);
                } else {
                    result = n1 % n2;
                    System.out.printf("%d %s %d = %.0f ", n1, operator, n2, result);
                }
                break;
        }

    }
}
