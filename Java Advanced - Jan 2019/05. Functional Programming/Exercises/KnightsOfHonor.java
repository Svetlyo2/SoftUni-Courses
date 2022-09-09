import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        Consumer<String> printWord = w -> System.out.println("Sir " + w);
        Arrays.stream(words).forEach(w -> printWord.accept(w));
    }
}
