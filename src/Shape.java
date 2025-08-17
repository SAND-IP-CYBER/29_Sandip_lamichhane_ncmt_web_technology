abstract class Shape {
    // Abstract method
    public abstract double calculateArea();
}

// Circle class
class Circle extends Shape {
    private double radius;

    public Circle(double radius) throws Exception {
        if (radius <= 0) {
            throw new Exception("Radius must be positive!");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Rectangle class
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) throws Exception {
        if (length <= 0 || width <= 0) {
            throw new Exception("Length and Width must be positive!");
        }
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
// Main class to test
public class Main {
    public static void main(String[] args) {
        try {
            Shape circle = new Circle(5);
            Shape rectangle = new Rectangle(4, 6);

            System.out.println("Circle area: " + circle.calculateArea());
            System.out.println("Rectangle area: " + rectangle.calculateArea());

            // Example of invalid input
            Shape badCircle = new Circle(-3);
            System.out.println("Bad Circle area: " + badCircle.calculateArea());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
