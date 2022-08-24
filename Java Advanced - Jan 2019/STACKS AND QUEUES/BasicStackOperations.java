import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int [] params= Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int elementsToAdd=params[0];
        int elementsToPop=params[1];
        int targetElement=params[2];

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(elementsToAdd)
                .forEach(e->stack.push(e));

//        for (int i = 0; i < elementsToAdd; i++) {
//            int current=Integer.parseInt(numbers[i]);
//            stack.push(current);
//        }
        for (int j = 0; j < elementsToPop; j++) {
            stack.pop();
        }
        if (stack.contains(targetElement)){
            System.out.println(true);
        } else {
            int minElem=Integer.MAX_VALUE;
            if (stack.isEmpty())minElem=0;
        while (!stack.isEmpty()){
            int current = stack.pop();
            if (current < minElem) minElem = current;
        }
        System.out.println(minElem);
        }
    }
}
