import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        LinkedHashMap<Double, Integer> occurrences = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if(occurrences.containsKey(numbers[i])) {
                occurrences.put(numbers[i], occurrences.get(numbers[i]) + 1);
            } else {
                occurrences.put(numbers[i], 1);
            }
        }
        for (Double number : occurrences.keySet()) {
            System.out.printf("%.1f -> %d\n", number, occurrences.get(number));
        }
    }
}
