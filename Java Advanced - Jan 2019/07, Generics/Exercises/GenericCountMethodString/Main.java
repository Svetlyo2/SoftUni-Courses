package GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> listOfBoxes = new ArrayList<>();
        while (n-- > 0) {
            String line = scanner.nextLine();
            Box<String> box = new Box<>(line);
            listOfBoxes.add(box);
        }
        String line = scanner.nextLine();
        Box<String> comparatorBox = new Box<>(line);
        System.out.println(countGreaterValues(listOfBoxes, comparatorBox));
    }

    public static <T extends Comparable<T>>
    int countGreaterValues(List<Box<T>> list, Box<T> box) {
        int counter = 0;
        for (Box<T> t : list) {
            if (t.compareTo(box) > 0) {
                counter++;
            }
        }
        return counter;
    }
}
