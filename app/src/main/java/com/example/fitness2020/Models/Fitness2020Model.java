package com.example.fitness2020.Models;

public class Fitness2020Model {
    private int imageId;
    private String membershipName;
    private String code;
    private String price;
    private String freeTrialExpiry;
    private String webinarExpiry;
    private String vouchersExpiry;
    private String pointsExpiry;
    private String contactNo;
    private String autoDebitDate;

    public Fitness2020Model(int imageId, String membershipName, String code, String price, String freeTrialExpiry, String webinarExpiry, String vouchersExpiry, String pointsExpiry, String contactNo, String autoDebitDate) {
        this.imageId = imageId;
        this.membershipName = membershipName;
        this.code = code;
        this.price = price;
        this.freeTrialExpiry = freeTrialExpiry;
        this.webinarExpiry = webinarExpiry;
        this.vouchersExpiry = vouchersExpiry;
        this.pointsExpiry = pointsExpiry;
        this.contactNo = contactNo;
        this.autoDebitDate = autoDebitDate;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFreeTrialExpiry() {
        return freeTrialExpiry;
    }

    public void setFreeTrialExpiry(String freeTrialExpiry) {
        this.freeTrialExpiry = freeTrialExpiry;
    }

    public String getWebinarExpiry() {
        return webinarExpiry;
    }

    public void setWebinarExpiry(String webinarExpiry) {
        this.webinarExpiry = webinarExpiry;
    }

    public String getVouchersExpiry() {
        return vouchersExpiry;
    }

    public void setVouchersExpiry(String vouchersExpiry) {
        this.vouchersExpiry = vouchersExpiry;
    }

    public String getPointsExpiry() {
        return pointsExpiry;
    }

    public void setPointsExpiry(String pointsExpiry) {
        this.pointsExpiry = pointsExpiry;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAutoDebitDate() {
        return autoDebitDate;
    }

    public void setAutoDebitDate(String autoDebitDate) {
        this.autoDebitDate = autoDebitDate;
    }
}
