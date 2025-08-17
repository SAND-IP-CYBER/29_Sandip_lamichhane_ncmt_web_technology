// Base class Transport
abstract class Transport {
    private double distance; // in km

    public Transport(double distance) throws Exception {
        if (distance <= 0) {
            throw new Exception("Distance must be positive!");
        }
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    // Abstract method to calculate fare
    public abstract double calculateFare();
}

// Subclass Bus
class Bus extends Transport {
    public Bus(double distance) throws Exception {
        super(distance);
    }

    @Override
    public double calculateFare() {
        // Example: $2 per km
        return getDistance() * 2;
    }
}

// Subclass Train
class Train extends Transport {
    public Train(double distance) throws Exception {
        super(distance);
    }

    @Override
    public double calculateFare() {
        // Example: $1.5 per km
        return getDistance() * 1.5;
    }
}

// Subclass Taxi
class Taxi extends Transport {
    public Taxi(double distance) throws Exception {
        super(distance);
    }

    @Override
    public double calculateFare() {
        // Example: $3 per km
        return getDistance() * 3;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            Transport[] transports = {
                new Bus(10),
                new Train(15),
                new Taxi(8)
            };

            for (Transport t : transports) {
                System.out.println(t.getClass().getSimpleName() +
                                   " fare for " + t.getDistance() + " km: $" + t.calculateFare());
            }

            // Invalid case
            Transport invalid = new Taxi(-5); // throws exception

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
