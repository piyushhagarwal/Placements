// Loose coupling is a design principle in software development that aims to
// reduce the dependencies between components or modules. In a loosely coupled
// system, changes to one component have minimal impact on other components.
// This promotes flexibility, maintainability, and ease of modification.

// MessagingService interface declaring the sendMessage method
interface MessagingService {
    void sendMessage(String sender, String message);
}

// EmailService class implementing the MessagingService interface
class EmailService implements MessagingService {
    @Override
    public void sendMessage(String sender, String message) {
        System.out.println("Email sent from " + sender + ": " + message);
        // Actual implementation to send an email
    }
}

// SMSService class implementing the MessagingService interface
class SMSService implements MessagingService {
    @Override
    public void sendMessage(String sender, String message) {
        System.out.println("SMS sent from " + sender + ": " + message);
        // Actual implementation to send an SMS
    }
}

// User class using the MessagingService interface
class User {
    private String username;

    // Constructor
    public User(String username) {
        this.username = username;
    }

    // Method to send messages using a messaging service
    public void sendMessage(String message, MessagingService messagingService) {
        System.out.println(username + " is sending a message...");
        messagingService.sendMessage(username, message);
    }
}

// Main program to demonstrate the usage of interfaces and loose coupling
class MessagingExample {
    public static void main(String[] args) {
        // Creating instances of EmailService and SMSService
        MessagingService emailService = new EmailService();
        MessagingService smsService = new SMSService();

        // Creating instances of User
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        // Users send messages using different services
        user1.sendMessage("Hello, Bob!", emailService);
        user2.sendMessage("Hi, Alice!", smsService);
    }
}

// The User class uses the MessagingService interface for sending messages. This
// demonstrates loose coupling, as the User class is not dependent on specific
// messaging service implementations.
