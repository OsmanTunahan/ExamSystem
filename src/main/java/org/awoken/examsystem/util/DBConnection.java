package org.awoken.examsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/exam_system";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            Logger logger = Logger.getLogger(DBConnection.class.getName());
            logger.log(Level.SEVERE, "Database connection failed!", e);
            throw new RuntimeException("Database connection failed!", e);
        }
    }
}