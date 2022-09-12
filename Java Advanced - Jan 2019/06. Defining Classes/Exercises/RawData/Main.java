package RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Car car;
        Engine engine;
        Cargo cargo;
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String model = line[0];
            engine = new Engine(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
            cargo = new Cargo(Integer.parseInt(line[3]), line[4]);
            Tire[] tires = new Tire[4];
            tires[0] = new Tire(Double.parseDouble(line[5]), Integer.parseInt(line[6]));
            tires[1] = new Tire(Double.parseDouble(line[7]), Integer.parseInt(line[8]));
            tires[2] = new Tire(Double.parseDouble(line[9]), Integer.parseInt(line[10]));
            tires[3] = new Tire(Double.parseDouble(line[11]), Integer.parseInt(line[12]));
            car = new Car(model, engine, cargo, tires);
            cars.add(car);
            //System.out.println(car.getModel());
        }

        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            cars.stream()
                    .filter(c -> c.getCargo().getCargoType().equals("fragile"))
                    .filter(c -> Arrays.stream(c.getTires()).anyMatch(t -> t.getPressure() < 1))
                    .forEach(System.out::println);

        } else {
            cars.stream()
                    .filter(c -> c.getCargo().getCargoType().equals("flamable"))
                    .filter(p -> p.getEngine().getEnginePower() > 250).forEach(System.out::println);
        }
    }
}
