import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxNameLength = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> requiredLength = n -> n.length() <= maxNameLength;
        Arrays.stream(names).filter(requiredLength).forEach(s -> System.out.println(s));
    }
}
