package CompanyRoster;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> departments = new HashMap<>();
        Employee employee;

        while (n-- > 0) {
            String[] current = scanner.nextLine().split("\\s+");
            String departmentName = current[3];

            switch (current.length) {
                case 4:
                    employee = new Employee(current[0], Double.parseDouble(current[1]));
                    break;
                case 5:
                    if (current[4].contains("@")) {
                        employee = new Employee(current[0], Double.parseDouble(current[1]), current[4]);
                    } else {
                        employee = new Employee(current[0], Double.parseDouble(current[1]), Integer.parseInt(current[4]));
                    }
                    break;
                default:
                    employee = new Employee(current[0], Double.parseDouble(current[1]), current[4], Integer.parseInt(current[5]));
                    break;
            }

            if (!departments.containsKey(departmentName)) {
                departments.put(departmentName, new Department(departmentName));
            }
            departments.get(departmentName).getEmployees().add(employee);
        }
        departments.entrySet().stream()
                .sorted((f, s) -> Double.compare(s.getValue().getAverageSalary(), f.getValue().getAverageSalary()))
                .findFirst()
                .stream()
                .forEach(e -> {
                    System.out.println("Highest Average Salary: " + e.getKey());
                    e.getValue().getEmployees().stream()
                            .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                            .forEach(employee1 -> System.out.println(employee1.getInfo()));
                });
    }
}
