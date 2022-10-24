package VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double tankCapacity;
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double tankCapacity, double fuelQuantity, double fuelConsumption) {
        this.setTankCapacity(tankCapacity);
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity > this.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        if (tankCapacity < 0) {
            System.out.println("Fuel must be a positive number");
        } else this.tankCapacity = tankCapacity;
    }

    public String driveDistance(double distance) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (this.getFuelQuantity() >= distance * this.getFuelConsumption()) {
            this.setFuelQuantity(this.getFuelQuantity() - distance * this.getFuelConsumption());
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
        } else return String.format("%s needs refueling", this.getClass().getSimpleName());

    }

    public void refuel(double fuelLiters) {
        if (this.getFuelQuantity() + fuelLiters > this.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += fuelLiters;
        }
    }

    ;
}
