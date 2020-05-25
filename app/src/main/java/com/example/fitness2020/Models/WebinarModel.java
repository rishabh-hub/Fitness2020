package com.example.fitness2020.Models;

public class WebinarModel {

    private String header;
    private String timing;
    private String location;
    private String activity;
    private int webinarImageUrl;

    public WebinarModel(String header, String timing, String location, String activity,int webinarImageUrl) {
        this.header = header;
        this.timing = timing;
        this.location = location;
        this.activity = activity;
        this.webinarImageUrl=webinarImageUrl;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getWebinarImageUrl() {
        return webinarImageUrl;
    }

    public void setWebinarImageUrl(int webinarImageUrl) {
        this.webinarImageUrl = webinarImageUrl;
    }
}
