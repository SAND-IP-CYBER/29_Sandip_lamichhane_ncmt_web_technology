// Calculator class
class Calculator {
    private double num1;
    private double num2;

    // Constructor
    public Calculator(double num1, double num2) throws Exception {
        if (Double.isNaN(num1) || Double.isNaN(num2)) {
            throw new Exception("Invalid input: Numbers cannot be NaN");
        }
        this.num1 = num1;
        this.num2 = num2;
    }

    // Getters (Encapsulation)
    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    // Overloaded Add methods
    public double add() {
        return num1 + num2;
    }
    public double add(double a, double b) {
        return a + b;
    }

    // Overloaded Subtract methods
    public double subtract() {
        return num1 - num2;
    }
    public double subtract(double a, double b) {
        return a - b;
    }

    // Overloaded Multiply methods
    public double multiply() {
        return num1 * num2;
    }
    public double multiply(double a, double b) {
        return a * b;
    }

    // Overloaded Divide methods (with exception handling)
    public double divide() throws Exception {
        if (num2 == 0) {
            throw new Exception("Division by zero is not allowed!");
        }
        return num1 / num2;
    }
    public double divide(double a, double b) throws Exception {
        if (b == 0) {
            throw new Exception("Division by zero is not allowed!");
        }
        return a / b;
    }
}

// Main class to test Calculator
public class Main {
    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator(20, 5);

            System.out.println("Add: " + calc.add());
            System.out.println("Subtract: " + calc.subtract());
            System.out.println("Multiply: " + calc.multiply());
            System.out.println("Divide: " + calc.divide());

            // Using overloaded methods with custom values
            System.out.println("Add (custom): " + calc.add(10, 15));
            System.out.println("Divide (custom): " + calc.divide(10, 0)); // will throw exception

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
