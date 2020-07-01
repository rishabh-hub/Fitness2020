package com.example.fitness2020.Models;

public class MembershipInternalModel {

    String heading;
    String price;
    String duration;

    public MembershipInternalModel(String heading, String price, String duration) {
        this.heading = heading;
        this.price = price;
        this.duration = duration;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
