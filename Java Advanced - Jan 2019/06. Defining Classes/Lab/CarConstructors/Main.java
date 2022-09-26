package CarConstructors;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars=Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < numberOfCars; i++) {
//            String [] carData=scanner.nextLine().split("\\s+");
//            Car current;
//            if (carData.length==3){
//                current=new Car(
//                        carData[0], carData[1], Integer.parseInt(carData[2]));
//            } else {
//                current=new Car(carData[0]);
//            }
//            System.out.println(current.getInfo());
//        }

        IntStream
                .rangeClosed(1,numberOfCars)
                .boxed()
                .map(n->scanner.nextLine().split("\\s+"))
                .map(data-> {
                    Car current;
                    if (data.length == 3) {
                        current = new Car(
                                data[0], data[1], Integer.parseInt(data[2]));
                    } else {
                        current = new Car(data[0]);
                    }
                    return current;
                })
                .forEach(car -> System.out.println(car.getInfo()));

    }
}
