package example.model;

import java.sql.Date;

/**
 * Represents a rental agreement between a landlord and a tenant.
 */
public class RentalAgreement {
    private int id;
    private int applicationId;
    private Date startDate;
    private Date endDate;
    private double rent;
    private double securityDeposit;

    /**
     * Constructor for RentalAgreement.
     *
     * @param id            Unique identifier for the rental agreement.
     * @param applicationId Identifier for the application associated with the rental agreement.
     * @param startDate     Start date of the rental agreement.
     * @param endDate       End date of the rental agreement.
     * @param rent          Rent amount for the rental agreement.
     * @param securityDeposit Security deposit amount for the rental agreement.
     */
    public RentalAgreement(int id, int applicationId, Date startDate, Date endDate, double rent, double securityDeposit) {
        this.id = id;
        this.applicationId = applicationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rent = rent;
        this.securityDeposit = securityDeposit;
    }

    /**
     * Constructor for RentalAgreement.
     *
     * @param applicationId Identifier for the application associated with the rental agreement.
     * @param startDate     Start date of the rental agreement.
     * @param endDate       End date of the rental agreement.
     * @param rent          Rent amount for the rental agreement.
     * @param securityDeposit Security deposit amount for the rental agreement.
     */
    public RentalAgreement(int applicationId, Date startDate, Date endDate, double rent, double securityDeposit) {
        this.applicationId = applicationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rent = rent;
        this.securityDeposit = securityDeposit;
    }

    /**
     * Gets the unique identifier for the rental agreement.
     *
     * @return Unique identifier for the rental agreement.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the rental agreement.
     *
     * @param id Unique identifier for the rental agreement.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the identifier for the application associated with the rental agreement.
     *
     * @return Identifier for the application associated with the rental agreement.
     */
    public int getApplicationId() {
        return applicationId;
    }

    /**
     * Sets the identifier for the application associated with the rental agreement.
     *
     * @param applicationId Identifier for the application associated with the rental agreement.
     */
    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * Gets the start date of the rental agreement.
     *
     * @return Start date of the rental agreement.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the rental agreement.
     *
     * @param startDate Start date of the rental agreement.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date of the rental agreement.
     *
     * @return End date of the rental agreement.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of the rental agreement.
     *
     * @param endDate End date of the rental agreement.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the rent amount for the rental agreement.
     *
     * @return Rent amount for the rental agreement.
     */
    public double getRent() {
        return rent;
    }

    /**
     * Sets the rent amount for the rental agreement.
     *
     * @param rent Rent amount for the rental agreement.
     */
    public void setRent(double rent) {
        this.rent = rent;
    }

    /**
     * Gets the security deposit amount for the rental agreement.
     *
     * @return Security deposit amount for the rental agreement.
     */
    public double getSecurityDeposit() {
        return securityDeposit;
    }

    /**
     * Sets the security deposit amount for the rental agreement.
     *
     * @param securityDeposit Security deposit amount for the rental agreement.
     */
    public void setSecurityDeposit(double securityDeposit) {
        this.securityDeposit = securityDeposit;
    }
}