package CarSalesman;

public class Engine {
    private String engineModel;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String engineModel, String power) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public Engine(String engineModel, String power, String displacement, String efficiency) {
        this(engineModel, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    public String getPower() {
        return this.power;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("  " + this.getEngineModel()+ ":" + "\n")
                .append("    Power: " + this.getPower() + "\n")
                .append("    Displacement: " + this.getDisplacement() + "\n")
                .append("    Efficiency: " + this.getEfficiency());

        return builder.toString();
    }
}
