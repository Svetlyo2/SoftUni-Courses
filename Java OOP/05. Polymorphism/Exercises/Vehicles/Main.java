package Vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(input[1]), Double.parseDouble(input[2]));
        input = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(input[1]), Double.parseDouble(input[2]));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            input = scanner.nextLine().split("\\s+");
            double distanceRefuel = Double.parseDouble(input[2]);
            if (input[0].equals("Drive")) {
                if (input[1].equals("Car")) {
                    System.out.println(car.driveDistance(distanceRefuel));
                } else System.out.println(truck.driveDistance(distanceRefuel));
            } else {
                if (input[1].equals("Car")) {
                    car.refuel(distanceRefuel);
                } else truck.refuel(distanceRefuel);
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
