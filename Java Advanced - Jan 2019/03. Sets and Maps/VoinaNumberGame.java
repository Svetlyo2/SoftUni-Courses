import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayerInput = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        LinkedHashSet<Integer> firstPlayer = new LinkedHashSet<>();
        firstPlayer.addAll(firstPlayerInput);


        List<Integer> secondPlayerInput = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        LinkedHashSet<Integer> secondPlayer = new LinkedHashSet<>();
        secondPlayer.addAll(secondPlayerInput);

        for (int round = 0; round < 50; round++) {
            if (firstPlayer.isEmpty()) {
                System.out.println("Second player win!");
                return;
            }

            if (secondPlayer.isEmpty()) {
                System.out.println("First player win!");
                return;
            }

            Integer firstPlayerCard = firstPlayer.iterator().next();
            Integer secondPlayerCard = secondPlayer.iterator().next();

            firstPlayer.remove(firstPlayerCard);
            secondPlayer.remove(secondPlayerCard);

            if(firstPlayerCard > secondPlayerCard) {
                firstPlayer.add(firstPlayerCard);
                firstPlayer.add(secondPlayerCard);
            } else if (firstPlayerCard < secondPlayerCard){
                secondPlayer.add(firstPlayerCard);
                secondPlayer.add(secondPlayerCard);
            } else {
                firstPlayer.add(firstPlayerCard);
                secondPlayer.add(secondPlayerCard);
            }
        }

        int firstPlayerDeckSize = firstPlayer.size();
        int secondPlayerDeckSize = secondPlayer.size();

        if(firstPlayerDeckSize > secondPlayerDeckSize) {
            System.out.println("First player win!");
        } else if (secondPlayerDeckSize > firstPlayerDeckSize) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
