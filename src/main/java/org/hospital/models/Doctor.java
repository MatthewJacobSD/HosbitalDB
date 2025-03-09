package org.hospital.models;

//Parent class Doctor
public class Doctor {

    //Columns
    private String doctorID;
    private String firstname;
    private String surname;
    private String email;
    private String specialization;

    public Doctor(String doctorID, String firstname, String surname, String email, String specialization) {
        this.doctorID = doctorID;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.specialization = specialization;
    }

    //Getters & Setters from Database

    //doctorID - primary key
    public String getDoctorID() { return doctorID; }
    public void setDoctorID(String doctorID) { this.doctorID = doctorID; }

    //firstname
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    //surname
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname= surname; }

    //email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    //child class, specialist - foreign key
    public String getSpecialization() { return specialization; }

}
