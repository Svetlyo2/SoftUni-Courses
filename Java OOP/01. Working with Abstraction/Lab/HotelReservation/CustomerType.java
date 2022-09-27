package HotelReservation;

public enum CustomerType {
    None(0),
    SecondVisit(10),
    VIP(20);

    private int discount;

    CustomerType(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }
}
