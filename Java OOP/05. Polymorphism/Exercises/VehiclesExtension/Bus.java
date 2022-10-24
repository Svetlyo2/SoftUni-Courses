package VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle{
    private double fuelConsumptionEmpty;

    public Bus(double tankCapacity, double fuelQuantity, double fuelConsumption) {
        super(tankCapacity, fuelQuantity, fuelConsumption);
        this.setFuelConsumptionEmpty();
    }

    public double getFuelConsumptionEmpty() {
        return fuelConsumptionEmpty;
    }

    private void setFuelConsumptionEmpty() {
        this.fuelConsumptionEmpty = this.getFuelConsumption()-1.4;
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption+1.4);
    }

    public String driveEmpty(double distance){
        DecimalFormat df = new DecimalFormat("#.##");
        if (this.getFuelQuantity()>=distance*(this.getFuelConsumptionEmpty())){
            super.setFuelQuantity(this.getFuelQuantity()-distance*this.getFuelConsumptionEmpty());
            return String.format("%s travelled %s km",this.getClass().getSimpleName(),df.format(distance));
        } else return String .format("%s needs refueling",this.getClass().getSimpleName());


    }

}
