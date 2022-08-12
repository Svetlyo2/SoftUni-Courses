import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toLowerCase();
        String day = scanner.nextLine().toLowerCase();
        double qty = Double.parseDouble(scanner.nextLine());
        double price =-1.0;

        if (day.equals("monday") || day.equals("tuesday") || day.equals("wednesday") || day.equals("thursday") || day.equals("friday")) {
            if (s.equals("banana")) price = 2.50;
            if (s.equals("apple")) price = 1.2;
            if (s.equals("orange")) price = 0.85;
            if (s.equals("grapefruit")) price = 1.45;
            if (s.equals("kiwi")) price = 2.70;
            if (s.equals("grapes")) price = 3.85;
            if (s.equals("pineapple")) price = 5.50;
        } else if (day.equals("saturday") || day.equals("sunday")) {
            if (s.equals("banana")) price = 2.70;
            if (s.equals("apple")) price = 1.25;
            if (s.equals("kiwi")) price = 3.0;
            if (s.equals("orange")) price = 0.9;
            if (s.equals("grapefruit")) price = 1.6;
            if (s.equals("grapes")) price = 4.2;
            if (s.equals("pineapple")) price = 5.60;
        } else {
            System.out.println("error");
        }
        if (price >=0) {
            System.out.println(price*qty);
        } else {
            System.out.println("error");
        }
    }
}

