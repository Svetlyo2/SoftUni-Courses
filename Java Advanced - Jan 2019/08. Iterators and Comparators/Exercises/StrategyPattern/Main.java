package StrategyPattern;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        Set<StrategyPattern.Person> nameSet = new TreeSet <>(new PersonNameComparator());
        Set<StrategyPattern.Person> ageSet = new TreeSet <>(new PersonAgeComparator());

        for (int i = 0; i < count; i++) {
            String[] personArgs = reader.readLine().split(" ");
            StrategyPattern.Person person = new StrategyPattern.Person(personArgs[0], Integer.parseInt(personArgs[1]));
            nameSet.add(person);
            ageSet.add(person);
        }

        nameSet.forEach(System.out::println);
        ageSet.forEach(System.out::println);
    }
}
