import java.util.ArrayList;
import java.util.List;

/**
 * Represents a manufacturer in the system, including its name and a list of
 * parts suppliers.
 * A manufacturer can have multiple associated parts suppliers to provide
 * vehicle parts.
 */
public class Manufacturer {
    private String name; // The name of the manufacturer
    private List<PartsSupplier> partsSuppliers; // A list of parts suppliers associated with the manufacturer

    /**
     * Constructs a Manufacturer object with the specified name.
     * Initializes an empty list of parts suppliers.
     *
     * @param name The name of the manufacturer.
     */
    public Manufacturer(String name) {
        this.name = name;
        this.partsSuppliers = new ArrayList<>();
    }

    /**
     * Gets the name of the manufacturer.
     *
     * @return The name of the manufacturer.
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a parts supplier to the manufacturer's list of suppliers.
     *
     * @param supplier The parts supplier to be added.
     */
    public void addPartsSupplier(PartsSupplier supplier) {
        partsSuppliers.add(supplier);
    }

    /**
     * Gets the list of parts suppliers associated with the manufacturer.
     *
     * @return A list of parts suppliers.
     */
    public List<PartsSupplier> getPartsSuppliers() {
        return partsSuppliers;
    }
}
