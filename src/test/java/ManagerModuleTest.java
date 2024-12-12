import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for testing the functionality of ManagerModule.
 * Each test case simulates user inputs and validates the behavior of the
 * module.
 */
public class ManagerModuleTest {
    private ManagerModule managerModule;
    private List<Customer> customers;
    private List<Customer> unregisteredCustomers;
    private List<Manufacturer> manufacturers;
    private TaskQueue taskQueue;
    private List<Mechanic> mechanics;
    private Scanner scanner;

    /**
     * Set up the test environment before each test.
     * Initializes the lists, scanner, and the ManagerModule instance.
     */
    @BeforeEach
    public void setUp() {
        customers = new ArrayList<>();
        unregisteredCustomers = new ArrayList<>();
        manufacturers = new ArrayList<>();
        taskQueue = new TaskQueue();
        mechanics = new ArrayList<>();
        scanner = new Scanner(new java.io.ByteArrayInputStream(new byte[0]));
        managerModule = new ManagerModule(scanner, customers, unregisteredCustomers, manufacturers, taskQueue,
                mechanics);
    }

    /**
     * Test case for registering a customer.
     * Simulates user inputs and verifies that the customer is added correctly.
     */
    @Test
    public void testRegisterCustomer() {
        System.out.println("\n[TEST CASE: Register Customer]");
        String simulatedInput = "Alice\n12345\nABC123\nToyota Corolla\n";
        scanner = new Scanner(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));
        managerModule = new ManagerModule(scanner, customers, unregisteredCustomers, manufacturers, taskQueue,
                mechanics);

        managerModule.registerCustomer();

        assertEquals(1, customers.size(), "Customer count mismatch.");
        assertEquals("Alice", customers.get(0).getName(), "Customer name mismatch.");
    }

    /**
     * Test case for adding an unregistered customer.
     * Simulates user inputs and verifies that the unregistered customer is added
     * correctly.
     */
    @Test
    public void testAddUnregisteredCustomer() {
        System.out.println("\n[TEST CASE: Add Unregistered Customer]");
        String simulatedInput = "Bob\n67890\nXYZ789\nHonda Civic\n";
        scanner = new Scanner(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));
        managerModule = new ManagerModule(scanner, customers, unregisteredCustomers, manufacturers, taskQueue,
                mechanics);

        managerModule.addUnregisteredCustomer();

        assertEquals(1, unregisteredCustomers.size(), "Unregistered customer count mismatch.");
        assertEquals("Bob", unregisteredCustomers.get(0).getName(), "Unregistered customer name mismatch.");
    }

    /**
     * Test case for viewing all registered customers.
     * Ensures the correct number of registered customers is displayed.
     */
    @Test
    public void testViewAllRegisteredCustomers() {
        System.out.println("\n[TEST CASE: View All Registered Customers]");
        customers.add(new Customer(1, "Alice", "12345", "ABC123", "Toyota Corolla", true));
        customers.add(new Customer(2, "Bob", "67890", "XYZ789", "Honda Civic", true));

        managerModule.viewAllRegisteredCustomers();

        assertEquals(2, customers.size(), "Registered customer count mismatch.");
    }

    /**
     * Test case for viewing all unregistered customers.
     * Ensures the correct number of unregistered customers is displayed.
     */
    @Test
    public void testViewAllUnregisteredCustomers() {
        System.out.println("\n[TEST CASE: View All Unregistered Customers]");
        unregisteredCustomers.add(new Customer(1, "Charlie", "11111", "LMN456", "Ford Focus", false));
        managerModule.viewAllUnregisteredCustomers();

        assertEquals(1, unregisteredCustomers.size(), "Unregistered customer count mismatch.");
    }

    /**
     * Test case for creating a task.
     * Simulates user inputs and verifies that the task is created and added to the
     * task queue.
     */
    @Test
    public void testCreateTask() {
        System.out.println("\n[TEST CASE: Create Task]");
        Customer customer = new Customer(1, "Alice", "12345", "ABC123", "Toyota Corolla", true);
        customers.add(customer);

        String simulatedInput = "1\nFix Engine\n5\n";
        scanner = new Scanner(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));
        managerModule = new ManagerModule(scanner, customers, unregisteredCustomers, manufacturers, taskQueue,
                mechanics);

        managerModule.createTask();

        assertEquals(1, taskQueue.getTasksAsList().size(), "Task queue size mismatch.");
        assertEquals("Fix Engine", taskQueue.getTasksAsList().get(0).getDescription(), "Task description mismatch.");
    }

    /**
     * Test case for assigning a task to a mechanic.
     * Simulates user inputs and verifies that the task is assigned correctly.
     */
    @Test
    public void testAssignTaskToMechanic() {
        System.out.println("\n[TEST CASE: Assign Task to Mechanic]");
        Mechanic mechanic = new Mechanic("John", 1);
        mechanics.add(mechanic);

        Task task = new Task("Fix brakes", "ABC123", 5);
        taskQueue.addTask(task);

        String simulatedInput = "1\n1\n";
        scanner = new Scanner(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));
        managerModule = new ManagerModule(scanner, customers, unregisteredCustomers, manufacturers, taskQueue,
                mechanics);

        managerModule.assignTasks();

        assertEquals(1, mechanic.getAssignedTasks().size(), "Assigned tasks count mismatch.");
        assertEquals("Fix brakes", mechanic.getAssignedTasks().get(0).getDescription(),
                "Assigned task description mismatch.");
        assertEquals(0, taskQueue.getTasksAsList().size(), "Task queue should be empty.");
    }

    /**
     * Test case for upgrading an unregistered customer to a registered customer.
     * Simulates user inputs and verifies the upgrade process.
     */
    @Test
    public void testUpgradeCustomer() {
        System.out.println("\n[TEST CASE: Upgrade Customer]");
        unregisteredCustomers.add(new Customer(1, "Alice", "12345", "ABC123", "Toyota Corolla", false));
        unregisteredCustomers.add(new Customer(2, "Charlie", "11111", "LMN456", "Ford Focus", false));

        String simulatedInput = "1\n";
        scanner = new Scanner(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));
        managerModule = new ManagerModule(scanner, customers, unregisteredCustomers, manufacturers, taskQueue,
                mechanics);

        managerModule.upgradeCustomer();

        assertEquals(1, customers.size(), "Registered customer count mismatch after upgrade.");
        assertEquals(1, unregisteredCustomers.size(), "Unregistered customer count mismatch after upgrade.");
    }

    /**
     * Test case for handling an empty task queue during task assignment.
     * Ensures the system behaves correctly when no tasks are available.
     */
    @Test
    public void testHandleEmptyTaskQueue() {
        System.out.println("\n[TEST CASE: Handle Empty Task Queue]");
        managerModule.assignTasks();
        assertEquals(0, taskQueue.getTasksAsList().size(), "Task queue should be empty.");
    }

    /**
     * Test case for handling the absence of available mechanics.
     * Ensures the system behaves correctly when no mechanics are available.
     */
    @Test
    public void testHandleNoMechanicsAvailable() {
        System.out.println("\n[TEST CASE: Handle No Mechanics Available]");
        Task task = new Task("Fix brakes", "ABC123", 5);
        taskQueue.addTask(task);

        managerModule.assignTasks();
        assertEquals(1, taskQueue.getTasksAsList().size(), "Task queue size mismatch when no mechanics are available.");
    }
}
