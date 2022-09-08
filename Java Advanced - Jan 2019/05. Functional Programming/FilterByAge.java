import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) {

        BiPredicate<Integer, Integer> isYounger = (age, limit) -> age < limit;
        BiPredicate<Integer, Integer> isOlder = (age, limit) -> age >= limit;

        Consumer<Map.Entry<String, Integer>> printName = person -> System.out.println(person.getKey());
        Consumer<Map.Entry<String, Integer>> printAge = person -> System.out.println(person.getValue());
        Consumer<Map.Entry<String, Integer>> printNameAndAge = person -> System.out.println(person.getKey() + " - " + person.getValue());

        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < lines; i++) {
            String[] input = scanner.nextLine().split(", ");
            people.put(input[0], Integer.parseInt(input[1]));
        }
        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Consumer<Map.Entry<String, Integer>> print = printNameAndAge;
        if ((format.equals("age"))) {
            print = printAge;
        } else if (format.equals("name")) {
            print = printName;
        }
        people.entrySet().stream()
                .filter(person -> condition.equals("younger") ?
                        isYounger.test(person.getValue(), ageLimit)
                        : isOlder.test(person.getValue(), ageLimit)
                ).forEach(print);
    }
}
