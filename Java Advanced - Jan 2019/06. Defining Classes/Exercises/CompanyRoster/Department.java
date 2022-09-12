package CompanyRoster;


import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Employee> employees;

    public String getName() {
        return this.name;
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    //Double has more options in lambda than double
    public Double getAverageSalary() {
        return this.employees.stream().mapToDouble(e -> e.getSalary())
                .average()
                .getAsDouble();
    }
}

