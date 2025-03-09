package org.hospital.queries;

import org.hospital.utils.dbConnection;
import org.hospital.models.Drug;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class qDrug {
    private static final Logger logger = LoggerFactory.getLogger(qDrug.class);

    public static void addDrug(Drug drug) throws SQLException {
        String sql = "insert into Drug (drugID, name, sideeffects, benefits) values (?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pt = conn.prepareStatement(sql)) {

            pt.setString(1, drug.getDrugID());
            pt.setString(2, drug.getName());
            pt.setString(3, drug.getSide_effects());
            pt.setString(4, drug.getBenefits());

            int rows = pt.executeUpdate();
            if (rows > 0) { logger.info("✅ Drug added successfully!"); }
        } catch (SQLException e) { logger.error("❌ An error occurred while adding a drug: {}", e.getMessage()); }
    }
}
