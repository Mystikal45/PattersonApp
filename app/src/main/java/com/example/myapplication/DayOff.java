package com.example.myapplication;

public class DayOff {


    int month;
    int day;
    int year;
    String description;

    public DayOff(int month, int day, int year, String description) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.description = description;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
