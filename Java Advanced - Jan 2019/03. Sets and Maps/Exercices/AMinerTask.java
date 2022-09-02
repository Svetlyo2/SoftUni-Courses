import java.util.HashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> resources = new HashMap<>();

        String firstLine = scanner.nextLine();

        while (!firstLine.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            resources.putIfAbsent(firstLine, 0);
            resources.put(firstLine, quantity + resources.get(firstLine));
            firstLine = scanner.nextLine();
        }
        for (String r : resources.keySet()) {
            System.out.println(r + " -> " + resources.get(r));
        }
    }
}
