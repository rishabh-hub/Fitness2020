package com.example.fitness2020.Models;

public class GymReviewModel {
    private String userName;
    private String gymName;
    private String gymRating;
    private String reviewDate;
    private String gymReview;

    public GymReviewModel(String userName, String gymName, String gymRating, String reviewDate, String gymReview) {
        this.userName = userName;
        this.gymName = gymName;
        this.gymRating = gymRating;
        this.reviewDate = reviewDate;
        this.gymReview = gymReview;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getGymRating() {
        return gymRating;
    }

    public void setGymRating(String gymRating) {
        this.gymRating = gymRating;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getGymReview() {
        return gymReview;
    }

    public void setGymReview(String gymReview) {
        this.gymReview = gymReview;
    }
}
