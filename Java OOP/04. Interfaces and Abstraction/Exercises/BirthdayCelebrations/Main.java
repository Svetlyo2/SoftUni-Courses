package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Birthable> birthables = new ArrayList<>();
        while (!"End".equals(line)) {
            String[] data = line.split("\\s+");
            String subject = data[0];
            if ("Citizen".equals(subject)) {
                Citizen citizen = new Citizen(data[1], Integer.parseInt(data[2]),
                        data[3], data[4]);
                birthables.add(citizen);
            } else if ("Pet".equals(subject)) {
                Pet pet = new Pet(data[1], data[2]);
                birthables.add(pet);
            }
            line = scanner.nextLine();
        }
        String selectedYear = scanner.nextLine();
//        for (Birthable birthable : birthables) {
//            if (birthable.getBirthDate().endsWith(selectedYear)){
//                System.out.println(birthable.getBirthDate());
//            }
//        }
        birthables.stream().filter(b -> b.getBirthDate().endsWith(selectedYear))
                .forEach(b -> System.out.println(b.getBirthDate()));
    }
}
