package carInfo;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        IntStream
                .rangeClosed(1, numberOfCars)
                .boxed()
                .map(n -> scanner.nextLine().split("\\s+"))
                .map(data -> {
                    Car current = new Car();
                    current.setMake(data[0]);
                    current.setModel(data[1]);
                    current.setHorsePower(Integer.parseInt(data[2]));
                    return current;
                })
                .forEach(car -> System.out.println(car.getInfo()));

//        for (int i = 0; i < numberOfCars; i++) {
//            String [] cars=scanner.nextLine().split("\\s+");
//            Car car=new Car();
//            car.setMake(cars[0]);
//            car.setModel(cars[1]);
//            car.setHorsePower(Integer.parseInt(cars[2]));
//            System.out.println(car.getInfo());
//        }

//        car.setMake("Chevrolet");
//        car.setModel("Impala");
//        car.setHorsePower(390);
    }
}

