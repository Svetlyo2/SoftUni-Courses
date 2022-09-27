package HotelReservation;

public class PriceCalculator {
    public static double calculate(ReservationDetails details) {
        double price = details.getPricePerDay() * details.getNumberOfDays();
        price=price*details.getSeason().getValue();
        double discountMultiplier =(details.getType().getDiscount());
        //double discontAmount=price*discountMultiplier/100;
        price=price-price*discountMultiplier/100;
        return price;
    }
}
