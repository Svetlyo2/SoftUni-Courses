package CarSalesman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Car car = null;
        Engine engine = null;
        Map<String, Engine> enginesByModel = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] engineData = scanner.nextLine().split("\\s+");
            if (engineData.length == 2) {
                engine = new Engine(engineData[0], engineData[1]);
            } else if (engineData.length == 3) {
                if (isInteger(engineData[2])) {
                    engine = new Engine(engineData[0], engineData[1], engineData[2], "n/a");
                } else {
                    engine = new Engine(engineData[0], engineData[1], "n/a", engineData[2]);
                }
            } else if (engineData.length == 4) {
                engine = new Engine(engineData[0], engineData[1], engineData[2], engineData[3]);
            }
            enginesByModel.put(engineData[0], engine);
            //System.out.println(enginesByModel.get(engineData[0]));
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int j = 0; j < m; j++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String currentEngineModel = carData[1];
            Engine currentEngine = enginesByModel.get(currentEngineModel);

            if (carData.length == 2) {
                car = new Car(carData[0], currentEngine);
            } else if (carData.length == 3) {
                if (isInteger(carData[2])) {
                    car = new Car(carData[0], currentEngine, carData[2], "n/a");
                } else {
                    car = new Car(carData[0], currentEngine, "n/a", carData[2]);
                }
            } else if (carData.length == 4) {
                car = new Car(carData[0], currentEngine, carData[2], carData[3]);
            }
            System.out.println(car);
        }
    }


    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        if (str.isEmpty()) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
