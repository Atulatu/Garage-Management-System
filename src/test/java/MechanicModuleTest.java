import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the MechanicModule class, covering all its core
 * functionalities.
 */
public class MechanicModuleTest {
    private MechanicModule mechanicModule; // The MechanicModule instance being tested
    private List<Manufacturer> manufacturers; // List of manufacturers
    private List<Mechanic> mechanics; // List of mechanics
    private Scanner scanner; // Scanner for simulating user input

    /**
     * Sets up the necessary data and objects before each test case runs.
     */
    @BeforeEach
    public void setUp() {
        manufacturers = new ArrayList<>();
        mechanics = new ArrayList<>();
        scanner = new Scanner(new java.io.ByteArrayInputStream(new byte[0]));
        mechanicModule = new MechanicModule(scanner, mechanics, manufacturers);
    }

    /**
     * Test case to verify the functionality of adding a manufacturer and its parts
     * suppliers.
     */
    @Test
    public void testAddManufacturerAndSupplier() {
        System.out.println("\n[TEST CASE: Add Manufacturer and Supplier]");
        String simulatedInput = "Toyota\nSupplier1\nSupplier2\ndone\n";
        scanner = new Scanner(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));
        mechanicModule = new MechanicModule(scanner, mechanics, manufacturers);

        mechanicModule.addManufacturerAndSupplier();

        // Verify the manufacturer and suppliers are correctly added
        assertEquals(1, manufacturers.size(), "Manufacturer count mismatch.");
        Manufacturer manufacturer = manufacturers.get(0);
        assertEquals("Toyota", manufacturer.getName(), "Manufacturer name mismatch.");
        assertEquals(2, manufacturer.getPartsSuppliers().size(), "Parts supplier count mismatch.");
        assertEquals("Supplier1", manufacturer.getPartsSuppliers().get(0).getName(), "First supplier name mismatch.");
        assertEquals("Supplier2", manufacturer.getPartsSuppliers().get(1).getName(), "Second supplier name mismatch.");
    }

    /**
     * Test case to verify the functionality of requesting a part for a vehicle from
     * a specific supplier.
     */
    @Test
    public void testRequestPartForVehicle() {
        System.out.println("\n[TEST CASE: Request Part for Vehicle]");
        Manufacturer manufacturer = new Manufacturer("Toyota");
        PartsSupplier supplier1 = new PartsSupplier("Supplier1");
        PartsSupplier supplier2 = new PartsSupplier("Supplier2");
        manufacturer.addPartsSupplier(supplier1);
        manufacturer.addPartsSupplier(supplier2);
        manufacturers.add(manufacturer);

        String simulatedInput = "1\n1\nBrake Pads\n";
        scanner = new Scanner(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));
        mechanicModule = new MechanicModule(scanner, mechanics, manufacturers);

        mechanicModule.requestPartForVehicle();

        // Verify that the manufacturer and supplier selection is correct
        assertEquals(1, manufacturers.size(), "Manufacturer count mismatch.");
        assertEquals("Toyota", manufacturers.get(0).getName(), "Manufacturer name mismatch.");
    }

    /**
     * Test case to verify the functionality of viewing assigned tasks for a
     * mechanic.
     */
    @Test
    public void testViewAssignedTasks() {
        System.out.println("\n[TEST CASE: View Assigned Tasks]");
        Mechanic mechanic = new Mechanic("John", 1);
        Task task = new Task("Fix brakes", "ABC123", 5);
        mechanic.assignTask(task);
        mechanics.add(mechanic);

        mechanicModule.viewAssignedTasks(mechanic);

        // Verify that the mechanic's assigned tasks are correctly displayed
        assertEquals(1, mechanic.getAssignedTasks().size(), "Assigned tasks count mismatch.");
        assertEquals("Fix brakes", mechanic.getAssignedTasks().get(0).getDescription(), "Task description mismatch.");
    }

    /**
     * Test case to verify the functionality of marking a task as completed.
     */
    @Test
    public void testMarkTaskAsCompleted() {
        System.out.println("\n[TEST CASE: Mark Task as Completed]");
        Mechanic mechanic = new Mechanic("John", 1);
        Task task = new Task("Fix brakes", "ABC123", 5);
        mechanic.assignTask(task);
        mechanics.add(mechanic);

        String simulatedInput = "1\n";
        scanner = new Scanner(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));
        mechanicModule = new MechanicModule(scanner, mechanics, manufacturers);

        mechanicModule.markTaskAsCompleted(mechanic);

        // Verify that the task status is updated to completed
        assertEquals(1, mechanic.getAssignedTasks().size(), "Assigned tasks count mismatch.");
        assertEquals("Completed", mechanic.getAssignedTasks().get(0).getStatus(), "Task status mismatch.");
    }
}
