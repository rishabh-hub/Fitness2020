package com.example.fitness2020.Models;

public class DateModel {
    private String date,month;

    public DateModel(String date, String month) {
        this.date = date;
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
