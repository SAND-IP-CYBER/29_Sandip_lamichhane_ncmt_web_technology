// Abstract class Notification
abstract class Notification {
    private String recipient; // encapsulated

    public Notification(String recipient) throws Exception {
        if (recipient == null || recipient.trim().isEmpty()) {
            throw new Exception("Recipient cannot be empty!");
        }
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    // Abstract method
    public abstract void send() throws Exception;
}

// Subclass EmailNotification
class EmailNotification extends Notification {
    private String subject;

    public EmailNotification(String recipient, String subject) throws Exception {
        super(recipient);
        if (subject == null || subject.trim().isEmpty()) {
            throw new Exception("Email subject cannot be empty!");
        }
        this.subject = subject;
    }

    @Override
    public void send() {
        System.out.println("Sending Email to " + getRecipient() + " with subject: " + subject);
    }
}

// Subclass SMSNotification
class SMSNotification extends Notification {
    private String message;

    public SMSNotification(String recipient, String message) throws Exception {
        super(recipient);
        if (message == null || message.trim().isEmpty()) {
            throw new Exception("SMS message cannot be empty!");
        }
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Sending SMS to " + getRecipient() + ": " + message);
    }
}

// Subclass PushNotification
class PushNotification extends Notification {
    private String title;

    public PushNotification(String recipient, String title) throws Exception {
        super(recipient);
        if (title == null || title.trim().isEmpty()) {
            throw new Exception("Push notification title cannot be empty!");
        }
        this.title = title;
    }

    @Override
    public void send() {
        System.out.println("Sending Push Notification to " + getRecipient() + " with title: " + title);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            Notification[] notifications = {
                    new EmailNotification("alice@example.com", "Meeting Reminder"),
                    new SMSNotification("9876543210", "Your OTP is 123456"),
                    new PushNotification("user123", "New Alert!")
            };

            // Polymorphism: call send() on all notifications
            for (Notification n : notifications) {
                n.send();
            }

            // Invalid case
            Notification invalid = new EmailNotification("", "Test"); // throws exception

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

