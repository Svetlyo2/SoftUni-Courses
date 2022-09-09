import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function <int[], Integer>  findMin= integers -> {
            int min=Integer.MAX_VALUE;
            for (int i = 0; i < integers.length; i++) {
                if (integers[i]<min){
                    min=integers[i];
                }
            }
            return min;
        };
        System.out.println(findMin.apply(numbers));
    }
}
