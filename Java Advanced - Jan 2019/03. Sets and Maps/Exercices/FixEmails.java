
import java.util.LinkedHashMap;
import java.util.Scanner;

//requires LinkedHashMap even though it's not specified
public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> emailBook = new LinkedHashMap<>();
        String firstLine = "";

        while (true) {
            firstLine = scanner.nextLine();
            if (firstLine.equals("stop") || firstLine.equals("")) {
                break;
            }
            String email = scanner.nextLine().toLowerCase();
            String domain = email.substring(email.lastIndexOf('.') + 1);
//            boolean isNotAcceptable = domain.equals("uk") || domain.equals("us") || domain.equals("com");
            boolean isForeign = email.endsWith("uk") || email.endsWith("us") || email.endsWith("com");
            if (!isForeign) {
                emailBook.putIfAbsent(firstLine, "");
                emailBook.put(firstLine, email);
            }
        }
        for (String key : emailBook.keySet()) {
            System.out.println(key + " -> " + emailBook.get(key));
        }
    }
}
