package com.example.fitness2020.Models;

public class GymOfferingModel {
    private String offeringName;
    private String oneClassName;
    private String oneClassPtsBefore;
    private String oneClassPtsAfter;
    private String oneMonthPriceBefore;
    private String oneMonthPriceAfter;

    public GymOfferingModel(String offeringName, String oneClassName, String oneClassPtsBefore, String oneClassPtsAfter, String oneMonthPriceBefore, String oneMonthPriceAfter) {
        this.offeringName = offeringName;
        this.oneClassName = oneClassName;
        this.oneClassPtsBefore = oneClassPtsBefore;
        this.oneClassPtsAfter = oneClassPtsAfter;
        this.oneMonthPriceBefore = oneMonthPriceBefore;
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

    public String getOneClassPtsBefore() {
        return oneClassPtsBefore;
    }

    public void setOneClassPtsBefore(String oneClassPtsBefore) {
        this.oneClassPtsBefore = oneClassPtsBefore;
    }

    public String getOneClassPtsAfter() {
        return oneClassPtsAfter;
    }

    public void setOneClassPtsAfter(String oneClassPtsAfter) {
        this.oneClassPtsAfter = oneClassPtsAfter;
    }

    public String getOneMonthPriceBefore() {
        return oneMonthPriceBefore;
    }

    public void setOneMonthPriceBefore(String oneMonthPriceBefore) {
        this.oneMonthPriceBefore = oneMonthPriceBefore;
    }

    public String getOneMonthPriceAfter() {
        return oneMonthPriceAfter;
    }

    public void setOneMonthPriceAfter(String oneMonthPriceAfter) {
        this.oneMonthPriceAfter = oneMonthPriceAfter;
    }
}
