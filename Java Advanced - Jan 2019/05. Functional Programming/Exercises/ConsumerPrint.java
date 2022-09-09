import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        //Consumer<String> printWord= w-> System.out.println(w);
        Consumer<String> printWord = System.out::println;
        Arrays.stream(words).forEach(printWord);
    }
}
