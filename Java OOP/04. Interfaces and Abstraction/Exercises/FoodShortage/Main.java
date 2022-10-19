package FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Buyer> buyers = new HashMap<>();
        int totalPurchaseAmount = 0;
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] personData = scanner.nextLine().split("\\s+");
            if (personData.length == 3) {
                Rebel rebel = new Rebel(personData[0], Integer.parseInt(personData[1]), personData[2]);
                buyers.put(personData[0], rebel);
            } else if (personData.length == 4) {
                Citizen citizen = new Citizen(personData[0], Integer.parseInt(personData[1]),
                        personData[2], personData[3]);
                buyers.put(personData[0], citizen);
            }
        }
        String line = scanner.nextLine();
        while (!"End".equals(line)) {
            if (buyers.keySet().contains(line)) {
                buyers.get(line).buyFood();
            }
            line = scanner.nextLine();
        }
        for (Buyer buyer : buyers.values()) {
            totalPurchaseAmount += buyer.getFood();
        }
        System.out.println(totalPurchaseAmount);

    }
}
