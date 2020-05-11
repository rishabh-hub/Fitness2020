package com.example.fitness2020.Models;

public class PopularRvModel {
    private int id;
    private String gymName;
    private String category;
    private String gymAddress;
    private String recommended;

    public PopularRvModel(int id, String gymName, String category, String gymAddress,String recommended) {
        this.id = id;
        this.gymName = gymName;
        this.category = category;
        this.gymAddress = gymAddress;
        this.recommended=recommended;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

    public String getGymAddress() {
        return gymAddress;
    }

    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }
}
