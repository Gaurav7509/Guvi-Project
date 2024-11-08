package dao;

import model.Property;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyDao {
    private static final String URL = "jdbc:mysql://localhost:3306/RealEstateDB";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public List<Property> getAllProperties() {
        List<Property> properties = new ArrayList<>();
        String query = "SELECT * FROM Property";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Property property = new Property();
                property.setId(rs.getInt("id"));
                property.setName(rs.getString("name"));
                property.setLocation(rs.getString("location"));
                property.setPrice(rs.getDouble("price"));
                property.setArea(rs.getFloat("area"));
                properties.add(property);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public void addProperty(Property property) {
        String query = "INSERT INTO Property (name, location, price, area) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, property.getName());
            pstmt.setString(2, property.getLocation());
            pstmt.setDouble(3, property.getPrice());
            pstmt.setFloat(4, property.getArea());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
