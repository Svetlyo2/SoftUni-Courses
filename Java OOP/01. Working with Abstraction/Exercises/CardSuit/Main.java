package CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine() + ":");
        Suits[] cards = Suits.values();
//        for (int i = 0; i < cards.length; i++) {
//            System.out.printf("Ordinal value: %d; Name value: %s%n",i,cards[i] );
//        }
        for (Suits card : cards) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card);
        }
    }
}
