package org.hospital.models;

import java.time.LocalDate;

public class Prescription {
    private String prescriptionID;
    private LocalDate prescription;
    private int dosage;
    private int duration;
    private String comment;
    private String drugID;
    private String doctorID;
    private String patientID;

    public Prescription(String prescriptionID, LocalDate prescription, int dosage, int duration, String comment, String drugID, String doctorID, String patientID) {
        this.prescriptionID = prescriptionID;
        this.prescription = prescription;
        this.dosage = dosage;
        this.duration = duration;
        this.comment = comment;
        this.drugID = drugID;
        this.doctorID = doctorID;
        this.patientID = patientID;
    }

    //Getters and Setters

    //prescription
    public String getPrescriptionID() { return prescriptionID; }
    public void setPrescriptionID(String prescriptionID) { this.prescriptionID = prescriptionID; }

    //date of prescription
    public LocalDate getPrescription() { return prescription; }
    public void setPrescription(LocalDate prescription) { this.prescription = prescription; }

    //dosage
    public int getDosage() { return dosage; }
    public void setDosage(int dosage) { this.dosage = dosage; }

    //duration
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    //comment
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    //foreignKeys

    //drugID
    public String getDrugID() { return drugID; }
    public void setDrugID(String drugID) { this.drugID = drugID; }

    //doctor
    public String getDoctorID() { return doctorID; }
    public void setDoctorID(String doctorID) { this.doctorID = doctorID; }

    //patient
    public String getPatientID() { return patientID; }
    public void setPatient(String patientID) { this.patientID = patientID; }
}
