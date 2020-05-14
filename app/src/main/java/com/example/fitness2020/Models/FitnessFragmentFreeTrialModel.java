package com.example.fitness2020.Models;

public class FitnessFragmentFreeTrialModel {

    private int imageId;
    private String gymName;
    private String gymAddress;

    public FitnessFragmentFreeTrialModel(int imageId, String gymName, String gymAddress) {
        this.imageId = imageId;
        this.gymName = gymName;
        this.gymAddress = gymAddress;
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
}
