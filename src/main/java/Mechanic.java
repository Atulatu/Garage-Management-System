import java.util.ArrayList;
import java.util.List;

/**
 * Represents a mechanic in the system, including their name, ID, and a list of
 * assigned tasks.
 * A mechanic can be assigned multiple tasks and can complete them as needed.
 */
public class Mechanic {
    private String name; // The name of the mechanic
    private int id; // A unique identifier for the mechanic
    private List<Task> assignedTasks; // A list of tasks assigned to the mechanic

    /**
     * Constructs a Mechanic object with the specified name and ID.
     * Initializes an empty list of assigned tasks.
     *
     * @param name The name of the mechanic.
     * @param id   The unique identifier of the mechanic.
     */
    public Mechanic(String name, int id) {
        this.name = name;
        this.id = id;
        this.assignedTasks = new ArrayList<>();
    }

    /**
     * Gets the name of the mechanic.
     *
     * @return The name of the mechanic.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the unique identifier of the mechanic.
     *
     * @return The ID of the mechanic.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the list of tasks currently assigned to the mechanic.
     *
     * @return A list of assigned tasks.
     */
    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    /**
     * Assigns a task to the mechanic by adding it to their list of assigned tasks.
     *
     * @param task The task to be assigned to the mechanic.
     */
    public void assignTask(Task task) {
        assignedTasks.add(task);
    }

    /**
     * Marks a task as completed by removing it from the mechanic's list of assigned
     * tasks.
     *
     * @param task The task to be marked as completed.
     */
    public void completeTask(Task task) {
        assignedTasks.remove(task);
    }
}
