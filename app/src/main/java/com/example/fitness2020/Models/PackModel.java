package com.example.fitness2020.Models;

public class PackModel {

    private String packName;
    private int packPrice;
    private int basePrice;
    private String featues;

    public PackModel(String packName, int packPrice, int basePrice, String featues) {
        this.packName = packName;
        this.packPrice = packPrice;
        this.basePrice = basePrice;
        this.featues = featues;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public String getFeatues() {
        return featues;
    }

    public void setFeatues(String featues) {
        this.featues = featues;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public int getPackPrice() {
        return packPrice;
    }

    public void setPackPrice(int packPrice) {
        this.packPrice = packPrice;
    }
}
