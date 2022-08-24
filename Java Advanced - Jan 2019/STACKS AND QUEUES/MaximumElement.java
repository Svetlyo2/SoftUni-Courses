import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int [] line= Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int command = line[0];
            if (command == 1){
                int number = line[1];
                stack.push(number);
            } else if (command == 2){
                stack.pop();
            } else if (command == 3){
                //int max=Collections.max(stack);
                int max =stack.stream().max(Integer::compareTo).get();
                System.out.println(max);
            }
        }
    }
}
