/**
 * Represents a task assigned to a mechanic for a specific vehicle.
 * Each task includes details such as description, vehicle details, priority,
 * and status.
 */
public class Task {
    private String description; // Description of the task
    private String vehicleDetails; // Details of the associated vehicle
    private int priority; // Priority level of the task (higher number indicates higher priority)
    private String status; // Current status of the task (e.g., "Pending", "Completed")

    /**
     * Constructs a Task object with the specified description, vehicle details, and
     * priority.
     * The task's status is set to "Pending" by default.
     *
     * @param description    Description of the task.
     * @param vehicleDetails Details of the associated vehicle.
     * @param priority       Priority level of the task.
     */
    public Task(String description, String vehicleDetails, int priority) {
        this.description = description;
        this.vehicleDetails = vehicleDetails;
        this.priority = priority;
        this.status = "Pending"; // Default status
    }

    /**
     * Gets the description of the task.
     *
     * @return The task's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the details of the associated vehicle.
     *
     * @return The vehicle details.
     */
    public String getVehicleDetails() {
        return vehicleDetails;
    }

    /**
     * Gets the priority level of the task.
     *
     * @return The task's priority.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Gets the current status of the task.
     *
     * @return The task's status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Marks the task as completed by updating its status to "Completed".
     */
    public void markAsCompleted() {
        this.status = "Completed";
    }

    /**
     * Returns a string representation of the task, including all its details.
     *
     * @return A string representation of the task.
     */
    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", vehicleDetails='" + vehicleDetails + '\'' +
                ", priority=" + priority +
                ", status='" + status + '\'' +
                '}';
    }
}
