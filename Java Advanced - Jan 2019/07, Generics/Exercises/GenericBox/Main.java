package GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            String line = scanner.nextLine();
            Box<String> box = new Box<>(line);
            System.out.println(box);
            n--;
        }
    }
}
