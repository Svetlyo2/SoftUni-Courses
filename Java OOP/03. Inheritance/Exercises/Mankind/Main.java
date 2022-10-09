package Mankind;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        try {
            Student student = new Student(input[0], input[1], input[2]);
            input = scanner.nextLine().split("\\s+");
            Worker worker = new Worker(input[0], input[1], Double.parseDouble(input[2]), Double.parseDouble(input[3]));
            System.out.println(student.toString());
            System.out.println(worker.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
