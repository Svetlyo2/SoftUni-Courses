import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int [] params= Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int elementsToAdd=params[0];
        int elementsToPoll =params[1];
        int targetElement=params[2];

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(elementsToAdd)
                .forEach(e->queue.add(e));

        for (int j = 0; j < elementsToPoll; j++) {
            queue.poll();
        }
        if (queue.contains(targetElement)){
            System.out.println(true);
        } else {
            int minElem=Integer.MAX_VALUE;
            if (queue.isEmpty())minElem=0;
            while (!queue.isEmpty()){
                int current=queue.poll();
                if (current<minElem) minElem=current;
            }
            System.out.println(minElem);
        }
    }
}
