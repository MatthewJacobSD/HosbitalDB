package org.hospital.models;

public class Insurance {
    private String insuranceID;
    private String company;
    private String address;
    private String phoneNo;

    public Insurance(String insuranceID, String company, String address, String phoneNo) {
        this.insuranceID = insuranceID;
        this.company = company;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    //Getters & Setters

    //insurance - primary key
    public String getInsuranceID() { return insuranceID; }
    public void setInsuranceID(String insuranceID) { this.insuranceID = insuranceID; }

    //company
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    //address
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address;}

    //phone
    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
}
