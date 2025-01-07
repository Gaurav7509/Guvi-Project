package example.dao;

import example.model.SystemSettings;
import example.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SystemSettingsDAO {
    public String createSystemSettings(SystemSettings systemSettings) {
        String sql = "INSERT INTO system_settings (setting_name, setting_value) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, systemSettings.getSettingName());
            pstmt.setString(2, systemSettings.getSettingValue());
            pstmt.executeUpdate();
            return "System setting created successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating system setting: " + e.getMessage();
        }
    }

    public String updateSystemSettings(SystemSettings systemSettings) {
        String sql = "UPDATE system_settings SET setting_value = ? WHERE setting_name = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, systemSettings.getSettingValue());
            pstmt.setString(2, systemSettings.getSettingName());
            pstmt.executeUpdate();
            return "System setting updated successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error updating system setting: " + e.getMessage();
        }
    }

    public String deleteSystemSettings(String settingName) {
        String sql = "DELETE FROM system_settings WHERE setting_name = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, settingName);
            pstmt.executeUpdate();
            return "System setting deleted successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error deleting system setting: " + e.getMessage();
        }
    }

    public SystemSettings getSystemSettings(String settingName) {
        String sql = "SELECT * FROM system_settings WHERE setting_name = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, settingName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                SystemSettings systemSettings = new SystemSettings();
                systemSettings.setSettingName(rs.getString("setting_name"));
                systemSettings.setSettingValue(rs.getString("setting_value"));
                return systemSettings;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}