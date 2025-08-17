// Abstract class InsurancePolicy
abstract class InsurancePolicy {
    private int age;          // encapsulated
    private double coverage;  // in dollars

    public InsurancePolicy(int age, double coverage) throws Exception {
        if (age <= 0) {
            throw new Exception("Age must be positive!");
        }
        if (coverage <= 0) {
            throw new Exception("Coverage must be positive!");
        }
        this.age = age;
        this.coverage = coverage;
    }

    public int getAge() {
        return age;
    }

    public double getCoverage() {
        return coverage;
    }

    // Abstract method to calculate premium
    public abstract double calculatePremium();
}

// Subclass HealthInsurance
class HealthInsurance extends InsurancePolicy {
    public HealthInsurance(int age, double coverage) throws Exception {
        super(age, coverage);
    }

    @Override
    public double calculatePremium() {
        // Example: 5% of coverage + $2 per year of age
        return getCoverage() * 0.05 + getAge() * 2;
    }
}

// Subclass LifeInsurance
class LifeInsurance extends InsurancePolicy {
    public LifeInsurance(int age, double coverage) throws Exception {
        super(age, coverage);
    }

    @Override
    public double calculatePremium() {
        // Example: 3% of coverage + $1.5 per year of age
        return getCoverage() * 0.03 + getAge() * 1.5;
    }
}

// Subclass TravelInsurance
class TravelInsurance extends InsurancePolicy {
    public TravelInsurance(int age, double coverage) throws Exception {
        super(age, coverage);
    }

    @Override
    public double calculatePremium() {
        // Example: 2% of coverage + $1 per year of age
        return getCoverage() * 0.02 + getAge() * 1;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            InsurancePolicy[] policies = {
                    new HealthInsurance(30, 10000),
                    new LifeInsurance(40, 20000),
                    new TravelInsurance(25, 5000)
            };

            // Polymorphism: calculate premium for all
            for (InsurancePolicy p : policies) {
                System.out.println(p.getClass().getSimpleName() +
                        " premium for age " + p.getAge() +
                        " and coverage $" + p.getCoverage() +
                        " is $" + p.calculatePremium());
            }

            // Invalid case
            InsurancePolicy invalid = new LifeInsurance(-5, 10000); // throws exception

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

