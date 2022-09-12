package OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] current = scanner.nextLine().split(" ");
            Person person = new Person(current[0], Integer.parseInt(current[1]));
            people.add(person);
        }
        people.stream().filter(p -> p.getAge() > 30)
                .sorted((f, s) -> f.getName().compareTo(s.getName()))
                .forEach(person -> System.out.println(person.getInfo()));

    }
}
