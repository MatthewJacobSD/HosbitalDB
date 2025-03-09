package org.hospital.queries;

import org.hospital.utils.dbConnection;
import org.hospital.models.Insurance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class qInsurance {
    private static final Logger logger = LoggerFactory.getLogger(qInsurance.class);

    public static void addInsurance(Insurance insurance) throws SQLException {
        String sql = "insert into Insurance (insuranceID, company, address, phoneNo) values (?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pt = conn.prepareStatement(sql)) {

            pt.setString(1, insurance.getInsuranceID());
            pt.setString(2, insurance.getCompany());
            pt.setString(3, insurance.getAddress());
            pt.setString(4, insurance.getPhoneNo());

            int rows = pt.executeUpdate();
            if (rows > 0) {
                logger.info("✅ Insurance added successfully!");
            }
        } catch (SQLException e) { logger.error("❌ An error occurred while adding a insurance: {}", e.getMessage()); }
    }
}
