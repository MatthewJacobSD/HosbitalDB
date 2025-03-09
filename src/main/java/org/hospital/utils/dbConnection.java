package org.hospital.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static final Logger logger = LoggerFactory.getLogger(dbConnection.class);

    private static final String URL = "jdbc:mariadb://localhost:3306/Hospital"; // Check if "Hospital" is your correct DB name
    private static final String USER = "root";  // Ensure this is your correct username
    private static final String PASSWORD = "root";  // Ensure this is your correct password

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("\n✅ Database connected successfully!");
            return conn;
        } catch (SQLException e) {
            logger.error("\n❌ Database connection failed! \n The causes are this: {}", e.getMessage());
            return null;
        }
    }
}
