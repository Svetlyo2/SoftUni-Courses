package Тelephony;
//For judge to be out of package

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<String> inputNumbers = new ArrayList<>(Arrays.asList(input));
        input = scanner.nextLine().split("\\s+");
        List<String> inputUrls = new ArrayList<>(Arrays.asList(input));
        Smartphone smartphone = new Smartphone(inputNumbers, inputUrls);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
