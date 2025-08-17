// Abstract class
abstract class Appliance {
    private String name;
    private boolean isOn; // encapsulated field for state

    // Constructor
    public Appliance(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Appliance name cannot be empty!");
        }
        this.name = name;
        this.isOn = false; // default state is OFF
    }

    // Getter
    public String getName() {
        return name;
    }

    public boolean getState() {
        return isOn;
    }

    // Methods to change state with validation
    protected void setState(boolean state) throws Exception {
        if (this.isOn == state) {
            throw new Exception(getName() + " is already " + (state ? "ON" : "OFF"));
        }
        this.isOn = state;
    }

    // Abstract methods
    public abstract void turnOn() throws Exception;
    public abstract void turnOff() throws Exception;
}

// Subclass Fan
class Fan extends Appliance {
    public Fan(String name) throws Exception {
        super(name);
    }

    @Override
    public void turnOn() throws Exception {
        setState(true);
        System.out.println(getName() + " Fan is now ON");
    }

    @Override
    public void turnOff() throws Exception {
        setState(false);
        System.out.println(getName() + " Fan is now OFF");
    }
}

// Subclass Light
class Light extends Appliance {
    public Light(String name) throws Exception {
        super(name);
    }

    @Override
    public void turnOn() throws Exception {
        setState(true);
        System.out.println(getName() + " Light is now ON");
    }

    @Override
    public void turnOff() throws Exception {
        setState(false);
        System.out.println(getName() + " Light is now OFF");
    }
}

// Subclass AC
class AC extends Appliance {
    public AC(String name) throws Exception {
        super(name);
    }

    @Override
    public void turnOn() throws Exception {
        setState(true);
        System.out.println(getName() + " AC is now ON");
    }

    @Override
    public void turnOff() throws Exception {
        setState(false);
        System.out.println(getName() + " AC is now OFF");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            // Array of Appliance references (polymorphism)
            Appliance[] appliances = {
                    new Fan("Ceiling"),
                    new Light("Bedroom"),
                    new AC("Living Room")
            };

            // Turn on all appliances
            for (Appliance a : appliances) {
                a.turnOn();
            }

            // Turn off all appliances
            for (Appliance a : appliances) {
                a.turnOff();
            }

            // Invalid operation (turn off again)
            appliances[0].turnOff();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

