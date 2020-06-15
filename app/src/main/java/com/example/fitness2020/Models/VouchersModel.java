package com.example.fitness2020.Models;

public class VouchersModel {
    private String offer;
    private String companyName;
    private String noOfCoupons;
    private String validity;
    private int voucherImageUrl;
    private String voucherTheme;

    public VouchersModel(String offer, String companyName, String noOfCoupons, String validity,int voucherImageUrl,String voucherTheme) {
        this.offer = offer;
        this.companyName = companyName;
        this.noOfCoupons = noOfCoupons;
        this.validity = validity;
        this.voucherImageUrl=voucherImageUrl;
        this.voucherTheme=voucherTheme;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNoOfCoupons() {
        return noOfCoupons;
    }

    public void setNoOfCoupons(String noOfCoupons) {
        this.noOfCoupons = noOfCoupons;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public int getVoucherImageUrl() {
        return voucherImageUrl;
    }

    public void setVoucherImageUrl(int voucherImageUrl) {
        this.voucherImageUrl = voucherImageUrl;
    }

    public String getVoucherTheme() {
        return voucherTheme;
    }

    public void setVoucherTheme(String voucherTheme) {
        this.voucherTheme = voucherTheme;
    }
}
