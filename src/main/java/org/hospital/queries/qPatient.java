package org.hospital.queries;

import org.hospital.utils.dbConnection;
import org.hospital.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class qPatient {
private static final Logger logger = LoggerFactory.getLogger(qPatient.class);
    public static void addPatient(Patient patient) throws SQLException {
        String sql = "insert into Patient (PatientID, firstname, surname, postcode, address, phoneNo, email, insuranceID) values (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pt = conn.prepareStatement(sql)) {

            pt.setString(1, patient.getPatientID());
            pt.setString(2, patient.getFirstname());
            pt.setString(3, patient.getSurname());
            pt.setString(4, patient.getPostcode());
            pt.setString(5, patient.getAddress());
            pt.setString(6, patient.getPhoneNo());
            pt.setString(7, patient.getEmail());
            pt.setString(8, patient.getInsuranceID());

            int rows = pt.executeUpdate();
            if (rows > 0) {
                logger.info("✅ Patient added successfully!");
            }
        } catch (SQLException e) { logger.error("❌ An error occurred while adding a patient: {}", e.getMessage()); }
    }
}
