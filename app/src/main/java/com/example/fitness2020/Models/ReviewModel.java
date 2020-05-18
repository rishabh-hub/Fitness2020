package com.example.fitness2020.Models;

public class ReviewModel {
    private String name;
    private String product;
    private String description;

    public ReviewModel(String name, String product, String description) {
        this.name = name;
        this.product = product;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
