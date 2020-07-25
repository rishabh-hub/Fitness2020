package com.example.fitness2020.Models;

public class ActivityModel {

    String activityName;
    int imageUrl;

    public ActivityModel(String activityName, int uri) {
        this.activityName = activityName;
        this.imageUrl = uri;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
