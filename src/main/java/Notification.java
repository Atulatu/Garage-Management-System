/**
 * Represents a notification with a specific message.
 * This class provides functionality to send notifications to customers.
 */
public class Notification {

    // Message to be included in the notification
    private String message;

    /**
     * Constructor to initialize the notification with a message.
     *
     * @param message The message to be sent as a notification.
     */
    public Notification(String message) {
        this.message = message;
    }

    /**
     * Sends the notification to the specified customer.
     *
     * @param customer The customer to whom the notification is sent.
     */
    public void sendNotification(Customer customer) {
        System.out.println("Notification to " + customer.getName() + ": " + message);
    }
}
