// Abstract Employee class
abstract class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("Name cannot be empty!");
        }
        if (baseSalary <= 0) {
            throw new Exception("Base salary must be positive!");
        }
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Abstract method for salary calculation
    public abstract double calculateSalary();
}

// Manager class
class Manager extends Employee {
    public Manager(String name, double baseSalary) throws Exception {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        // Manager gets 30% bonus
        return getBaseSalary() + (0.3 * getBaseSalary());
    }
}

// Developer class
class Developer extends Employee {
    public Developer(String name, double baseSalary) throws Exception {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        // Developer gets 20% bonus
        return getBaseSalary() + (0.2 * getBaseSalary());
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        try {
            Employee e1 = new Manager("Alice", 50000);
            Employee e2 = new Developer("Bob", 40000);

            System.out.println(e1.getName() + "'s Salary: " + e1.calculateSalary());
            System.out.println(e2.getName() + "'s Salary: " + e2.calculateSalary());

            // Example of invalid input
            Employee e3 = new Developer("Tom", -20000);
            System.out.println(e3.getName() + "'s Salary: " + e3.calculateSalary());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
