package AnimalFarm;

import java.util.Optional;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        boolean isNull = Optional.ofNullable(name).isPresent();
        if (name.equals("") || !isNull || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private double calculateProductPerDay() {
        double dailyProduct = 0.0;
        if (this.age >= 0 && this.age < 6) {
            dailyProduct = 2;
        } else if (this.age < 12) {
            dailyProduct = 1;
        } else {
            dailyProduct = 0.75;
        }
        return dailyProduct;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
