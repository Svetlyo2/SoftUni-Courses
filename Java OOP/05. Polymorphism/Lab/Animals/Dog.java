package Animals;

public class Dog extends Animal{

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favorite food is %s%nDJAAF",
                this.getName(),this.getFavoriteFood());
//        return String .format("%s%nDJAAF",super.explainSelf());
    }
}
