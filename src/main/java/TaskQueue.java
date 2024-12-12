import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class TaskQueue {
    private PriorityQueue<Task> tasks;

    public TaskQueue() {
        // High-priority tasks are processed first
        tasks = new PriorityQueue<>((a, b) -> b.getPriority() - a.getPriority());
    }

    // Add a new task to the queue
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Retrieve and remove the highest-priority task
    public Task getNextTask() {
        return tasks.poll();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    // Remove a specific task from the queue
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    // Retrieve all tasks as a list (for display purposes)
    public List<Task> getTasksAsList() {
        return new ArrayList<>(tasks); // Convert the priority queue to a list
    }
}
