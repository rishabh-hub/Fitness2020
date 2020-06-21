package com.example.fitness2020.Models;

public class BookingsModel {

    private int imageId;
    private int bookingId;
    private String code;
    private String purchaseDate;
    private String productName;
    private String status;
    private String address2;
    private String contact1;
    private String activity;
    private String time;
    private String purchaseDetails;

    public BookingsModel(int imageId, int bookingId, String code, String purchaseDate, String productName, String status, String address2, String contact1, String activity, String time, String purchaseDetails) {
        this.imageId = imageId;
        this.bookingId = bookingId;
        this.code = code;
        this.purchaseDate = purchaseDate;
        this.productName = productName;
        this.status = status;
        this.address2 = address2;
        this.contact1 = contact1;
        this.activity = activity;
        this.time = time;
        this.purchaseDetails = purchaseDetails;
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


    public String getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(String purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
