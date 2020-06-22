package com.example.fitness2020.Models;

public class GymMembershipModel {
    int imageId;
    private String memberShipName;
    private String gymName;
    private String price;
    private String startDate;
    private String endDate;
    private String contactNo;
    private String gymAddress;

    public GymMembershipModel(int imageId, String memberShipName, String gymName, String price, String startDate, String endDate, String contactNo, String gymAddress) {
        this.imageId = imageId;
        this.memberShipName = memberShipName;
        this.gymName = gymName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contactNo = contactNo;
        this.gymAddress = gymAddress;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getMemberShipName() {
        return memberShipName;
    }

    public void setMemberShipName(String memberShipName) {
        this.memberShipName = memberShipName;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getGymAddress() {
        return gymAddress;
    }

    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }
}
