/**
 * Represents an abstract user in the system.
 * The `User` class serves as a base class for specific types of users,
 * such as managers and mechanics.
 */
public abstract class User {
    private String name; // Name of the user
    private int id; // Unique identifier for the user

    /**
     * Constructs a User object with the specified name and ID.
     *
     * @param name The name of the user.
     * @param id   The unique identifier for the user.
     */
    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Gets the name of the user.
     *
     * @return The user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the unique identifier of the user.
     *
     * @return The user's ID.
     */
    public int getId() {
        return id;
    }
}
