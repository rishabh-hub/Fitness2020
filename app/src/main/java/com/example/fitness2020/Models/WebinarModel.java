package com.example.fitness2020.Models;

public class WebinarModel {

    private String header;
    private String timing;
    private String level;
    private String rating;
    private String activity;
    private int webinarImageUrl;
    private int bookings;

    public WebinarModel(String header, String timing, String level, String activity,int webinarImageUrl,String rating,int bookings) {
        this.header = header;
        this.timing = timing;
        this.level = level;
        this.activity = activity;
        this.webinarImageUrl=webinarImageUrl;
        this.rating = rating;
        this.bookings = bookings;
    }

    public int getBookings() {
        return bookings;
    }

    public void setBookings(int bookings) {
        this.bookings = bookings;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
