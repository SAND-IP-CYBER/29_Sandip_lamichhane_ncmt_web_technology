// Abstract class Character
abstract class Character {
    private String name;   // encapsulated
    private int health;    // health points
    private String weapon; // weapon type

    public Character(String name, int health, String weapon) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Name cannot be empty!");
        }
        if (health <= 0) {
            throw new Exception("Health must be positive!");
        }
        if (weapon == null || weapon.trim().isEmpty()) {
            throw new Exception("Weapon cannot be empty!");
        }
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getWeapon() {
        return weapon;
    }

    // Abstract method
    public abstract void attack();
}

// Subclass Warrior
class Warrior extends Character {
    public Warrior(String name, int health, String weapon) throws Exception {
        super(name, health, weapon);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " (Warrior) attacks with " + getWeapon() + " dealing heavy damage!");
    }
}

// Subclass Mage
class Mage extends Character {
    public Mage(String name, int health, String weapon) throws Exception {
        super(name, health, weapon);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " (Mage) casts a spell using " + getWeapon() + "!");
    }
}

// Subclass Archer
class Archer extends Character {
    public Archer(String name, int health, String weapon) throws Exception {
        super(name, health, weapon);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " (Archer) shoots an arrow with " + getWeapon() + "!");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            Character[] characters = {
                    new Warrior("Thorin", 100, "Sword"),
                    new Mage("Gandalf", 80, "Staff"),
                    new Archer("Legolas", 90, "Bow")
            };

            // Polymorphic attacks
            for (Character c : characters) {
                c.attack();
            }

            // Invalid character
            Character invalid = new Warrior("BadGuy", -50, "Axe"); // throws exception

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
