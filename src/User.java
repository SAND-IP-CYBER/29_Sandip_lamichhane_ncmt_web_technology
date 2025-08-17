// Abstract class User
abstract class User {
    private String username; // encapsulated
    private String password; // encapsulated

    public User(String username, String password) throws Exception {
        if (username == null || username.trim().isEmpty()) {
            throw new Exception("Username cannot be empty!");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new Exception("Password cannot be empty!");
        }
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Abstract method for login
    public abstract void login(String username, String password) throws Exception;
}

// Subclass Admin
class Admin extends User {
    public Admin(String username, String password) throws Exception {
        super(username, password);
    }

    @Override
    public void login(String username, String password) throws Exception {
        if (!getUsername().equals(username) || !getPassword().equals(password)) {
            throw new Exception("Admin login failed: Incorrect credentials");
        }
        System.out.println("Admin " + getUsername() + " logged in successfully!");
    }
}

// Subclass Editor
class Editor extends User {
    public Editor(String username, String password) throws Exception {
        super(username, password);
    }

    @Override
    public void login(String username, String password) throws Exception {
        if (!getUsername().equals(username) || !getPassword().equals(password)) {
            throw new Exception("Editor login failed: Incorrect credentials");
        }
        System.out.println("Editor " + getUsername() + " logged in successfully!");
    }
}

// Subclass Viewer
class Viewer extends User {
    public Viewer(String username, String password) throws Exception {
        super(username, password);
    }

    @Override
    public void login(String username, String password) throws Exception {
        if (!getUsername().equals(username) || !getPassword().equals(password)) {
            throw new Exception("Viewer login failed: Incorrect credentials");
        }
        System.out.println("Viewer " + getUsername() + " logged in successfully!");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            User[] users = {
                    new Admin("admin1", "admin123"),
                    new Editor("editor1", "edit123"),
                    new Viewer("viewer1", "view123")
            };

            // Polymorphic login
            users[0].login("admin1", "admin123");   // correct
            users[1].login("editor1", "edit123");   // correct
            users[2].login("viewer1", "wrongpass"); // incorrect, will throw exception

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

