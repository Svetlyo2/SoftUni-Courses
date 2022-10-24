package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String driveDistance(double distance) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (fuelQuantity >= distance * this.getFuelConsumption()) {
            this.fuelQuantity -= distance * this.getFuelConsumption();
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
        } else return String.format("%s needs refueling", this.getClass().getSimpleName());
    }

    public void refuel(double fuelLiters) {
        this.fuelQuantity += fuelLiters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
