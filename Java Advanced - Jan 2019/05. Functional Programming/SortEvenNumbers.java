import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> nums = Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toList());

        List<String> evenNums = nums.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", evenNums));
        List<String> evenNumsSorted = nums.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", evenNumsSorted));
    }
}
