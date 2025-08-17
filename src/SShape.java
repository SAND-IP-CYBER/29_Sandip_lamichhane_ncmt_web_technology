// Abstract base class
abstract class Shape {
    private String name; // encapsulated field

    // Constructor
    public Shape(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Shape name cannot be empty!");
        }
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Abstract method
    public abstract void draw();
}

// Subclass Circle
class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) throws Exception {
        super(name);
        if (radius <= 0) {
            throw new Exception("Radius must be greater than 0!");
        }
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + getName() + " with radius " + radius);
    }
}

// Subclass Square
class Square extends Shape {
    private double side;

    public Square(String name, double side) throws Exception {
        super(name);
        if (side <= 0) {
            throw new Exception("Side length must be greater than 0!");
        }
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + getName() + " with side " + side);
    }
}

// Subclass Triangle
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String name, double base, double height) throws Exception {
        super(name);
        if (base <= 0 || height <= 0) {
            throw new Exception("Base and height must be greater than 0!");
        }
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + getName() + " with base " + base + " and height " + height);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            // Polymorphism: Array of Shape references
            Shape[] shapes = {
                    new Circle("Circle1", 5),
                    new Square("Square1", 4),
                    new Triangle("Triangle1", 6, 3)
            };

            // Draw all shapes
            for (Shape s : shapes) {
                s.draw(); // Polymorphic call
            }

            // Invalid case (exception)
            Shape invalid = new Circle("InvalidCircle", -2);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
