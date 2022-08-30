import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        HashSet<String> carsIn = new HashSet<String>();

        while (!line.equals("END")) {
            String[] input = line.split(", ");
            String direction = input[0];
            String carNumber = input[1];
            if (direction.equals("IN")) {
                carsIn.add(carNumber);
            } else {
                carsIn.remove(carNumber);
            }
            line = scanner.nextLine();
        }
        if (carsIn.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : carsIn) {
                System.out.println(car);
            }
        }
    }
}
