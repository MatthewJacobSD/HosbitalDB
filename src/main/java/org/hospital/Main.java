package org.hospital;

import org.hospital.ui.HospitalApp;
import org.hospital.utils.dbConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // Test Database Connection
        Connection conn = dbConnection.getConnection();
        if (conn != null) {
            System.out.println("\n🎉 Successfully connected to MariaDB!");
        } else {
            System.out.println("\n🚨 Connection failed. Check your credentials and database.");
        }

        // Launch the JavaFX application
        HospitalApp.main(args);
    }
}