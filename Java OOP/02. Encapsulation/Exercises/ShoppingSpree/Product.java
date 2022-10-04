package ShoppingSpree;

import java.security.InvalidParameterException;
import java.util.Optional;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        boolean isNull = Optional.ofNullable(name).isPresent();
        if (name.equals("") || !isNull || name.equals(" ")) {
            throw new InvalidParameterException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new InvalidParameterException("Money cannot be negative");
        }
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
