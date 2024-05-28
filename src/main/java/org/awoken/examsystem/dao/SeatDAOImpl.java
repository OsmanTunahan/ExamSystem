package org.awoken.examsystem.dao;

import org.awoken.examsystem.model.Seat;
import org.awoken.examsystem.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeatDAOImpl implements SeatDAO {
    private static final Logger LOGGER = Logger.getLogger(StudentDAOImpl.class.getName());

    @Override
    public void allocateSeat(Seat seat) {
        String sql = "INSERT INTO seats (studentId, seatNumber, examHall) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, seat.getStudentId());
            preparedStatement.setString(2, seat.getSeatNumber());
            preparedStatement.setString(3, seat.getExamHall());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to allocate seat", e);
        }
    }

    @Override
    public void updateSeat(Seat seat) {
        String sql = "UPDATE seats SET studentId=?, seatNumber=?, examHall=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, seat.getStudentId());
            preparedStatement.setString(2, seat.getSeatNumber());
            preparedStatement.setString(3, seat.getExamHall());
            preparedStatement.setInt(4, seat.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to update seat", e);
        }
    }

    @Override
    public void deleteSeat(int seatId) {
        String sql = "DELETE FROM seats WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, seatId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to delete seat", e);
        }
    }

    @Override
    public Seat getSeatById(int seatId) {
        String sql = "SELECT * FROM seats WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, seatId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Seat seat = new Seat();
                seat.setId(rs.getInt("id"));
                seat.setStudentId(rs.getInt("studentId"));
                seat.setSeatNumber(rs.getString("seatNumber"));
                seat.setExamHall(rs.getString("examHall"));
                return seat;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to get seat by id", e);
        }
        return null;
    }

    @Override
    public List<Seat> getAllSeats() {
        List<Seat> seats = new ArrayList<>();
        String sql = "SELECT * FROM seats";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Seat seat = new Seat();
                seat.setId(rs.getInt("id"));
                seat.setStudentId(rs.getInt("studentId"));
                seat.setSeatNumber(rs.getString("seatNumber"));
                seat.setExamHall(rs.getString("examHall"));
                seats.add(seat);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to get all seats", e);
        }
        return seats;
    }
}