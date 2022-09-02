import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(": ");
        LinkedHashMap<String, HashSet<String>> playersDecks = new LinkedHashMap<>();
        while (!input[0].equals("JOKER")) {
            HashSet<String> cards = Arrays.stream(input[1].split(", +"))
                    .collect(Collectors.toCollection(HashSet::new));
            if (!playersDecks.containsKey(input[0])) {
                playersDecks.put(input[0], cards);
            } else {
                playersDecks.get(input[0]).addAll(cards);
            }
            input = scanner.nextLine().split(": ");
        }
        for (String player : playersDecks.keySet()) {
            int deckPower = calculatePower(playersDecks.get(player));
            System.out.println(player + ": " + deckPower);
        }
    }

    private static int calculatePower(HashSet<String> deck) {
        int power = 0;
        HashMap<Character, Integer> cardsPower = new HashMap<>();
        cardsPower.put('2', 2);
        cardsPower.put('3', 3);
        cardsPower.put('4', 4);
        cardsPower.put('5', 5);
        cardsPower.put('6', 6);
        cardsPower.put('7', 7);
        cardsPower.put('8', 8);
        cardsPower.put('9', 9);
        cardsPower.put('1', 10);
        cardsPower.put('J', 11);
        cardsPower.put('Q', 12);
        cardsPower.put('K', 13);
        cardsPower.put('A', 14);
        cardsPower.put('S', 4);
        cardsPower.put('H', 3);
        cardsPower.put('D', 2);
        cardsPower.put('C', 1);
        for (String card : deck) {
            char current = card.charAt(0);
            int firstPower = cardsPower.get(current);
            current = card.charAt(card.length() - 1);
            int second = cardsPower.get(current);
            int currentCardPower = firstPower * second;
            power += currentCardPower;
        }
        return power;
    }
}
