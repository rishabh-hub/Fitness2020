package com.example.fitness2020.Models;

public class GymOfferingModel {
    private String offeringName;
    private String oneClassName;
    private String oneClassPtsAfter;
    private String oneMonthPriceAfter;

    public GymOfferingModel(String offeringName, String oneClassName, String oneClassPtsAfter, String oneMonthPriceAfter) {
        this.offeringName = offeringName;
        this.oneClassName = oneClassName;
        this.oneClassPtsAfter = oneClassPtsAfter;
        this.oneMonthPriceAfter = oneMonthPriceAfter;
    }

    public String getOfferingName() {
        return offeringName;
    }

    public void setOfferingName(String offeringName) {
        this.offeringName = offeringName;
    }

    public String getOneClassName() {
        return oneClassName;
    }

    public void setOneClassName(String oneClassName) {
        this.oneClassName = oneClassName;
    }


    public String getOneClassPtsAfter() {
        return oneClassPtsAfter;
    }

    public void setOneClassPtsAfter(String oneClassPtsAfter) {
        this.oneClassPtsAfter = oneClassPtsAfter;
    }



    public String getOneMonthPriceAfter() {
        return oneMonthPriceAfter;
    }

    public void setOneMonthPriceAfter(String oneMonthPriceAfter) {
        this.oneMonthPriceAfter = oneMonthPriceAfter;
    }
}
