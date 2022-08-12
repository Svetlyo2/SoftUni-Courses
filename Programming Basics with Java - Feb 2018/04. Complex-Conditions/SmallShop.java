import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine().toLowerCase();
        String town = scanner.nextLine().toLowerCase();
        double qty = Double.parseDouble(scanner.nextLine());
        double price = 0.00;
        double amount = 0.00;

        if (town.equals("sofia")) {
            if (product.equals("coffee")) {
                price = 0.5;
            } else if (product.equals("water")) {
                price = 0.80;
            } else if (product.equals("beer")) {
                price = 1.20;
            } else if (product.equals("sweets")) {
                price = 1.45;
            } else if (product.equals("peanuts")) {
                price = 1.60;
            }
        } else if (town.equals("plovdiv")) {
            if (product.equals("coffee")) {
                price = 0.40;
            } else if (product.equals("water")) {
                price = 0.70;
            } else if (product.equals("beer")) {
                price = 1.15;
            } else if (product.equals("sweets")) {
                price = 1.3;
            } else if (product.equals("peanuts")) {
                price = 1.50;
            }

        } else if (town.equals("varna")) {
            if (product.equals("coffee")) {
                price = 0.45;
            } else if (product.equals("water")) {
                price = 0.7;
            } else if (product.equals("beer")) {
                price = 1.1;
            } else if (product.equals("sweets")) {
                price = 1.35;
            } else if (product.equals("peanuts")) {
                price = 1.55;
            }
        } amount = price * qty;
        System.out.printf("%.4f", amount);

    }

}
