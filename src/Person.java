// Abstract class Person
abstract class Person {
    private String name;
    private int age;

    // Constructor with validation
    public Person(String name, int age) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("Name cannot be empty!");
        }
        if (age <= 0) {
            throw new Exception("Age must be positive!");
        }
        this.name = name;
        this.age = age;
    }

    // Getters (Encapsulation)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Abstract method
    public abstract void showRole();
}

// Doctor class
class Doctor extends Person {
    public Doctor(String name, int age) throws Exception {
        super(name, age);
    }

    @Override
    public void showRole() {
        System.out.println(getName() + " (Doctor, Age " + getAge() + ")");
    }
}

// Patient class
class Patient extends Person {
    public Patient(String name, int age) throws Exception {
        super(name, age);
    }

    @Override
    public void showRole() {
        System.out.println(getName() + " (Patient, Age " + getAge() + ")");
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        try {
            Person p1 = new Doctor("Dr. Smith", 45);
            Person p2 = new Patient("John Doe", 30);

            p1.showRole();
            p2.showRole();

            // Invalid data example
            Person p3 = new Patient("", -5); // will throw exception
            p3.showRole();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

