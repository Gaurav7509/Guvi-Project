package example.model;

/**
 * Represents a rental property.
 */
public class Property {
    private int id;
    private String address;
    private String description;
    private double rent;
    private String status;

    /**
     * Constructor for Property.
     *
     * @param id        Unique identifier for the property.
     * @param address   Address of the property.
     * @param description Description of the property.
     * @param rent      Rent amount for the property.
     */
    public Property(int id, String address, String description, double rent) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.rent = rent;
    }

    /**
     * Constructor for Property.
     *
     * @param address   Address of the property.
     * @param description Description of the property.
     * @param rent      Rent amount for the property.
     */
    public Property(String address, String description, double rent) {
        this.address = address;
        this.description = description;
        this.rent = rent;
    }

    /**
     * Gets the unique identifier for the property.
     *
     * @return Unique identifier for the property.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the property.
     *
     * @param id Unique identifier for the property.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the address of the property.
     *
     * @return Address of the property.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the property.
     *
     * @param address Address of the property.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the description of the property.
     *
     * @return Description of the property.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the property.
     *
     * @param description Description of the property.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the rent amount for the property.
     *
     * @return Rent amount for the property.
     */
    public double getRent() {
        return rent;
    }

    /**
     * Sets the rent amount for the property.
     *
     * @param rent Rent amount for the property.
     */
    public void setRent(double rent) {
        this.rent = rent;
    }

    /**
     * Gets the status of the property.
     *
     * @return Status of the property.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the property.
     *
     * @param status Status of the property.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}