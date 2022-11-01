package HarvestingFields;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Field[] fields = RichSoilLand.class.getDeclaredFields();
        Consumer<Field> printer = f -> System.out.printf("%s %s %s%n", Modifier.toString(f.getModifiers()),
                f.getType().getSimpleName(), f.getName());
        while (!input.equalsIgnoreCase("harvest")) {
            String finalInput = input;

            Field[] requestedFields = Arrays.stream(fields)
                    .filter(f -> Modifier.toString(f.getModifiers()).equalsIgnoreCase(finalInput))
                    .toArray(Field[]::new);

            if (requestedFields.length != 0) {
                Arrays.stream(requestedFields).forEach(printer);
            } else {
                Arrays.stream(fields).forEach(printer);
            }
            input = scanner.nextLine();
        }
    }
}
