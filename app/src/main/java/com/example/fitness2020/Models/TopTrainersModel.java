package com.example.fitness2020.Models;

public class TopTrainersModel {

    int imageUrl;
    String trainerName;

    public TopTrainersModel(int imageUrl, String trainerName) {
        this.imageUrl = imageUrl;
        this.trainerName = trainerName;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
}
