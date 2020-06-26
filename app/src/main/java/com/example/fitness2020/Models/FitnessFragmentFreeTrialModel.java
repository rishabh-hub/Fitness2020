package com.example.fitness2020.Models;

public class FitnessFragmentFreeTrialModel {

    private int imageId;
    private String gymName;
    private String gymAddress;
    private String category;
    private String rating;

    public FitnessFragmentFreeTrialModel(int imageId, String gymName, String gymAddress,String category,String rating) {
        this.imageId = imageId;
        this.gymName = gymName;
        this.gymAddress = gymAddress;
        this.category=category;
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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
