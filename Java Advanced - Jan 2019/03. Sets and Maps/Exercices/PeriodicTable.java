import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> compounds = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            compounds.addAll(Arrays.asList(line));
        }
        for (String compound : compounds) {
            System.out.print(compound + " ");
        }
    }
}
