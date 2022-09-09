import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command = scanner.nextLine();

        Function<int[], int[]> add = integers -> {

            for (int i = 0; i < integers.length; i++) {
                integers[i]++;
            }
            return integers;
        };
        Function<int[], int[]> multiply = integers -> {

            for (int i = 0; i < integers.length; i++) {
                integers[i] *= 2;
            }
            return integers;
        };
        Function<int[], int[]> subtract = integers -> {

            for (int i = 0; i < integers.length; i++) {
                integers[i]--;
            }
            return integers;
        };
        Function<int[], int[]> print = integers -> {

            for (int i = 0; i < integers.length; i++) {
                System.out.print(integers[i] + " ");
            }
            System.out.println();
            return integers;
        };

        while (!"end".equals(command)) {
            if ("add".equals(command)) {
                numbers = add.apply(numbers);
            } else if ("subtract".equals(command)) {
                numbers = subtract.apply(numbers);
            } else if ("multiply".equals(command)) {
                numbers = multiply.apply(numbers);
            } else if ("print".equals(command)) {
                numbers = print.apply(numbers);
            }
            command = scanner.nextLine();
        }
    }
}
