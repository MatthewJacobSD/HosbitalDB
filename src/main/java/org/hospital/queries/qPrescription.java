package org.hospital.queries;

import org.hospital.utils.dbConnection;
import org.hospital.models.Prescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class qPrescription {
    private static final Logger logger = LoggerFactory.getLogger(qPrescription.class);
    public static void addPrescription(Prescription prescription) throws SQLException {
        String sql = "insert into prescription(prescriptionID, dateprescribed, dosage, duration, comment, drugID, doctorID, patientID) values (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pt = conn.prepareStatement(sql)) {

            pt.setString(1, prescription.getPrescriptionID());
            pt.setDate(2, java.sql.Date.valueOf(prescription.getPrescription()));
            pt.setInt(3, prescription.getDosage());
            pt.setInt(4, prescription.getDuration());
            pt.setString(5, prescription.getComment());
            pt.setString(6, prescription.getDrugID());
            pt.setString(7, prescription.getDoctorID());
            pt.setString(8, prescription.getPatientID());

            int rows = pt.executeUpdate();
            if (rows > 0) { logger.info("✅ Prescription added successfully!"); }
        } catch (SQLException e) { logger.error("❌ An error occurred while adding a prescription: {}", e.getMessage()); }
    }
}
