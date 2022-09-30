package SortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
        }
        people.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparingInt(Person::getAge))
                .forEach(System.out::println);

//        Collections.sort(people,(f,s)->{
//            int compare = f.getFirstName().compareTo(s.getFirstName());
//            if (compare == 0){
//                compare = f.getAge().compareTo(s.getAge());
//            }
//            return compare;
//        });

//        for (SortByNameAndAge.Person person : people) {
//            System.out.println(person.toString());
//        }
    }
}
