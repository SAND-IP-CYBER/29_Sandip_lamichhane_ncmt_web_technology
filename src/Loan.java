// Abstract class Loan
abstract class Loan {
    private double amount; // encapsulated field

    public Loan(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Loan amount must be positive!");
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    // Abstract method to calculate interest
    public abstract double calculateInterest();
}

// Subclass HomeLoan
class HomeLoan extends Loan {
    public HomeLoan(double amount) throws Exception {
        super(amount);
    }

    @Override
    public double calculateInterest() {
        // Example: 6% interest
        return getAmount() * 0.06;
    }
}

// Subclass CarLoan
class CarLoan extends Loan {
    public CarLoan(double amount) throws Exception {
        super(amount);
    }

    @Override
    public double calculateInterest() {
        // Example: 8% interest
        return getAmount() * 0.08;
    }
}

// Subclass EducationLoan
class EducationLoan extends Loan {
    public EducationLoan(double amount) throws Exception {
        super(amount);
    }

    @Override
    public double calculateInterest() {
        // Example: 5% interest
        return getAmount() * 0.05;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            // Array of Loan references (polymorphism)
            Loan[] loans = {
                    new HomeLoan(500000),
                    new CarLoan(300000),
                    new EducationLoan(200000)
            };

            for (Loan l : loans) {
                System.out.println(l.getClass().getSimpleName() +
                        " Loan Amount: $" + l.getAmount() +
                        " | Interest: $" + l.calculateInterest());
            }

            // Invalid loan example
            Loan invalid = new CarLoan(-1000); // throws exception

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
