import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int divider = Integer.parseInt(scanner.nextLine());
        List<Integer> dividableNums = Arrays.stream(numbers)
                .filter(x -> x % divider != 0)
                .boxed()
                .collect(Collectors.toList());
        Collections.reverse(dividableNums);
        dividableNums.forEach(a -> System.out.print(a + " "));
    }
}
