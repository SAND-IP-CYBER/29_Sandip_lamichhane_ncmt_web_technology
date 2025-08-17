// Base abstract class Transport
abstract class Transport {
    private double distance; // encapsulated field for distance in km

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
        return getDistance() * 2; // $2 per km
    }
}

// Subclass Train
class Train extends Transport {
    public Train(double distance) throws Exception {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() * 1.5; // $1.5 per km
    }
}

// Subclass Taxi
class Taxi extends Transport {
    public Taxi(double distance) throws Exception {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() * 3; // $3 per km
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            // Array of Transport references (polymorphism)
            Transport[] transports = {
                    new Bus(10),
                    new Train(15),
                    new Taxi(8)
            };

            for (Transport t : transports) {
                System.out.println(t.getClass().getSimpleName() +
                        " fare for " + t.getDistance() + " km: $" +
                        t.calculateFare());
            }

            // Invalid distance example
            Transport invalid = new Bus(-5); // throws exception

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
