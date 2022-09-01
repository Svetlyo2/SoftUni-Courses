import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> firstNums=new LinkedHashSet<>();
        LinkedHashSet<String> secondNums=new LinkedHashSet<>();
        int [] length = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < length[0]; i++) {
            firstNums.add(scanner.nextLine());
        }
        for (int i = 0; i < length[1]; i++) {
            secondNums.add(scanner.nextLine());
        }
        for (String num :firstNums) {
            if (secondNums.contains(num)) {
                System.out.print(num+" ");
            }
        }
    }
}
