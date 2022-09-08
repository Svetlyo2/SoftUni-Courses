import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//numbers are excluded from uppercase

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        Predicate<String> hasUpperLetter = word -> Character.isUpperCase(word.charAt(0));

        List<String> upperLetterWords = Arrays.stream(words)
                .filter(hasUpperLetter)
                .collect(Collectors.toList());
        System.out.println(upperLetterWords.size());
        upperLetterWords.forEach(System.out::println);
    }
}
