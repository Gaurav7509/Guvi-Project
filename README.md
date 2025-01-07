# 🏠 Real Estate Management System 🏢

## 🔍 Project Overview

The Real Estate Management System is a 🌐 web-based application designed to streamline 🏘️ property management, 🧑‍🤝‍🧑 user registration, 📜 rental agreements, and 💬 internal communication. It is developed using technologies like ☕ Java, 🗄️ MySQL, and Java EE for robust performance and scalability. It provides different roles such as 🛠️ Admin, 🏢 Property Manager, and 🏠 Tenant, each with specific functionalities.

---

## 📂 Project Structure

```
GUVI-PROJECT
|
|-- demo
|    |-- src
|         |-- main
|              |-- com\example
|               |-- dao/
|                   |-- ApplicationDAO.java
|                   |-- MessageDAO.java
|                   |-- PropertyDAO.java
|                   |-- RentalAgreementDAO.java
|                   |-- SystemSettingsDAO.java
|                   |-- UserDAO.java
|               |-- model/
|                   |-- Application.java
|                   |-- Message.java
|                   |-- Property.java
|                   |-- RentalAgreement.java
|                   |-- SystemSettings.java
|                   |-- User.java
|               |-- service/
|                   |-- PropertyService.java
|                   |-- UserService.java
|               |-- servlet/
|                   |-- LoginServlet.java
|                   |-- ProfileServlet.java
|                   |-- RegisterServlet.java
|               |-- util/
|                   |-- DatabaseUtil.java
|              |-- resources
|                   |-- css
|                        |-- style.css
|                   |-- js
|                        |-- script.js
|                   |-- templates
|                        |-- index.html
|                        |-- login.html
|                        |-- register.html
|                        |-- user-profile.html
|              |-- webapp
|                   |-- WEB-INF
|                   |-- index.jsp
|                   |-- login.jsp
|                   |-- register.jsp
|                   |-- user-profile.jsp
|         |-- test\java\com\service
|              |-- PropertyServiceTest.java
|              |-- UserServiceTest.java
|         |-- real_estate_management.sql
|
|-- target
|-- pom.xml
```

---

## ⭐ Features

- **📝 User Registration & Login**: Allows users to 🔐 register, login, and manage profiles.
- **🏠 Property Management**: Adds, updates, and manages 🏘️ property listings.
- **📜 Rental Agreements**: Generates, updates, and tracks 📃 rental agreements.
- **💬 Messaging System**: Facilitates communication between 👨‍💼 tenants and 🏢 property managers.
- **⚙️ Role Management**: Different roles for 🛠️ Admin, 🏢 Property Manager, and 🏠 Tenant.

---

## 🗄️ Database Schema

The database schema for the project includes the following tables:

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    role ENUM('ADMIN', 'PROPERTY_MANAGER', 'TENANT') NOT NULL
);

CREATE TABLE properties (
    id INT AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255) NOT NULL,
    description TEXT,
    rent DECIMAL(10, 2) NOT NULL,
    status ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING'
);

CREATE TABLE system_settings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    setting_key VARCHAR(100) NOT NULL,
    setting_value VARCHAR(255) NOT NULL
);

CREATE TABLE rental_agreements (
    id INT AUTO_INCREMENT PRIMARY KEY,
    property_id INT,
    tenant_id INT,
    agreement_details TEXT,
    status ENUM('ACTIVE', 'TERMINATED') DEFAULT 'ACTIVE',
    FOREIGN KEY (property_id) REFERENCES properties(id),
    FOREIGN KEY (tenant_id) REFERENCES users(id)
);

CREATE TABLE messages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT,
    receiver_id INT,
    content TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sender_id) REFERENCES users(id),
    FOREIGN KEY (receiver_id) REFERENCES users(id)
);

CREATE TABLE applications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    property_id INT,
    tenant_id INT,
    application_details TEXT,
    status ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING',
    FOREIGN KEY (property_id) REFERENCES properties(id),
    FOREIGN KEY (tenant_id) REFERENCES users(id)
);
```

---

## 🚀 How to Run the Project

### 🛠️ Prerequisites

- ☕ Java Development Kit (JDK) 8 or later
- 🛠️ Apache Maven
- 🗄️ MySQL Database Server
- 🖥️ Any Java EE server (e.g., Tomcat)

### 📝 Steps to Run

1. **📥 Clone the Repository**

   ```bash
   git clone https://github.com/sah-aditya/real_estate_management_system.git
   cd real_estate_management_system
   ```

2. **📂 Import the Project**

   - Open the project in an IDE such as IntelliJ IDEA or Eclipse.
   - Ensure the project structure matches the one mentioned above.

3. **🗄️ Setup the Database**

   - Start your MySQL server.
   - Create a database named `real_estate_management`.
   - Run the `real_estate_management.sql` file located in the project directory to create the necessary tables.

   ```sql
   SOURCE path/to/real_estate_management.sql;
   ```

4. **⚙️ Configure Database Connection**

   - Open the `DatabaseUtil.java` file located in `com\example\util`.
   - Update the following variables with your database credentials:
     ```java
     private static final String URL = "jdbc:mysql://localhost:3306/real_estate_management";
     private static final String USER = "your-username";
     private static final String PASSWORD = "your-password";
     ```

5. **🛠️ Build the Project**

   - Use Maven to build the project:
     ```bash
     mvn clean install
     ```

6. **📤 Deploy the Application**

   - Deploy the generated WAR file located in the `target` folder to your Java EE server (e.g., Tomcat).
   - Start the server.

7. **🌐 Access the Application**

   - Open a 🌍 web browser and navigate to `http://localhost:8080/real_estate_management`.

---

## 🔧 Usage

### 🎭 Roles and Features

- **🛠️ Admin**:

  - Manage 🧑‍🤝‍🧑 users and roles.
  - Configure ⚙️ system settings.

- **🏢 Property Manager**:

  - Add and manage 🏘️ property listings.
  - Approve or reject 📄 applications.

- **🏠 Tenant**:

  - View 🏘️ properties.
  - Apply for 📜 rental agreements.

---

## 🌟 Frontend Features

The frontend consists of the following pages:

- **🏠 index.html**: Homepage of the application.
- **🔐 login.html**: User login page.
- **📝 register.html**: User registration page.
- **👤 user-profile.html**: User profile management.

Additionally, the JSP pages include:

- **🏠 index.jsp**: Dynamic homepage with user-specific content.
- **🔐 login.jsp**: Dynamic login page with backend integration.
- **📝 register.jsp**: Dynamic registration page with validation.
- **👤 user-profile.jsp**: Dynamic user profile page.

---

## ✅ Testing

Unit tests are located in the `test\java\com\service` directory. Use the following command to run the tests:

```bash
mvn test
```

---

## 🤝 Contributing

Contributions are welcome! Feel free to fork the repository and submit pull requests.

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

