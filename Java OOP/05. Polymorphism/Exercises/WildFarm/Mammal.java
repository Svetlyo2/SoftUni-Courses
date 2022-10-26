package WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    protected void eat(Food food) {
        String animalType = this.getClass().getSimpleName().equals("Mouse") ?
                "Mice" : "Zebras";
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            super.setFoodEaten(food.getQuantity()); //+this.getFoodEaten()
        } else {
            System.out.println(animalType + " are not eating that type of food!");
        }
    }

    //{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName(),
                df.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
