import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
                Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(e -> stack.push(e));

//        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        String [] nums= scanner.nextLine().split("\\s+");
//        for (int i = 0; i < nums.length; i++) {
//            stack.push(Integer.parseInt(nums[i]));
//        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
