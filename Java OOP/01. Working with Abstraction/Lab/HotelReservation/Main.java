package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[]input= scanner.nextLine().split(" ");
        double pricePerDay=Double.parseDouble(input[0]);
        int numberOfDays=Integer.parseInt(input[1]);
        Season season=Season.valueOf(input[2]);
        CustomerType type=CustomerType.valueOf(input[3]);
        ReservationDetails reservation=new ReservationDetails(pricePerDay,numberOfDays,season,type);
        System.out.printf("%.2f",PriceCalculator.calculate(reservation));

    }
}
