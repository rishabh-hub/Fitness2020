package com.example.fitness2020.Models;

public class EventsModel {
    private int imageId;
    private String name,price,location,host;

    public EventsModel(int imageId, String name, String price, String location, String host) {
        this.imageId = imageId;
        this.name = name;
        this.price = price;
        this.location = location;
        this.host = host;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
