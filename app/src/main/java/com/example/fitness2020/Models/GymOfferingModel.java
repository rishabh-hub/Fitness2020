package com.example.fitness2020.Models;

public class GymOfferingModel {
    private String offeringName;
    private String offeringPrice;
    private String offeringActivity;

    public GymOfferingModel(String offeringName, String offeringPrice,String offeringActivity) {
        this.offeringName = offeringName;
        this.offeringPrice = offeringPrice;
        this.offeringActivity = offeringActivity;
    }

    public String getOfferingActivity() {
        return offeringActivity;
    }

    public void setOfferingActivity(String offeringActivity) {
        this.offeringActivity = offeringActivity;
    }

    public String getOfferingName() {
        return offeringName;
    }

    public void setOfferingName(String offeringName) {
        this.offeringName = offeringName;
    }

    public String getOfferingPrice() {
        return offeringPrice;
    }

    public void setOfferingPrice(String offeringPrice) {
        this.offeringPrice = offeringPrice;
    }
}
