package example.model;

/**
 * Represents a user.
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String role;

    /**
     * Constructor for User.
     *
     * @param id   Unique identifier for the user.
     * @param name Name of the user.
     * @param email Email address of the user.
     * @param role  Role of the user (e.g. "ADMIN", "USER").
     */
    public User(int id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    /**
     * Constructor for User.
     *
     * @param name Name of the user.
     * @param email Email address of the user.
     * @param role  Role of the user (e.g. "ADMIN", "USER").
     */
    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    /**
     * Gets the unique identifier for the user.
     *
     * @return Unique identifier for the user.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the user.
     *
     * @param id Unique identifier for the user.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the user.
     *
     * @return Name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name Name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email address of the user.
     *
     * @return Email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email Email address of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the role of the user.
     *
     * @return Role of the user.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     *
     * @param role Role of the user.
     */
    public void setRole(String role) {
        this.role = role;
    }
}