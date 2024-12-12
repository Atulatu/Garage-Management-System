import java.util.*;

/**
 * The Main class serves as the entry point for the application.
 * It initializes the necessary modules and allows users to choose their role
 * (Manager or Mechanic)
 * to perform respective operations.
 */
public class Main {
    public static void main(String[] args) {
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Initialize required lists for customers, unregistered customers,
        // manufacturers, mechanics, and tasks
        List<Customer> customers = new ArrayList<>();
        List<Customer> unregisteredCustomers = new ArrayList<>();
        List<Manufacturer> manufacturers = new ArrayList<>();
        List<Mechanic> mechanics = new ArrayList<>();
        TaskQueue taskQueue = new TaskQueue();

        // Initialize modules for Manager and Mechanic functionalities
        ManagerModule managerModule = new ManagerModule(scanner, customers, unregisteredCustomers, manufacturers,
                taskQueue, mechanics);
        MechanicModule mechanicModule = new MechanicModule(scanner, mechanics, manufacturers);

        // Main application loop
        while (true) {
            System.out.println("\nUser Type:");
            System.out.println("1. Manager");
            System.out.println("2. Mechanic");
            System.out.println("3. Exit");

            int choice = -1;

            // Input validation for user type selection
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            // Handle user choice
            switch (choice) {
                case 1:
                    // Enter the Manager menu
                    managerModule.managerMenu();
                    break;
                case 2:
                    // Check if mechanics are available before allowing access to Mechanic menu
                    if (!mechanicModule.hasMechanics()) {
                        System.out.println("No mechanics available. Please ask the manager to add mechanics.");
                        break;
                    }
                    mechanicModule.mechanicMenu();
                    break;
                case 3:
                    // Exit the application
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
