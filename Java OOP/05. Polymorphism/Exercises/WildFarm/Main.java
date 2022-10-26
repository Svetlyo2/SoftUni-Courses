package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} [{CatBreed} = Only if its cat]
        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();
        while (!"End".equals(line)) {
            String[] animalInfo = line.split("\\s+");
            String animalType = animalInfo[0];
            String animalName = animalInfo[1];
            double weight = Double.parseDouble(animalInfo[2]);
            String region = animalInfo[3];
            Animal currentAnimal = null;
            if (animalType.equals("Cat")) {
                currentAnimal = new Cat(animalName, animalType, weight, region, animalInfo[4]);
            } else if (animalType.equals("Tiger")) {
                currentAnimal = new Tiger(animalName, animalType, weight, region);
            } else if (animalType.equals("Zebra")) {
                currentAnimal = new Zebra(animalName, animalType, weight, region);
            } else {
                currentAnimal = new Mouse(animalName, animalType, weight, region);
            }
            animals.add(currentAnimal);
            line = scanner.nextLine();
            String[] foodInfo = line.split("\\s+");
            Food currentFood = null;
            //currentAnimal.makeSound();
            if (foodInfo[0].equals("Vegetable")) {
                currentFood = new Vegetable(Integer.parseInt(foodInfo[1]));
            } else {
                currentFood = new Meat(Integer.parseInt(foodInfo[1]));
            }
            foods.add(currentFood);
            line = scanner.nextLine();
        }
        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).makeSound();
            animals.get(i).eat(foods.get(i));
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
