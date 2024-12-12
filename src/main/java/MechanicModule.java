import java.util.*;

/**
 * The MechanicModule class provides functionalities for mechanics to manage
 * their tasks,
 * request parts, and add manufacturers and suppliers. It serves as an interface
 * for
 * mechanics to interact with the system.
 */
public class MechanicModule {
    private Scanner scanner;
    private List<Manufacturer> manufacturers;
    private List<Mechanic> mechanics;

    /**
     * Constructor to initialize the MechanicModule with the provided scanner,
     * mechanics list,
     * and manufacturers list.
     *
     * @param scanner       Scanner for user input.
     * @param mechanics     List of mechanics in the system.
     * @param manufacturers List of manufacturers in the system.
     */
    public MechanicModule(Scanner scanner, List<Mechanic> mechanics, List<Manufacturer> manufacturers) {
        this.scanner = scanner;
        this.mechanics = mechanics;
        this.manufacturers = manufacturers;
    }

    /**
     * Displays the mechanic menu and handles user choices.
     */
    public void mechanicMenu() {
        try {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            Mechanic mechanic = findMechanicByName(name);

            if (mechanic == null) {
                System.out.println("Mechanic not found. Returning to main menu.");
                return;
            }

            while (true) {
                try {
                    System.out.println("\nMechanic Menu:");
                    System.out.println("1. View Assigned Tasks");
                    System.out.println("2. Mark Task as Completed");
                    System.out.println("3. Add Manufacturer and Parts Supplier");
                    System.out.println("4. Request Part for Vehicle");
                    System.out.println("5. Back to Main Menu");
                    System.out.print("Enter your choice: ");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1 -> viewAssignedTasks(mechanic);
                        case 2 -> markTaskAsCompleted(mechanic);
                        case 3 -> addManufacturerAndSupplier();
                        case 4 -> requestPartForVehicle();
                        case 5 -> {
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
        } catch (Exception e) {
            System.out.println("An error occurred in the mechanic menu: " + e.getMessage());
        }
    }

    /**
     * Displays the list of tasks assigned to the mechanic.
     *
     * @param mechanic The mechanic whose tasks are to be viewed.
     */
    protected void viewAssignedTasks(Mechanic mechanic) {
        try {
            System.out.println("\nAssigned Tasks:");
            List<Task> tasks = mechanic.getAssignedTasks();
            if (tasks.isEmpty()) {
                System.out.println("No tasks assigned.");
                return;
            }
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". Task Details:");
                System.out.println("--> Description: " + task.getDescription());
                System.out.println("--> Vehicle Details: " + task.getVehicleDetails());
                System.out.println("--> Priority: " + task.getPriority());
                System.out.println("--> Status: " + task.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error viewing assigned tasks: " + e.getMessage());
        }
    }

    /**
     * Marks a selected task as completed for the mechanic.
     *
     * @param mechanic The mechanic completing the task.
     */
    public void markTaskAsCompleted(Mechanic mechanic) {
        try {
            System.out.println("\nAssigned Tasks:");
            List<Task> tasks = mechanic.getAssignedTasks();
            if (tasks.isEmpty()) {
                System.out.println("No tasks assigned.");
                return;
            }
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". Task Details:");
                System.out.println("--> Description: " + task.getDescription());
                System.out.println("--> Vehicle Details: " + task.getVehicleDetails());
                System.out.println("--> Priority: " + task.getPriority());
                System.out.println("--> Status: " + task.getStatus());
            }

            System.out.print("Enter the task number to mark as completed: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (taskNumber < 1 || taskNumber > tasks.size()) {
                System.out.println("Invalid task number. Returning to menu.");
                return;
            }

            Task selectedTask = tasks.get(taskNumber - 1);
            selectedTask.markAsCompleted();
            System.out.println("Task '" + selectedTask.getDescription() + "' marked as completed.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        } catch (Exception e) {
            System.out.println("Error marking task as completed: " + e.getMessage());
        }
    }

    /**
     * Adds a manufacturer and its parts suppliers to the system.
     */
    protected void addManufacturerAndSupplier() {
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
            System.out.println("Error adding manufacturer or supplier: " + e.getMessage());
        }
    }

    /**
     * Requests a part for a vehicle from a manufacturer and its supplier.
     */
    protected void requestPartForVehicle() {
        try {
            System.out.println("\nAvailable Manufacturers:");
            for (int i = 0; i < manufacturers.size(); i++) {
                System.out.println((i + 1) + ". " + manufacturers.get(i).getName());
            }

            System.out.print("Select manufacturer by number: ");
            int manufacturerNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (manufacturerNumber < 1 || manufacturerNumber > manufacturers.size()) {
                System.out.println("Invalid manufacturer number. Returning to menu.");
                return;
            }

            Manufacturer selectedManufacturer = manufacturers.get(manufacturerNumber - 1);

            System.out.println("\nAvailable Parts Suppliers for " + selectedManufacturer.getName() + ":");
            List<PartsSupplier> suppliers = selectedManufacturer.getPartsSuppliers();
            for (int i = 0; i < suppliers.size(); i++) {
                System.out.println((i + 1) + ". " + suppliers.get(i).getName());
            }

            System.out.print("Select parts supplier by number: ");
            int supplierNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (supplierNumber < 1 || supplierNumber > suppliers.size()) {
                System.out.println("Invalid supplier number. Returning to menu.");
                return;
            }

            PartsSupplier selectedSupplier = suppliers.get(supplierNumber - 1);

            System.out.print("Enter part description: ");
            String partDescription = scanner.nextLine();
            System.out
                    .println("Part request sent for '" + partDescription + "' to " + selectedSupplier.getName() + ".");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        } catch (Exception e) {
            System.out.println("Error requesting part: " + e.getMessage());
        }
    }

    /**
     * Finds a manufacturer by its name.
     *
     * @param name The name of the manufacturer to find.
     * @return The Manufacturer object if found, otherwise null.
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
     * Finds a mechanic by their name.
     *
     * @param name The name of the mechanic to find.
     * @return The Mechanic object if found, otherwise null.
     */
    private Mechanic findMechanicByName(String name) {
        for (Mechanic mechanic : mechanics) {
            if (mechanic.getName().equalsIgnoreCase(name)) {
                return mechanic;
            }
        }
        return null;
    }

    /**
     * Checks if there are any mechanics available in the system.
     *
     * @return True if there are mechanics, false otherwise.
     */
    public boolean hasMechanics() {
        return !mechanics.isEmpty();
    }
}