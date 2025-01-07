package example.dao;

import example.model.Application;
import example.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationDAO {
    public String createApplication(Application application) {
        String sql = "INSERT INTO applications (property_id, user_id, status, created_at, updated_at) VALUES (?, ?, ?, NOW(), NOW())";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, application.getPropertyId());
            pstmt.setInt(2, application.getUserId());
            pstmt.setString(3, application.getStatus());
            pstmt.executeUpdate();
            return "Application created successfully: " + application.getPropertyId();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating application: " + e.getMessage();
        }
    }

    public String updateApplication(Application application) {
        String sql = "UPDATE applications SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, application.getStatus());
            pstmt.setInt(2, application.getId());
            pstmt.executeUpdate();
            return "Application updated successfully: " + application.getId();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error updating application: " + e.getMessage();
        }
    }

    public String deleteApplication(int id) {
        String sql = "DELETE FROM applications WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return "Application deleted successfully: " + id;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error deleting application: " + e.getMessage();
        }
    }

    public Application getApplication(int id) {
        String sql = "SELECT * FROM applications WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Application application = new Application();
                application.setId(rs.getInt("id"));
                application.setPropertyId(rs.getInt("property_id"));
                application.setUserId(rs.getInt("user_id"));
                application.setStatus(rs.getString("status"));
                application.setCreatedAt(rs.getDate("created_at"));
                application.setUpdatedAt(rs.getDate("updated_at"));
                return application;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}