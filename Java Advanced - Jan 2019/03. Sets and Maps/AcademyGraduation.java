import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Double> studentScore = new TreeMap<>();
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfStudents; i++) {
            String studentName = scanner.nextLine();
            Double averageScore = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .average()
                    .getAsDouble();

            studentScore.put(studentName, averageScore);
        }

        for (String studentName : studentScore.keySet()) {
            System.out.println(studentName + " is graduated with " + studentScore.get(studentName));
        }
    }
}
