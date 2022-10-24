package VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(input[3]), Double.parseDouble(input[1]), Double.parseDouble(input[2]));
        input = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(input[3]), Double.parseDouble(input[1]), Double.parseDouble(input[2]));
        input = scanner.nextLine().split("\\s+");
        Vehicle bus = new Bus(Double.parseDouble(input[3]), Double.parseDouble(input[1]), Double.parseDouble(input[2]));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            input = scanner.nextLine().split("\\s+");
            double distanceRefuel = Double.parseDouble(input[2]);
            if (input[0].equals("Drive")) {
                if (input[1].equals("Car")) {
                    System.out.println(car.driveDistance(distanceRefuel));
                } else if (input[1].equals("Truck")) {
                    System.out.println(truck.driveDistance(distanceRefuel));
                } else System.out.println(bus.driveDistance(distanceRefuel));

            } else if (input[0].equals("Refuel")) {
                if (distanceRefuel <= 0) {
                    System.out.println("Fuel must be a positive number");
                    continue;
                }
                if (input[1].equals("Car")) {
                    car.refuel(distanceRefuel);
                } else if (input[1].equals("Truck")) {
                    truck.refuel(distanceRefuel);
                } else bus.refuel(distanceRefuel);

            } else {
                System.out.println(((Bus) bus).driveEmpty(distanceRefuel));
            }
        }
        System.out.printf("Car: %.2f%n", (Math.round(car.getFuelQuantity() * 100.0) / 100.0));
        System.out.printf("Truck: %.2f%n", (Math.round(truck.getFuelQuantity() * 100.0) / 100.0));
        System.out.printf("Bus: %.2f%n", (Math.round(bus.getFuelQuantity() * 100.0) / 100.0));

    }
}
