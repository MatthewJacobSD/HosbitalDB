package org.hospital.queries;

import org.hospital.utils.dbConnection;
import org.hospital.models.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class qDoctor {
    private static final Logger logger = LoggerFactory.getLogger(qDoctor.class);

    public static void addDoctor(Doctor doctor) throws SQLException {
        String sql = "insert into Doctor (doctorID, firstname, surname, email, specialization) values (?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement pt = conn.prepareStatement(sql)) {

                pt.setString(1, doctor.getDoctorID());
                pt.setString(2, doctor.getFirstname());
                pt.setString(3, doctor.getSurname());
                pt.setString(4, doctor.getEmail());
                pt.setString(5, doctor.getSpecialization());

                int rows = pt.executeUpdate();
                if (rows > 0) { logger.info("✅ Doctor added successfully!"); }
            }
        } catch (SQLException e) { logger.error("❌ An error occurred while adding a doctor: {}", e.getMessage()); }
    }
}
