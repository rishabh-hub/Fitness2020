package com.example.fitness2020.Models;

public class PopularHorizontalRvModel {

    private int imageurl;
    private String gymName;
    private String category;
    private String gymSchedule;

    public PopularHorizontalRvModel(int imageurl, String gymName, String category, String gymSchedule) {
        this.imageurl = imageurl;
        this.gymName = gymName;
        this.category = category;
        this.gymSchedule = gymSchedule;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGymSchedule() {
        return gymSchedule;
    }

    public void setGymSchedule(String gymSchedule) {
        this.gymSchedule = gymSchedule;
    }
}
