package org.hospital.models;

//child class from Doctor
public class Specialist extends Doctor{
    private String education;

    public Specialist(String doctorID, String firstname, String surname, String email, String specialization, String education) {
        super(doctorID, firstname, surname, email, specialization);
        this.education = education;
    }

    //Getters and Setters

    //education
    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }
}
