package com.example.fitness2020.Models;

public class MembershipModel {

    private int imageID;
    private String gymName;
    private String purchaseDate;
    private String order;
    private String amount;
    private String discount;
    private String amountPayable;
    private String membershipType;
    private String points;
    private String membershipTypeExpiry;
    private String pointsExpiry;



    public MembershipModel(int imageID, String gymName, String purchaseDate, String order, String amount, String discount, String amountPayable, String membershipType, String points, String membershipTypeExpiry, String pointsExpiry) {
        this.imageID = imageID;
        this.gymName = gymName;
        this.purchaseDate = purchaseDate;
        this.order = order;
        this.amount = amount;
        this.discount = discount;
        this.amountPayable = amountPayable;
        this.membershipType = membershipType;
        this.points = points;
        this.membershipTypeExpiry = membershipTypeExpiry;
        this.pointsExpiry = pointsExpiry;
    }
    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(String amountPayable) {
        this.amountPayable = amountPayable;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getMembershipTypeExpiry() {
        return membershipTypeExpiry;
    }

    public void setMembershipTypeExpiry(String membershipTypeExpiry) {
        this.membershipTypeExpiry = membershipTypeExpiry;
    }

    public String getPointsExpiry() {
        return pointsExpiry;
    }

    public void setPointsExpiry(String pointsExpiry) {
        this.pointsExpiry = pointsExpiry;
    }
}
