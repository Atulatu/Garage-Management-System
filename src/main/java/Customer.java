/**
 * Represents a customer in the system.
 * Each customer has an ID, personal details, vehicle information, and a
 * registration status.
 */
public class Customer {

    // Unique identifier for the customer
    private int id;

    // Name of the customer
    private String name;

    // Contact information of the customer
    private String contactInfo;

    // Vehicle number associated with the customer
    private String vehicleNumber;

    // Model of the vehicle associated with the customer
    private String vehicleModel;

    // Registration status of the customer
    private boolean isRegistered;

    /**
     * Constructs a new Customer with the specified details.
     *
     * @param id            The unique identifier for the customer.
     * @param name          The name of the customer.
     * @param contactInfo   The contact information of the customer.
     * @param vehicleNumber The vehicle number associated with the customer.
     * @param vehicleModel  The vehicle model associated with the customer.
     * @param isRegistered  The registration status of the customer (true if
     *                      registered, false otherwise).
     */
    public Customer(int id, String name, String contactInfo, String vehicleNumber, String vehicleModel,
            boolean isRegistered) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
        this.isRegistered = isRegistered;
    }

    /**
     * Retrieves the unique ID of the customer.
     *
     * @return The customer's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the name of the customer.
     *
     * @return The customer's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the contact information of the customer.
     *
     * @return The customer's contact information.
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * Retrieves the vehicle number associated with the customer.
     *
     * @return The customer's vehicle number.
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    /**
     * Retrieves the vehicle model associated with the customer.
     *
     * @return The customer's vehicle model.
     */
    public String getVehicleModel() {
        return vehicleModel;
    }

    /**
     * Checks if the customer is registered.
     *
     * @return True if the customer is registered, false otherwise.
     */
    public boolean isRegistered() {
        return isRegistered;
    }

    /**
     * Updates the registration status of the customer.
     *
     * @param registered The new registration status to set.
     */
    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    /**
     * Returns a string representation of the customer's details.
     *
     * @return A formatted string containing the customer's details.
     */
    @Override
    public String toString() {
        return "Customer ID: " + id +
                "\n--> Name: " + name +
                "\n--> Contact Info: " + contactInfo +
                "\n--> Vehicle Number: " + vehicleNumber +
                "\n--> Vehicle Model: " + vehicleModel +
                "\n--> Registered: " + (isRegistered ? "Yes" : "No");
    }
}
