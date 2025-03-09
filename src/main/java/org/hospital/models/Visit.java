package org.hospital.models;

import java.time.LocalDate;

public class Visit {
    private String patientID;
    private String doctorID;
    private LocalDate date;
    private String symptoms;
    private String diagnosis;

    public Visit(String patientID, String doctorID, LocalDate date, String symptoms, String diagnosis) {
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.date = date;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
    }

    //Getters % Setters

    //date of visit
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    //symptoms
    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    //diagnosis
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    //ForeignKeys

    //patientID
    public String getPatientID() { return patientID; }
    public void setPatientID(String patientID) { this.patientID = patientID; }

    //doctorID
    public String getDoctorID() { return doctorID; }
    public void setDoctorID(String doctorID) { this.doctorID = doctorID; }
}
