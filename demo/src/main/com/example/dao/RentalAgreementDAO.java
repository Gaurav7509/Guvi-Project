package example.dao;

import example.model.RentalAgreement;
import example.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RentalAgreementDAO {
    public String createRentalAgreement(RentalAgreement rentalAgreement) {
        String sql = "INSERT INTO rental_agreements (application_id, start_date, end_date, rent, security_deposit) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rentalAgreement.getApplicationId());
            pstmt.setDate(2, rentalAgreement.getStartDate());
            pstmt.setDate(3, rentalAgreement.getEndDate());
            pstmt.setBigDecimal(4, rentalAgreement.getRent());
            pstmt.setBigDecimal(5, rentalAgreement.getSecurityDeposit());
            pstmt.executeUpdate();
            return "Rental agreement created successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating rental agreement: " + e.getMessage();
        }
    }

    public String updateRentalAgreement(RentalAgreement rentalAgreement) {
        String sql = "UPDATE rental_agreements SET start_date = ?, end_date = ?, rent = ?, security_deposit = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, rentalAgreement.getStartDate());
            pstmt.setDate(2, rentalAgreement.getEndDate());
            pstmt.setBigDecimal(3, rentalAgreement.getRent());
            pstmt.setBigDecimal(4, rentalAgreement.getSecurityDeposit());
            pstmt.setInt(5, rentalAgreement.getId());
            pstmt.executeUpdate();
            return "Rental agreement updated successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error updating rental agreement: " + e.getMessage();
        }
    }

    public String deleteRentalAgreement(int id) {
        String sql = "DELETE FROM rental_agreements WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return "Rental agreement deleted successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error deleting rental agreement: " + e.getMessage();
        }
    }

    public RentalAgreement getRentalAgreement(int id) {
        String sql = "SELECT * FROM rental_agreements WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                RentalAgreement rentalAgreement = new RentalAgreement();
                rentalAgreement.setId(rs.getInt("id"));
                rentalAgreement.setApplicationId(rs.getInt("application_id"));
                rentalAgreement.setStartDate(rs.getDate("start_date"));
                rentalAgreement.setEndDate(rs.getDate("end_date"));
                rentalAgreement.setRent(rs.getBigDecimal("rent"));
                rentalAgreement.setSecurityDeposit(rs.getBigDecimal("security_deposit"));
                return rentalAgreement;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}