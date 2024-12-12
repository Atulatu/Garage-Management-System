/**
 * The Manager class represents a manager user in the system.
 * It extends the User class and provides additional functionalities
 * specific to the manager role, such as sending notifications to customers.
 */
public class Manager extends User {

    /**
     * Constructs a Manager object with the specified name and ID.
     *
     * @param name The name of the manager.
     * @param id   The unique identifier for the manager.
     */
    public Manager(String name, int id) {
        super(name, id); // Call the superclass constructor to initialize common fields
    }

    /**
     * Sends a notification to a specified customer about a new offer or message.
     *
     * @param notification The notification containing the message details.
     * @param customer     The customer to whom the notification is sent.
     */
    public void postOfferNotification(Notification notification, Customer customer) {
        notification.sendNotification(customer); // Delegate notification sending to the Notification class
    }
}
