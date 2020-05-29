package com.example.fitness2020.Models;

public class CollectionsModel {

    private int imageUrl;
    private String collectionHeading;
    private String places;

    public CollectionsModel(int imageUrl, String collectionHeading, String places) {
        this.imageUrl = imageUrl;
        this.collectionHeading = collectionHeading;
        this.places = places;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCollectionHeading() {
        return collectionHeading;
    }

    public void setCollectionHeading(String collectionHeading) {
        this.collectionHeading = collectionHeading;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }
}
