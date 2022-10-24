package VehiclesExtension;

public class Truck extends Vehicle {
    public Truck(double tankCapacity,double fuelQuantity, double fuelConsumption) {
        super(tankCapacity,fuelQuantity, fuelConsumption);
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
        super.setFuelConsumption(fuelConsumption+1.6);
    }

    @Override
    public void refuel(double fuelLiters) {
        super.refuel(fuelLiters*0.95);
    }
}
