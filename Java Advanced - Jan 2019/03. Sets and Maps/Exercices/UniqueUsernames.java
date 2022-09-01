import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet <String> userNames=new LinkedHashSet<>();
        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            userNames.add(scanner.nextLine());
        }
        for (String user :userNames) {
            System.out.println(user);
        }
    }
}
