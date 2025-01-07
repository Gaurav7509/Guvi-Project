package example.model;

import java.util.Date;

/**
 * Represents an application for a rental property.
 */
public class Application {
    private int id;
    private int propertyId;
    private int userId;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    /**
     * Constructor for Application.
     *
     * @param id        Unique identifier for the application.
     * @param propertyId Identifier for the property being applied for.
     * @param userId    Identifier for the user making the application.
     * @param status    Status of the application (e.g. "PENDING", "APPROVED", "REJECTED").
     */
    public Application(int id, int propertyId, int userId, String status) {
        this.id = id;
        this.propertyId = propertyId;
        this.userId = userId;
        this.status = status;
    }

    /**
     * Constructor for Application.
     *
     * @param propertyId Identifier for the property being applied for.
     * @param userId    Identifier for the user making the application.
     * @param status    Status of the application (e.g. "PENDING", "APPROVED", "REJECTED").
     */
    public Application(int propertyId, int userId, String status) {
        this.propertyId = propertyId;
        this.userId = userId;
        this.status = status;
    }
    

    /**
     * Gets the unique identifier for the application.
     *
     * @return Unique identifier for the application.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the application.
     *
     * @param id Unique identifier for the application.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the identifier for the property being applied for.
     *
     * @return Identifier for the property being applied for.
     */
    public int getPropertyId() {
        return propertyId;
    }

    /**
     * Sets the identifier for the property being applied for.
     *
     * @param propertyId Identifier for the property being applied for.
     */
    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * Gets the identifier for the user making the application.
     *
     * @return Identifier for the user making the application.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the identifier for the user making the application.
     *
     * @param userId Identifier for the user making the application.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the status of the application.
     *
     * @return Status of the application.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the application.
     *
     * @param status Status of the application.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the date and time the application was created.
     *
     * @return Date and time the application was created.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the date and time the application was created.
     *
     * @param createdAt Date and time the application was created.
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the date and time the application was last updated.
     *
     * @return Date and time the application was last updated.
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the date and time the application was last updated.
     *
     * @param updatedAt Date and time the application was last updated.
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}