package GenericSwapMethodIntegers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Object> list = new ArrayList<>();

        while (n-- > 0) {
            int num = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(num);
            list.add(box);
        }

        String[] command = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(command[0]);
        int secondIndex = Integer.parseInt(command[1]);
        Object first = list.get(firstIndex);
        Object second = list.get(secondIndex);
        list.set(firstIndex, second);
        list.set(secondIndex, first);

        for (Object s : list) {
            System.out.println(s);
        }
    }
}
