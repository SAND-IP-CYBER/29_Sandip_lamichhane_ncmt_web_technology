// Base class Employee
abstract class Employee {
    private String name;    // encapsulated
    private double salary;  // encapsulated

    public Employee(String name, double salary) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Name cannot be empty!");
        }
        if (salary < 0) {
            throw new Exception("Salary cannot be negative!");
        }
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Abstract method for bonus
    public abstract double calculateBonus();
}

// Subclass PermanentEmployee
class PermanentEmployee extends Employee {
    public PermanentEmployee(String name, double salary) throws Exception {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        // 10% of salary as bonus
        return getSalary() * 0.10;
    }
}

// Subclass ContractEmployee
class ContractEmployee extends Employee {
    public ContractEmployee(String name, double salary) throws Exception {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        // 5% of salary as bonus
        return getSalary() * 0.05;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            Employee e1 = new PermanentEmployee("Alice", 50000);
            Employee e2 = new ContractEmployee("Bob", 30000);

            // Polymorphism
            Employee[] employees = {e1, e2};
            for (Employee e : employees) {
                System.out.println(e.getName() + " has bonus: $" + e.calculateBonus());
            }

            // Invalid case
            Employee invalid = new PermanentEmployee("Charlie", -1000); // throws exception

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
