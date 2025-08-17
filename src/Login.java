// Abstract class Account
abstract class Account {
    private String username; // encapsulated
    private String password; // encapsulated

    public Account(String username, String password) throws Exception {
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

    // Abstract login method
    public abstract void login(String username, String password) throws Exception;
}

// Subclass GoogleAccount
class GoogleAccount extends Account {
    public GoogleAccount(String username, String password) throws Exception {
        super(username, password);
    }

    @Override
    public void login(String username, String password) throws Exception {
        if (!getUsername().equals(username) || !getPassword().equals(password)) {
            throw new Exception("Google login failed: Incorrect credentials");
        }
        System.out.println("Google user " + getUsername() + " logged in successfully!");
    }
}

// Subclass FacebookAccount
class FacebookAccount extends Account {
    public FacebookAccount(String username, String password) throws Exception {
        super(username, password);
    }

    @Override
    public void login(String username, String password) throws Exception {
        if (!getUsername().equals(username) || !getPassword().equals(password)) {
            throw new Exception("Facebook login failed: Incorrect credentials");
        }
        System.out.println("Facebook user " + getUsername() + " logged in successfully!");
    }
}

// Subclass TwitterAccount
class TwitterAccount extends Account {
    public TwitterAccount(String username, String password) throws Exception {
        super(username, password);
    }

    @Override
    public void login(String username, String password) throws Exception {
        if (!getUsername().equals(username) || !getPassword().equals(password)) {
            throw new Exception("Twitter login failed: Incorrect credentials");
        }
        System.out.println("Twitter user " + getUsername() + " logged in successfully!");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            Account[] accounts = {
                    new GoogleAccount("alice@gmail.com", "google123"),
                    new FacebookAccount("bob.fb", "fbpass"),
                    new TwitterAccount("charlie.tw", "twpass")
            };

            // Polymorphic login
            accounts[0].login("alice@gmail.com", "google123"); // correct
            accounts[1].login("bob.fb", "fbpass");             // correct
            accounts[2].login("charlie.tw", "wrongpass");      // incorrect, throws exception

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

