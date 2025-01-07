
import example.dao.MessageDAO;
import example.dao.ApplicationDAO;
import example.dao.PropertyDAO;
import example.dao.RentalAgreementDAO;
import example.dao.SystemSettingsDAO;
import example.dao.UserDAO;
import example.model.Application;
import example.model.Message;
import example.model.Property;
import example.model.RentalAgreement;
import example.model.SystemSettings;
import example.model.User;

public class Main {
    public static void main(String[] args) {
        // Example of using UserDAO
        UserDAO userDAO = new UserDAO();
        User user = new User("John Doe", "john@example.com", "USER");
        System.out.println(userDAO.createUser(user));

        // Example of using PropertyDAO
        PropertyDAO propertyDAO = new PropertyDAO();
        Property property = new Property("123 Main St", "A beautiful house", 1000.0);
        System.out.println(propertyDAO.createProperty(property));

        // Example of using ApplicationDAO
        ApplicationDAO applicationDAO = new ApplicationDAO();
        Application application = new Application(1, 1, "PENDING");
        System.out.println(applicationDAO.createApplication(application));

        // Example of updating an application
        application.setStatus("APPROVED");
        System.out.println(applicationDAO.updateApplication(application));

        // Example of deleting an application
        System.out.println(applicationDAO.deleteApplication(1));

        // Example of getting an application
        Application retrievedApplication = applicationDAO.getApplication(1);
        if (retrievedApplication != null) {
            System.out.println("Application ID: " + retrievedApplication.getId());
            System.out.println("Property ID: " + retrievedApplication.getPropertyId());
            System.out.println("User     ID: " + retrievedApplication.getUserId());
            System.out.println("Status: " + retrievedApplication.getStatus());
        } else {
            System.out.println("Application not found");
        }

        // Example of using MessageDAO
        MessageDAO messageDAO = new MessageDAO();
        Message message = new Message(1, 2, "Hello, how are you?");
        System.out.println(messageDAO.createMessage(message));

        // Example of updating a message
        message.setMessageText("Hello, how are you? I'm good.");
        System.out.println(messageDAO.updateMessage(message));

        // Example of deleting a message
        System.out.println(messageDAO.deleteMessage(1));

        // Example of getting a message
        Message retrievedMessage = messageDAO.getMessage(1);
        if (retrievedMessage != null) {
            System.out.println("Message ID: " + retrievedMessage.getId());
            System.out.println("Sender ID: " + retrievedMessage.getSenderId());
            System.out.println("Receiver ID: " + retrievedMessage.getReceiverId());
            System.out.println("Message Text: " + retrievedMessage.getMessageText());
            System.out.println("Created At: " + retrievedMessage.getCreatedAt());
        } else {
            System.out.println("Message not found");
        }

        // Example of using RentalAgreementDAO
        RentalAgreementDAO rentalAgreementDAO = new RentalAgreementDAO();
        RentalAgreement rentalAgreement = new RentalAgreement(1, java.sql.Date.valueOf("2022-01-01"), java.sql.Date.valueOf("2022-12-31"), 1000.0, 500.0);
        System.out.println(rentalAgreementDAO.createRentalAgreement(rentalAgreement));

        // Example of updating a rental agreement
        rentalAgreement.setRent(1200.0);
        System.out.println(rentalAgreementDAO.updateRentalAgreement(rentalAgreement));

        // Example of deleting a rental agreement
        System.out.println(rentalAgreementDAO.deleteRentalAgreement(1));

        // Example of getting a rental agreement
        RentalAgreement retrievedRentalAgreement = rentalAgreementDAO.getRentalAgreement(1);
        if (retrievedRentalAgreement != null) {
            System.out.println("Rental Agreement ID: " + retrievedRentalAgreement.getId());
            System.out.println("Application ID: " + retrievedRentalAgreement.getApplicationId());
            System.out.println("Start Date: " + retrievedRentalAgreement.getStartDate());
            System.out.println("End Date: " + retrievedRentalAgreement.getEndDate());
            System.out.println("Rent: " + retrievedRentalAgreement.getRent());
            System.out.println("Security Deposit: " + retrievedRentalAgreement.getSecurityDeposit());
        } else {
            System.out.println("Rental agreement not found");
        }

        // Example of using SystemSettingsDAO
        SystemSettingsDAO systemSettingsDAO = new SystemSettingsDAO();
        SystemSettings systemSettings = new SystemSettings("admin_email", "admin@example.com");
        System.out.println(systemSettingsDAO.createSystemSettings(systemSettings));

        // Example of updating a system setting
        systemSettings.setSettingValue("new_admin@example.com");
        System.out.println(systemSettingsDAO.updateSystemSettings(systemSettings));

        // Example of deleting a system setting
        System.out.println(systemSettingsDAO.deleteSystemSettings("admin_email"));

        // Example of getting a system setting
        SystemSettings retrievedSystemSettings = systemSettingsDAO.getSystemSettings("admin_email");
        if (retrievedSystemSettings != null) {
            System.out.println("Setting Name: " + retrievedSystemSettings.getSettingName());
            System.out.println("Setting Value: " + retrievedSystemSettings.getSettingValue());
        } else {
            System.out.println("System setting not found");
        }
    }
}