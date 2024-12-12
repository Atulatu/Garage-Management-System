/**
 * Represents a parts supplier in the system.
 * A parts supplier provides parts to manufacturers.
 */
public class PartsSupplier {
    private String name; // The name of the parts supplier

    /**
     * Constructs a PartsSupplier object with the specified name.
     *
     * @param name The name of the parts supplier.
     */
    public PartsSupplier(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the parts supplier.
     *
     * @return The name of the parts supplier.
     */
    public String getName() {
        return name;
    }
}
