package org.hospital.models;

public class Drug {
    private String drugID;
    private String name;
    private String side_effects;
    private String benefits;

    public Drug(String drugID, String name, String side_effects, String benefits){
        this.drugID = drugID;
        this.name = name;
        this.side_effects = side_effects;
        this.benefits = benefits;
    }

    //Getters & Setters

    //drugID - primary key
    public String getDrugID() { return drugID; }
    public void setDrugID(String drugID) { this.drugID = drugID; }

    //name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    //side effects
    public String getSide_effects() { return side_effects; }
    public void setSide_effects(String side_effects) { this.side_effects = side_effects; }

    //benefits
    public String getBenefits() { return benefits; }
    public void setBenefits(String benefits) { this.benefits = benefits; }
}
