package com.example.fitness2020.Models;

public class FitnessFragmentFreeTrialModel {

    private int imageId;
    private String gymName;
    private String gymAddress;
    private String category;

    public FitnessFragmentFreeTrialModel(int imageId, String gymName, String gymAddress,String category) {
        this.imageId = imageId;
        this.gymName = gymName;
        this.gymAddress = gymAddress;
        this.category=category;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getGymAddress() {
        return gymAddress;
    }

    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
