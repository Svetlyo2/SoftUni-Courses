package ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(";");
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();
        for (String p : line) {
            try {
                String[] peopleMoney = p.split("=");
                Person person = new Person(peopleMoney[0], Double.parseDouble(peopleMoney[1]));
                people.put(peopleMoney[0], person);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        line = scanner.nextLine().split(";");
        for (String p : line) {
            try {
                String[] productsCosts = p.split("=");
                Product product = new Product(productsCosts[0], Double.parseDouble(productsCosts[1]));
                products.put(productsCosts[0], product);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        line = scanner.nextLine().split(" ");
        while (!line[0].equals("END")) {
            String personName = line[0];
            String productName = line[1];
            if (people.containsKey(personName)) {
                people.get(personName).buyProduct(products.get(productName));
            }
            line = scanner.nextLine().split(" ");
        }
        for (Person person : people.values()) {
            System.out.println(person.toString());
        }
    }


}
