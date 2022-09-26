package ListUtilities;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, 2, 5, 6, 3);
        System.out.println(ListUtils.getMax(numbers));
        System.out.println(ListUtils.getMin(numbers));
    }
}
