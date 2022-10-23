package Animals;

public class Cat extends Animal {

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favorite food is %s%nMEEOW",
                this.getName(),this.getFavoriteFood());
        //        return String .format("%s%nMEEOW",super.explainSelf());
    }
}
