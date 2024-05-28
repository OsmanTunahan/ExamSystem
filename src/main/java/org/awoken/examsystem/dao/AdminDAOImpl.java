package org.awoken.examsystem.dao;

import org.awoken.examsystem.model.Admin;
import org.awoken.examsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class AdminDAOImpl implements AdminDAO {
    private static final Logger LOGGER = Logger.getLogger(StudentDAOImpl.class.getName());

    @Override
    public Admin getAdminByUsername(String username) {
        String sql = "SELECT * FROM admins WHERE username=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                return admin;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to get admin", e);
        }
        return null;
    }
}
