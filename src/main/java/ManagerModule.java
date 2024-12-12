import java.util.*;

/**
 * ManagerModule handles various operations related to customers, tasks,
 * mechanics,
 * and manufacturers in the system. This includes registering customers,
 * managing tasks, sending notifications, and assigning tasks to mechanics.
 */
public class ManagerModule {
    private Scanner scanner;
    private List<Customer> customers;
    private List<Customer> unregisteredCustomers;
    private List<Manufacturer> manufacturers;
    private TaskQueue taskQueue;
    private List<Mechanic> mechanics;
    private int customerIdCounter;

    /**
     * Constructor to initialize the ManagerModule with required dependencies.
     *
     * @param scanner               Scanner object for user input
     * @param customers             List of registered customers
     * @param unregisteredCustomers List of unregistered customers
     * @param manufacturers         List of manufacturers and their suppliers
     * @param taskQueue             Queue to manage pending tasks
     * @param mechanics             List of available mechanics
     */

    public ManagerModule(Scanner scanner, List<Customer> customers, List<Customer> unregisteredCustomers,
            List<Manufacturer> manufacturers, TaskQueue taskQueue, List<Mechanic> mechanics) {
        this.scanner = scanner;
        this.customers = customers;
        this.unregisteredCustomers = unregisteredCustomers;
        this.manufacturers = manufacturers;
        this.taskQueue = taskQueue;
        this.mechanics = mechanics;
        this.customerIdCounter = 1;
    }

    /**
     * Displays the main menu for the ManagerModule and handles user choices.
     */
    public void managerMenu() {
        while (true) {
            try {
                System.out.println("\nManager Menu:");
                System.out.println("1. Register Customer");
                System.out.println("2. View All Registered Customers");
                System.out.println("3. Add Unregistered Walk-In Customer");
                System.out.println("4. View All Unregistered Customers");
                System.out.println("5. Send Notifications to Registered Customers");
                System.out.println("6. Send Notifications to Unregistered Customers");
                System.out.println("7. Add Manufacturer and Parts Suppliers");
                System.out.println("8. Create Task");
                System.out.println("9. Assign Tasks to Mechanics");
                System.out.println("10. Add Mechanic");
                System.out.println("11. Upgrade Unregistered Customer to Registered");
                System.out.println("12. Back to Main Menu");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> registerCustomer();
                    case 2 -> viewAllRegisteredCustomers();
                    case 3 -> addUnregisteredCustomer();
                    case 4 -> viewAllUnregisteredCustomers();
                    case 5 -> sendNotificationsToRegisteredCustomers();
                    case 6 -> sendNotificationsToUnregisteredCustomers();
                    case 7 -> addManufacturerAndSuppliers();
                    case 8 -> createTask();
                    case 9 -> assignTasks();
                    case 10 -> addMechanic();
                    case 11 -> upgradeCustomer();
                    case 12 -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Registers a new customer and adds them to the registered customers list.
     */
    protected void registerCustomer() {
        try {
            System.out.print("Enter customer name: ");
            String name = scanner.nextLine();
            System.out.print("Enter contact info: ");
            String contact = scanner.nextLine();
            System.out.print("Enter vehicle number: ");
            String vehicleNumber = scanner.nextLine();
            System.out.print("Enter vehicle model: ");
            String vehicleModel = scanner.nextLine();

            Customer customer = new Customer(customerIdCounter++, name, contact, vehicleNumber, vehicleModel, true);
            customers.add(customer);
            System.out.println("Customer registered successfully.");
        } catch (Exception e) {
            System.out.println("Error while registering customer: " + e.getMessage());
        }
    }

    /**
     * Displays all registered customers.
     */
    protected void viewAllRegisteredCustomers() {
        System.out.println("\nRegistered Customers:");
        if (customers.isEmpty()) {
            System.out.println("No registered customers found.");
            return;
        }
        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("--> Name: " + customer.getName());
            System.out.println("--> Contact Info: " + customer.getContactInfo());
            System.out.println("--> Vehicle Number: " + customer.getVehicleNumber());
            System.out.println("--> Vehicle Model: " + customer.getVehicleModel());
            System.out.println("--> Registered: Yes");
        }
    }

    /**
     * Adds a walk-in unregistered customer to the system.
     */
    protected void addUnregisteredCustomer() {
        try {
            System.out.print("Enter customer name: ");
            String name = scanner.nextLine();
            System.out.print("Enter contact info: ");
            String contact = scanner.nextLine();
            System.out.print("Enter vehicle number: ");
            String vehicleNumber = scanner.nextLine();
            System.out.print("Enter vehicle model: ");
            String vehicleModel = scanner.nextLine();

            Customer customer = new Customer(customerIdCounter++, name, contact, vehicleNumber, vehicleModel, false);
            unregisteredCustomers.add(customer);
            System.out.println("Unregistered walk-in customer added successfully.");
        } catch (Exception e) {
            System.out.println("Error while adding unregistered customer: " + e.getMessage());
        }
    }

    /**
     * Displays all unregistered customers.
     */
    protected void viewAllUnregisteredCustomers() {
        System.out.println("\nUnregistered Customers:");
        if (unregisteredCustomers.isEmpty()) {
            System.out.println("No unregistered customers found.");
            return;
        }
        for (Customer customer : unregisteredCustomers) {
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("--> Name: " + customer.getName());
            System.out.println("--> Contact Info: " + customer.getContactInfo());
            System.out.println("--> Vehicle Number: " + customer.getVehicleNumber());
            System.out.println("--> Vehicle Model: " + customer.getVehicleModel());
            System.out.println("--> Registered: No");
        }
    }

    /**
     * Sends a notification message to all registered customers.
     */
    protected void sendNotificationsToRegisteredCustomers() {
        try {
            System.out.print("Enter notification message: ");
            String message = scanner.nextLine();
            for (Customer customer : customers) {
                System.out.println("Notification sent to registered customer " + customer.getName() + ": " + message);
            }
        } catch (Exception e) {
            System.out.println("Error while sending notifications: " + e.getMessage());
        }
    }

    /**
     * Sends a notification message to all unregistered customers.
     */
    protected void sendNotificationsToUnregisteredCustomers() {
        try {
            System.out.print("Enter notification message: ");
            String message = scanner.nextLine();
            for (Customer customer : unregisteredCustomers) {
                System.out.println("Notification sent to unregistered customer " + customer.getName() + ": " + message);
            }
        } catch (Exception e) {
            System.out.println("Error while sending notifications: " + e.getMessage());
        }
    }

    /**
     * Adds a manufacturer and its parts suppliers.
     */
    protected void addManufacturerAndSuppliers() {
        try {
            System.out.print("Enter manufacturer name: ");
            String manufacturerName = scanner.nextLine();
            Manufacturer manufacturer = findManufacturerByName(manufacturerName);
            if (manufacturer == null) {
                manufacturer = new Manufacturer(manufacturerName);
                manufacturers.add(manufacturer);
                System.out.println("Manufacturer added successfully.");
            }

            while (true) {
                System.out.print("Enter parts supplier name (or type 'done' to finish): ");
                String supplierName = scanner.nextLine();
                if (supplierName.equalsIgnoreCase("done")) {
                    break;
                }
                manufacturer.addPartsSupplier(new PartsSupplier(supplierName));
                System.out.println("Parts supplier added successfully to " + manufacturerName);
            }
        } catch (Exception e) {
            System.out.println("Error while adding manufacturer or supplier: " + e.getMessage());
        }
    }

    /**
     * Finds a manufacturer by its name.
     *
     * @param name Manufacturer name
     * @return Manufacturer object if found, null otherwise
     */
    private Manufacturer findManufacturerByName(String name) {
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.getName().equalsIgnoreCase(name)) {
                return manufacturer;
            }
        }
        return null;
    }

    /**
     * Creates a new task for a customer.
     */
    protected void createTask() {
        try {
            System.out.println("\nSelect a customer to create a task for:");

            System.out.println("\nRegistered Customers:");
            if (customers.isEmpty()) {
                System.out.println("No registered customers available.");
            } else {
                for (Customer customer : customers) {
                    System.out.println("Customer ID: " + customer.getId());
                    System.out.println("--> Name: " + customer.getName());
                    System.out.println("--> Vehicle Number: " + customer.getVehicleNumber());
                }
            }

            System.out.println("\nUnregistered Customers:");
            if (unregisteredCustomers.isEmpty()) {
                System.out.println("No unregistered customers available.");
            } else {
                for (Customer customer : unregisteredCustomers) {
                    System.out.println("Customer ID: " + customer.getId());
                    System.out.println("--> Name: " + customer.getName());
                    System.out.println("--> Vehicle Number: " + customer.getVehicleNumber());
                }
            }

            System.out.print("\nEnter the customer ID to create a task for: ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Customer selectedCustomer = findCustomerById(customerId);
            if (selectedCustomer == null) {
                System.out.println("Customer not found. Returning to menu.");
                return;
            }

            System.out.print("Enter task description: ");
            String description = scanner.nextLine();
            System.out.print("Enter task priority (higher number = higher priority): ");
            int priority = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Task task = new Task(description, selectedCustomer.getVehicleNumber(), priority);
            taskQueue.addTask(task);
            System.out.println("Task created for customer " + selectedCustomer.getName() + " and added to the queue.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine(); // Clear invalid input
        } catch (Exception e) {
            System.out.println("An error occurred while creating the task: " + e.getMessage());
        }
    }

    /**
     * Finds a customer by their ID.
     *
     * @param id Customer ID
     * @return Customer object if found, null otherwise
     */
    private Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        for (Customer customer : unregisteredCustomers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Assigns tasks to mechanics.
     */
    protected void assignTasks() {
        try {
            if (mechanics.isEmpty()) {
                System.out.println("No mechanics available.");
                return;
            }
            if (taskQueue.isEmpty()) {
                System.out.println("No tasks to assign.");
                return;
            }

            System.out.println("\nPending Tasks:");
            List<Task> pendingTasks = taskQueue.getTasksAsList();
            for (int i = 0; i < pendingTasks.size(); i++) {
                Task task = pendingTasks.get(i);
                System.out.println((i + 1) + ". Task Details:");
                System.out.println("--> Description: " + task.getDescription());
                System.out.println("--> Vehicle Details: " + task.getVehicleDetails());
                System.out.println("--> Priority: " + task.getPriority());
                System.out.println("--> Status: " + task.getStatus());
            }

            System.out.print("Enter the task number to assign: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (taskNumber < 1 || taskNumber > pendingTasks.size()) {
                System.out.println("Invalid task number. Returning to menu.");
                return;
            }

            Task selectedTask = pendingTasks.get(taskNumber - 1);

            System.out.println("\nAvailable Mechanics:");
            for (Mechanic mechanic : mechanics) {
                System.out.println("ID: " + mechanic.getId() + ", Name: " + mechanic.getName());
            }

            System.out.print("Enter the ID of the mechanic to assign this task: ");
            int mechanicId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Mechanic mechanic = findMechanicById(mechanicId);
            if (mechanic == null) {
                System.out.println("Invalid mechanic ID. Returning to menu.");
                return;
            }

            taskQueue.removeTask(selectedTask);
            mechanic.assignTask(selectedTask);
            System.out
                    .println("Task '" + selectedTask.getDescription() + "' assigned to Mechanic " + mechanic.getName());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine(); // Clear invalid input
        } catch (Exception e) {
            System.out.println("Error while assigning tasks: " + e.getMessage());
        }
    }

    /**
     * Finds a mechanic by their ID.
     *
     * @param id Mechanic ID
     * @return Mechanic object if found, null otherwise
     */
    private Mechanic findMechanicById(int id) {
        for (Mechanic mechanic : mechanics) {
            if (mechanic.getId() == id) {
                return mechanic;
            }
        }
        return null;
    }

    /**
     * Adds a new mechanic to the system.
     */
    protected void addMechanic() {
        try {
            System.out.print("Enter mechanic name: ");
            String name = scanner.nextLine();
            int id = mechanics.size() + 1; // Generate unique ID
            Mechanic mechanic = new Mechanic(name, id);
            mechanics.add(mechanic);
            System.out.println("Mechanic added successfully with ID: " + id);
        } catch (Exception e) {
            System.out.println("Error while adding mechanic: " + e.getMessage());
        }
    }

    /**
     * Upgrades an unregistered customer to a registered customer.
     */
    protected void upgradeCustomer() {
        try {
            if (unregisteredCustomers.isEmpty()) {
                System.out.println("No unregistered customers available to upgrade.");
                return;
            }

            System.out.println("\nUnregistered Customers:");
            for (int i = 0; i < unregisteredCustomers.size(); i++) {
                Customer customer = unregisteredCustomers.get(i);
                System.out.println((i + 1) + ". Customer Details:");
                System.out.println("--> Name: " + customer.getName());
                System.out.println("--> Contact Info: " + customer.getContactInfo());
                System.out.println("--> Vehicle Number: " + customer.getVehicleNumber());
                System.out.println("--> Vehicle Model: " + customer.getVehicleModel());
            }

            System.out.print("Enter the number of the customer to upgrade: ");
            int customerIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume newline

            if (customerIndex < 0 || customerIndex >= unregisteredCustomers.size()) {
                System.out.println("Invalid selection. Returning to menu.");
                return;
            }

            Customer customerToUpgrade = unregisteredCustomers.remove(customerIndex);
            customerToUpgrade.setRegistered(true);
            customers.add(customerToUpgrade);
            System.out.println("Customer upgraded to registered successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine(); // Clear invalid input
        } catch (Exception e) {
            System.out.println("Error while upgrading customer: " + e.getMessage());
        }
    }
}
