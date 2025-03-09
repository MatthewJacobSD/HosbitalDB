package org.hospital.models;

public class Insured_Patient extends Patient{
    public String type;
    public String company_name;
    public String duration;

    public Insured_Patient(String patientID, String firstname, String surname, String postcode, String address, String phoneNo, String email, String insuranceID, String type, String company_name, String duration) {
        super(patientID, firstname, surname, postcode, address, phoneNo, email, insuranceID);
        this.type = type;
        this.company_name = company_name;
        this.duration = duration;
    }

    //Getters & Setters

    //type
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    //company name
    public String getCompany_name() { return company_name; }
    public void setCompany_name(String company_name) { this.company_name = company_name; }

    //duration
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration =  duration; }
}
