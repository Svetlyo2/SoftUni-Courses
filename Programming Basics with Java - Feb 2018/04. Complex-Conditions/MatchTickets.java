import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer budget = Integer.parseInt(scanner.nextLine());
        String category = scanner.nextLine().toLowerCase();
        Integer people = Integer.parseInt(scanner.nextLine());
        double transport = -1.0;
        double amount = 0;

        if (people > 0 && people < 5) {
            transport = budget * 0.75;
            if (category.equals("vip")) {
                amount = budget - transport - people * 499.99;
                if (amount >= 0) {
                    System.out.printf("Yes! You have %.2f leva left.", amount);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", Math.abs(amount));
                }
            } else if (category.equals("normal")) {
                amount = budget - transport - people * 249.99;
                if (amount >= 0) {
                    System.out.printf("Yes! You have %.2f leva left.", amount);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", Math.abs(amount));
                }
            }
        } else if (people >= 5 && people < 10) {
            transport = budget * 0.6;
            if (category.equals("vip")) {
                amount = budget - transport - people * 499.99;
                if (amount >= 0) {
                    System.out.printf("Yes! You have %.2f leva left.", amount);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", Math.abs(amount));
                }
            } else if (category.equals("normal")) {
                amount = budget - transport - people * 249.99;
                if (amount >= 0) {
                    System.out.printf("Yes! You have %.2f leva left.", amount);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", Math.abs(amount));
                }
            }
        } else if (people >= 10 && people < 25) {
            transport = budget * 0.5;
            if (category.equals("vip")) {
                amount = budget - transport - people * 499.99;
                if (amount >= 0) {
                    System.out.printf("Yes! You have %.2f leva left.", amount);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", Math.abs(amount));
                }
            } else if (category.equals("normal")) {
                amount = budget - transport - people * 249.99;
                if (amount >= 0) {
                    System.out.printf("Yes! You have %.2f leva left.", amount);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", Math.abs(amount));
                }
            }
        } else if (people >= 25 && people < 50) {
            transport = budget * 0.4;
            if (category.equals("vip")) {
                amount = budget - transport - people * 499.99;
                if (amount >= 0) {
                    System.out.printf("Yes! You have %.2f leva left.", amount);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", Math.abs(amount));
                }
            } else if (category.equals("normal")) {
                amount = budget - transport - people * 249.99;
                if (amount >= 0) {
                    System.out.printf("Yes! You have %.2f leva left.", amount);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", Math.abs(amount));
                }
            }
        } else if (people >= 50) {
            transport = budget * 0.25;
            if (category.equals("vip")) {
                amount = budget - transport - people * 499.99;
                if (amount >= 0) {
                    System.out.printf("Yes! You have %.2f leva left.", amount);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", Math.abs(amount));
                }
            } else if (category.equals("normal")) {
                amount = budget - transport - people * 249.99;
                if (amount >= 0) {
                    System.out.printf("Yes! You have %.2f leva left.", amount);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", Math.abs(amount));
                }
            }
        }
    }
}

