package WildFarm;

public abstract class Felime extends Mammal {
    public Felime(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }
    @Override
    protected void eat(Food food) {
        super.setFoodEaten(food.getQuantity()); //+this.getFoodEaten()

    }
}
