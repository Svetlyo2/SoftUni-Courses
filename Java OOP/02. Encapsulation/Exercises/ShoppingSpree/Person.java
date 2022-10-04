package ShoppingSpree;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        boolean isNull = Optional.ofNullable(name).isPresent();
        if (name.trim().equals("") || !isNull || name.equals(" ")) {
            throw new InvalidParameterException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new InvalidParameterException("Money cannot be negative");
        }
        this.money = money;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" - ");
        if (this.products.isEmpty()) {
            builder.append("Nothing bought");
        } else {
            List<String> productsBought = new ArrayList<>();
            for (Product p : products) {
                productsBought.add(p.getName());
            }
            builder.append(String.join(", ", productsBought));
//            builder.append(String.join(", ",this.products.toString()));
        }
        return builder.toString();
    }

    public void buyProduct(Product product) {
        try {
            this.setMoney(this.money - product.getCost());
            System.out.println(this.name + " bought " + product.getName());
            this.products.add(product);
        } catch (InvalidParameterException e) {
            System.out.println(this.name + " can't afford " + product.getName());
        }
//        if (this.money>=product.getCost()){
//            this.products.add(product);
//            this.setMoney(this.money-product.getCost());
//            System.out.println(this.name+" bought "+product.getName());
//        } else {
//            System.out.println(this.name+" can't afford "+product.getName());
//        }
    }
}
