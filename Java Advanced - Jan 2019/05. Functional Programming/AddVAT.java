import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] prices = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        UnaryOperator<Double> addVat = price -> price * 1.2;
        System.out.println("Prices with VAT:");
        Arrays.stream(prices).map(p -> addVat.apply(p))
                .boxed()
                .forEach(d -> System.out.printf("%.2f%n", d));
    }
}
