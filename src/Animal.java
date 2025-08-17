// Abstract class
abstract class Animal {
    private String name;  // encapsulated field

    // Constructor
    public Animal(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Invalid Animal Name!");
        }
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Abstract method
    public abstract void makeSound();
}

// Subclass Dog
class Dog extends Animal {
    public Dog(String name) throws Exception {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof Woof!");
    }
}

// Subclass Cat
class Cat extends Animal {
    public Cat(String name) throws Exception {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow Meow!");
    }
}

// Subclass Cow
class Cow extends Animal {
    public Cow(String name) throws Exception {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Moo Moo!");
    }
}

// Main class to demonstrate Polymorphism
public class Main {
    // Method that uses polymorphism
    public static void animalSound(Animal animal) {
        animal.makeSound(); // calls the correct overridden method
    }

    public static void main(String[] args) {
        try {
            Animal dog = new Dog("Tommy");
            Animal cat = new Cat("Kitty");
            Animal cow = new Cow("Gauri");

            // Polymorphism in action
            animalSound(dog);
            animalSound(cat);
            animalSound(cow);

            // Trying invalid case
            Animal invalid = new Dog(""); // will throw exception

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
