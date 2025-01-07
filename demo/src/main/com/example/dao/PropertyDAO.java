package example.dao;

import example.model.Property;
import example.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyDAO {
    public String createProperty(Property property) {
        String sql = "INSERT INTO properties (address, description, rent) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, property.getAddress());
            pstmt.setString(2, property.getDescription());
            pstmt.setBigDecimal(3, property.getRent());
            pstmt.executeUpdate();
            return "Property listed successfully: " + property.getAddress();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error listing property: " + e.getMessage();
        }
    }

    public String approveProperty(int propertyId) {
        String sql = "UPDATE properties SET status = 'APPROVED' WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, propertyId);
            pstmt.executeUpdate();
            return "Property approved successfully: " + propertyId;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error approving property: " + e.getMessage();
        }
    }

    public String rejectProperty(int propertyId) {
        String sql = "UPDATE properties SET status = 'REJECTED' WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, propertyId);
            pstmt.executeUpdate();
            return "Property rejected successfully: " + propertyId;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error rejecting property: " + e.getMessage();
        }
    }
}