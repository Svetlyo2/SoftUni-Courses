import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, List<Double>> record = new TreeMap<>();

        int gradesCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < gradesCount; i++) {
            String[] parts = scanner.nextLine().split(" ");
            String name = parts[0];
            double grade = Double.parseDouble(parts[1]);

            List<Double> currentGrades = new ArrayList<>();

            if(record.containsKey(name)) {
                currentGrades = record.get(name);
            }

            currentGrades.add(grade);
            record.put(name, currentGrades);
        }

        for (String studentName : record.keySet()) {
            System.out.print(studentName + " -> ");
            double gradeSum = 0;
            List<Double> studentGrades = record.get(studentName);
            for (Double grade : studentGrades) {
                gradeSum += grade;
                System.out.printf("%.2f ", grade);
            }

            System.out.printf("(avg: %.2f)\n", gradeSum / studentGrades.size());
        }
    }
}
