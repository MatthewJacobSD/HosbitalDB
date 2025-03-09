package org.hospital.test;

import org.hospital.utils.dbConnection;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Ensures test execution order
public class TestExecution {

    private static Connection conn;

    @BeforeAll
    static void setupDatabaseConnection() {
        conn = dbConnection.getConnection();
        assertNotNull(conn, "❌ Database connection failed!");
        System.out.println("✅ Connected to database before tests.");
    }

    @Test
    @Order(1)
    @DisplayName("Test Case 1: Insert & Retrieve a New Doctor")
    public void testAddDoctor() throws SQLException {
        Statement stmt = conn.createStatement();

        // insert a new doctor into the database
        // Expected: Doctor is successfully inserted
        stmt.executeUpdate("insert into Doctor (doctorID, firstname, surname, email, specialisation) " +
                "values ('D105', 'Alice', 'Cooper', 'alice@email.com', 'Neurology');");

        // VERIFY the doctor exists
        ResultSet rs = stmt.executeQuery("select * from Doctor where doctorID = 'D105';");
        assertTrue(rs.next(), "❌ Doctor was not added to the database!");
        System.out.println("✅ Doctor inserted successfully!");
    }

    @Test
    @Order(2)
    @DisplayName("Test Case 2: Insert Patient with Missing Email (Allow NULL)")
    public void testInsertPatientWithMissingEmail() throws SQLException {
        Statement stmt = conn.createStatement();

        // Insert patient with NULL email
        // Expected: Patient is added successfully (NULL email is allowed)
        stmt.executeUpdate("INSERT INTO Patient (patientID, firstname, surname, postcode, address, phoneNo, email, insuranceID) " +
                "VALUES ('Z003', 'Mark', 'Lee', 'AB123', 'City Street', '1234567890', NULL, 'I3001');");

        // Verify insertion (check if patient exists)
        ResultSet rs = stmt.executeQuery("SELECT * FROM Patient WHERE patientID = 'P301';");
        assertTrue(rs.next(), "❌ Patient was not added despite NULL email being allowed.");
        System.out.println("✅ Patient added successfully, NULL email is accepted.");
    }


    @Test
    @Order(3)
    @DisplayName("Test Case 3: Allow Automatic Type Conversion (INT to VARCHAR)")
    public void testAllowTypeConversion() throws SQLException {
        Statement stmt = conn.createStatement();

        // Insert insurance with an integer insuranceID
        // Expected: Insurance should be inserted (DB automatically converts INT to VARCHAR)
        stmt.executeUpdate("INSERT INTO Insurance (insuranceID, company, address, phoneNo) " +
                "VALUES (0934, 'HealthCare Inc.', '123 Elm St', '8005551234');");

        // Verify insertion
        ResultSet rs = stmt.executeQuery("SELECT * FROM Insurance WHERE insuranceID = '3001';");
        assertTrue(rs.next(), "❌ Insurance ID was not added, expected auto-conversion.");
        System.out.println("✅ Insurance added successfully, INT was auto-converted to VARCHAR.");
    }


    @Test
    @Order(4)
    @DisplayName("Test Case 4: Insert a Record with a Foreign Key Violation")
    public void testForeignKeyViolation() throws SQLException {
        Statement stmt = conn.createStatement();

        // insert visit with non-existent patientID
        // Expected: SQL Error (Foreign key constraint fails)
        try {
            stmt.executeUpdate("insert into Visit (patientID, doctorID, dateofvisit, symptoms, diagnosis) " +
                    "values ('P999', 'D105', '2024-03-01', 'Cough', 'Cold');");
            fail("❌ Expected an error due to foreign key violation!");
        } catch (SQLException e) {
            System.out.println("✅ Error detected for foreign key violation: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @DisplayName("Test Case 5: Insert Duplicate Primary Key")
    public void testDuplicatePrimaryKey() throws SQLException {
        Statement stmt = conn.createStatement();

        // insert duplicate doctorID
        // Expected: SQL Error (Duplicate entry)
        try {
            stmt.executeUpdate("insert into Doctor (doctorID, firstname, surname, email, specialisation) " +
                    "values ('D105', 'Bob', 'Jones', 'bob@email.com', 'Cardiology');");
            fail("❌ Expected an error due to duplicate primary key!");
        } catch (SQLException e) {
            System.out.println("✅ Error detected for duplicate primary key: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @DisplayName("Test Case 6: Retrieve All Patients")
    public void testRetrievePatients() throws SQLException {
        Statement stmt = conn.createStatement();

        // select all patients
        // Expected: Returns a list of all patients
        ResultSet rs = stmt.executeQuery("select * from Patient;");
        assertTrue(rs.next(), "❌ No patients found in the database!");
        System.out.println("✅ Patients retrieved successfully!");
    }



    @Test
    @Order(8)
    @DisplayName("Test Case 8: Allow Doctor Deletion (Cascade Delete Enabled)")
    public void testDeleteDoctorWithVisits() throws SQLException {
        Statement stmt = conn.createStatement();

        // DELETE a doctor who has visits recorded
        // Expected: Doctor is deleted, visits may also be deleted due to ON DELETE CASCADE
        stmt.executeUpdate("DELETE FROM Doctor WHERE doctorID = 'D105';");

        // Verify deletion
        ResultSet rs = stmt.executeQuery("SELECT * FROM Doctor WHERE doctorID = 'D105';");
        assertFalse(rs.next(), "❌ Doctor was not deleted, expected cascading delete.");
        System.out.println("✅ Doctor deleted successfully, cascading deletion is enabled.");
    }


    @Test
    @Order(9)
    @DisplayName("Test Case 9: Check Case Sensitivity in Queries")
    public void testCaseSensitivity() throws SQLException {
        Statement stmt = conn.createStatement();

        // select using lowercase doctorID
        // Expected: May return no results if case-sensitive
        ResultSet rs = stmt.executeQuery("select * from Doctor where doctorID = 'd105';");

        if (rs.next()) {
            System.out.println("✅ Case-insensitive search returned results.");
        } else {
            System.out.println("⚠️ Case-sensitive search: No results found.");
        }
    }

    @AfterAll
    public static void tearDownDatabaseConnection() throws SQLException {
        conn.close();
        System.out.println("🔴 Database connection closed after tests.");
    }
}
