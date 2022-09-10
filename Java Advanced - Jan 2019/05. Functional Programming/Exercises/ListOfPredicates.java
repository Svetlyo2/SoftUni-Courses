import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int maxNumber = Integer.parseInt(scanner.nextLine());
        if (maxNumber < 0) {
            return;
        }
        HashSet<String> input = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toCollection(HashSet::new));
        int[] dividers = input.stream()
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] array = new int[maxNumber];
        List<Integer> resultArray = new ArrayList<>();
        for (int i = 0; i < maxNumber; i++) {
            array[i] = i + 1;
        }
        BiPredicate<Integer, int[]> isDivisible  = (currentNum, devs) -> {
            for (int i = 0; i < devs.length; i++) {
                if (currentNum % devs[i] != 0) {
                    return false;
                }
            }
            return true;
        };
        for (int j = 0; j < maxNumber; j++) {
            if (isDivisible .test(array[j], dividers)) {
                resultArray.add(array[j]);
            }
        }
        resultArray.stream()
                .map(String::valueOf)
                .forEach(v -> System.out.print(v + " "));
    }
}
