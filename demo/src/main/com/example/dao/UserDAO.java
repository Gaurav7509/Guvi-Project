package example.dao;

import example.model.User;
import example.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public String createUser (User user) {
        String sql = "INSERT INTO users (name, email, role) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getRole());
            pstmt.executeUpdate();
            return "User  created successfully: " + user.getName();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating user: " + e.getMessage();
        }
    }

    public String updateUser (User user) {
        String sql = "UPDATE users SET name = ?, email = ?, role = ? WHERE email = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getRole());
            pstmt.setString(4, user.getEmail());
            pstmt.executeUpdate();
            return "User  updated successfully: " + user.getName();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error updating user: " + e.getMessage();
        }
    }

    public User getUser(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String deleteUser (String email) {
        String sql = "DELETE FROM users WHERE email = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.executeUpdate();
            return "User  deleted successfully: " + email;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error deleting user: " + e.getMessage();
        }
    }
}