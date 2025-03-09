package org.hospital.queries;

import org.hospital.utils.dbConnection;
import org.hospital.models.Visit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class qVisit {
    private static final Logger logger = LoggerFactory.getLogger(qVisit.class);

    public static void addVisit(Visit visit) throws SQLException {
        String sql = "insert into Visit (patientID, doctorID, dateofvisit, symptoms, diagnosis) values (?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pt = conn.prepareStatement(sql)) {

            pt.setString(1, visit.getPatientID());
            pt.setString(2, visit.getDoctorID());
            pt.setDate(3, java.sql.Date.valueOf(visit.getDate()));
            pt.setString(4, visit.getSymptoms());
            pt.setString(5, visit.getDiagnosis());

            int rows = pt.executeUpdate();
            if (rows > 0) { logger.info("✅ Visit added successfully!"); }
        } catch (SQLException e) { logger.error("❌ An error occurred while adding a visit: {}", e.getMessage()); }
    }
}
