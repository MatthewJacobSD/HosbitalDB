package org.hospital.models;

public class Patient {
    private String patientID;
    private String firstname;
    private String surname;
    private String postcode;
    private String address;
    private String phoneNo;
    private String email;
    private String insuranceID;

    public Patient(String patientID, String firstname, String surname, String postcode, String address, String phoneNo, String email, String insuranceID) {
        this.patientID = patientID;
        this.firstname = firstname;
        this.surname = surname;
        this.postcode = postcode;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
        this.insuranceID = insuranceID;
    }

    //Getters & Setters

    //patientID - primary key
    public String getPatientID() { return patientID; }
    public void setPatientID(String patientID) { this.patientID = patientID;}

    //firstname
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    //surname
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    //postcode
    public String getPostcode() { return postcode; }
    public void setPostcode(String postcode) { this.postcode = postcode; }

    //address
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address;}

    //phoneNo
    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    //email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    //insuranceID - foreignKey
    public String getInsuranceID() { return insuranceID; }
    public void setInsuranceID(String insuranceID) { this.insuranceID = insuranceID; }

}
