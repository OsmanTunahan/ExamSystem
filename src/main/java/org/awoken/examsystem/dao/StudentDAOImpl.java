package org.awoken.examsystem.dao;

import org.awoken.examsystem.model.Student;
import org.awoken.examsystem.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAOImpl implements StudentDAO {
    private static final Logger LOGGER = Logger.getLogger(StudentDAOImpl.class.getName());

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, rollNo, section, branch, year) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            setStudentParameters(preparedStatement, student);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to add student", e);
        }
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, rollNo=?, section=?, branch=?, year=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            setStudentParameters(preparedStatement, student);
            preparedStatement.setInt(6, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to update student", e);
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to delete student", e);
        }
    }

    @Override
    public Student getStudentById(int studentId) {
        String sql = "SELECT * FROM students WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return extractStudentFromResultSet(rs);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to retrieve student by id", e);
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student student = extractStudentFromResultSet(rs);
                students.add(student);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to retrieve students", e);
        }
        return students;
    }

    private Student extractStudentFromResultSet(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setRollNo(rs.getString("rollNo"));
        student.setSection(rs.getString("section"));
        student.setBranch(rs.getString("branch"));
        student.setYear(rs.getInt("year"));
        return student;
    }


    private void setStudentParameters(PreparedStatement preparedStatement, Student student) throws SQLException {
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getRollNo());
        preparedStatement.setString(3, student.getSection());
        preparedStatement.setString(4, student.getBranch());
        preparedStatement.setInt(5, student.getYear());
    }
}