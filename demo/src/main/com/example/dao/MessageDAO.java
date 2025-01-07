package  example.dao;

import example.model.Message;
import example.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDAO {
    public String createMessage(Message message) {
        String sql = "INSERT INTO messages (sender_id, receiver_id, message_text, created_at) VALUES (?, ?, ?, NOW())";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, message.getSenderId());
            pstmt.setInt(2, message.getReceiverId());
            pstmt.setString(3, message.getMessageText());
            pstmt.executeUpdate();
            return "Message created successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating message: " + e.getMessage();
        }
    }

    public String updateMessage(Message message) {
        String sql = "UPDATE messages SET message_text = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, message.getMessageText());
            pstmt.setInt(2, message.getId());
            pstmt.executeUpdate();
            return "Message updated successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error updating message: " + e.getMessage();
        }
    }

    public String deleteMessage(int id) {
        String sql = "DELETE FROM messages WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return "Message deleted successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error deleting message: " + e.getMessage();
        }
    }

    public Message getMessage(int id) {
        String sql = "SELECT * FROM messages WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("id"));
                message.setSenderId(rs.getInt("sender_id"));
                message.setReceiverId(rs.getInt("receiver_id"));
                message.setMessageText(rs.getString("message_text"));
                message.setCreatedAt(rs.getTimestamp("created_at"));
                return message;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public java.util.List<Message> getMessages(int userId) {
        String sql = "SELECT * FROM messages WHERE sender_id = ? OR receiver_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, userId);
            ResultSet rs = pstmt.executeQuery();
            java.util.List<Message> messages = new java.util.ArrayList<>();
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("id"));
                message.setSenderId(rs.getInt("sender_id"));
                message.setReceiverId(rs.getInt("receiver_id"));
                message.setMessageText(rs.getString("message_text"));
                message.setCreatedAt(rs.getTimestamp("created_at"));
                messages.add(message);
            }
            return messages;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}