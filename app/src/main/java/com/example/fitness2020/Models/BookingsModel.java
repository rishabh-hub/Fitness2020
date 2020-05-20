package com.example.fitness2020.Models;

public class BookingsModel {

    private int imageId;
    private int bookingId;
    private String code;
    private String purchaseDate;
    private String productName;
    private String status;
    private String address1;
    private String address2;
    private String contact1;
    private String contact2;
    private String purchaseDetails;

    public BookingsModel(int bookingId, String code, String purchaseDate, String productName, String status, String address1, String address2, String contact1, String contact2, String purchaseDetails, int imageId) {
        this.bookingId = bookingId;
        this.code = code;
        this.purchaseDate = purchaseDate;
        this.productName = productName;
        this.status = status;
        this.address1 = address1;
        this.address2 = address2;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.purchaseDetails = purchaseDetails;
        this.imageId=imageId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(String purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
