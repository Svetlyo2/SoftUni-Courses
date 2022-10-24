package VehiclesExtension;

public class Car extends Vehicle {


    public Car(double tankCapacity, double fuelQuantity, double fuelConsumption) {
        super(tankCapacity, fuelQuantity, fuelConsumption);
    }

    @Override
    public double getFuelQuantity() {
        return super.getFuelQuantity();
    }

    @Override
    protected void setFuelQuantity(double fuelQuantity) {
        super.setFuelQuantity(fuelQuantity);
    }

    @Override
    public double getFuelConsumption() {
        return super.getFuelConsumption();
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption+0.9);
    }
}
