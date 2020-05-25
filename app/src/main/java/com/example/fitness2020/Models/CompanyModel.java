package com.example.fitness2020.Models;

public class CompanyModel {
    private int companyImageUrl;
    private String companyName;

    public CompanyModel(int companyImageUrl, String companyName) {
        this.companyImageUrl = companyImageUrl;
        this.companyName = companyName;
    }

    public int getCompanyImageUrl() {
        return companyImageUrl;
    }

    public void setCompanyImageUrl(int companyImageUrl) {
        this.companyImageUrl = companyImageUrl;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
