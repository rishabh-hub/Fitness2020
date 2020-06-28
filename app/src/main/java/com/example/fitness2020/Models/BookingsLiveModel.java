package com.example.fitness2020.Models;

public class BookingsLiveModel {

    private int imageId;
    private String name;
    private String date;
    private String time;
    private String classType;//either instagram or zoom class
    private String category;//gold or silver or bronze
    private String activity;//was earlier no of seats but now contains activity
    private String link;//zoom or instagram class link
    private String zoomId;
    private String zoomPassword;

    public BookingsLiveModel(int imageId, String name, String date, String time, String classType, String category, String activity, String link, String zoomId, String zoomPassword) {
        this.imageId = imageId;
        this.name = name;
        this.date = date;
        this.time = time;
        this.classType = classType;
        this.category = category;
        this.activity = activity;
        this.link = link;
        this.zoomId = zoomId;
        this.zoomPassword = zoomPassword;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getZoomId() {
        return zoomId;
    }

    public void setZoomId(String zoomId) {
        this.zoomId = zoomId;
    }

    public String getZoomPassword() {
        return zoomPassword;
    }

    public void setZoomPassword(String zoomPassword) {
        this.zoomPassword = zoomPassword;
    }
}
