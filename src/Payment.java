// Abstract class Payment
abstract class Payment {
    private double amount; // Encapsulated field

    public Payment(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Amount must be positive!");
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    // Abstract method
    public abstract void processPayment() throws Exception;
}

// Subclass CreditCard
class CreditCard extends Payment {
    private String cardNumber;

    public CreditCard(double amount, String cardNumber) throws Exception {
        super(amount);
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            throw new Exception("Invalid card number!");
        }
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card payment of $" + getAmount() +
                " with card number: " + cardNumber);
    }
}

// Subclass UPI
class UPI extends Payment {
    private String upiId;

    public UPI(double amount, String upiId) throws Exception {
        super(amount);
        if (upiId == null || upiId.trim().isEmpty()) {
            throw new Exception("Invalid UPI ID!");
        }
        this.upiId = upiId;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing UPI payment of $" + getAmount() +
                " with UPI ID: " + upiId);
    }
}

// Subclass NetBanking
class NetBanking extends Payment {
    private String accountNumber;

    public NetBanking(double amount, String accountNumber) throws Exception {
        super(amount);
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new Exception("Invalid account number!");
        }
        this.accountNumber = accountNumber;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing NetBanking payment of $" + getAmount() +
                " from account: " + accountNumber);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            Payment p1 = new CreditCard(150, "1234-5678-9876-5432");
            Payment p2 = new UPI(200, "sandip@upi");
            Payment p3 = new NetBanking(300, "AC9876543210");

            // Polymorphism: process payments
            Payment[] payments = {p1, p2, p3};
            for (Payment p : payments) {
                p.processPayment();
            }

            // Invalid payment example
            Payment p4 = new CreditCard(-100, ""); // throws exception

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
