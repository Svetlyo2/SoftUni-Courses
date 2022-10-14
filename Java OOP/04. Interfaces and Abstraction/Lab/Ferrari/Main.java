package Ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {
        Scanner scanner = new Scanner(System.in);
        String driverName = scanner.nextLine();
        Car ferrari = new Ferrari(driverName);
        StringBuilder builder = new StringBuilder();
        builder.append(((Ferrari) ferrari).getModel()).append("/")
                .append(ferrari.brakes()).append("/")
                .append(ferrari.gas()).append("/")
                .append(driverName);
        System.out.println(builder);

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }
    }
}
