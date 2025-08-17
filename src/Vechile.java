// Superclass Vehicle
class Vehicle {
    private String brand;
    private int speed;

    public Vehicle(String brand, int speed) throws Exception {
        if (brand == null || brand.isEmpty()) {
            throw new Exception("Brand cannot be empty!");
        }
        if (speed < 0) {
            throw new Exception("Speed cannot be negative!");
        }
        this.brand = brand;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Speed: " + speed + " km/h");
    }
}

// Car subclass
class Car extends Vehicle {
    public Car(String brand, int speed) throws Exception {
        super(brand, speed);
    }
}

// Bike subclass
class Bike extends Vehicle {
    public Bike(String brand, int speed) throws Exception {
        super(brand, speed);
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        try {
            Vehicle v1 = new Car("Toyota", 120);
            Vehicle v2 = new Bike("Yamaha", 80);

            v1.displayInfo();
            v2.displayInfo();

            // Invalid example
            Vehicle v3 = new Bike("Honda", -50);
            v3.displayInfo();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
