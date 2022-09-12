package RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire [] tires;

    public Car(String model) {
        this.model = model;
    }

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this(model);
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }
    @Override
    public String toString() {
        return this.getModel();
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Tire[] getTires() {
        return this.tires;
    }
}
