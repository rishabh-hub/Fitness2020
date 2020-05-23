package com.example.fitness2020.Models;

public class PackModel {

    private String packName;
    private int packPrice;

    public PackModel(String packName, int packPrice) {
        this.packName = packName;
        this.packPrice = packPrice;
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
