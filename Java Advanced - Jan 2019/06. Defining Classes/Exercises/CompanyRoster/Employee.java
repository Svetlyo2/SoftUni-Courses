package CompanyRoster;

public class Employee {
    private static final String EMAIL_DEF = "n/a";
    private static final int AGE_DEF = -1;

    private String name;
    private double salary;
    private String email;
    private int age;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.email = EMAIL_DEF;
        this.age = AGE_DEF;
    }

    public Employee(String name, double salary, String email) {
        this(name, salary);
        this.email = email;
    }

    public Employee(String name, double salary, int age) {
        this(name, salary);
        this.age = age;
    }

    public Employee(String name, double salary, String email, int age) {
        this(name, salary, age);
        this.email = email;
    }

    public double getSalary() {
        return this.salary;
    }

    //Ivan 840.20 ivan@ivan.com -1
    public String getInfo() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
