package com.example.project;

import com.google.gson.annotations.SerializedName;

public class Recipe {
    private String ID;
    private String type;
    private String company;
    private String category;
    @SerializedName("cost")
    private int feet;
    private Auxdata auxdata;

    private String name;
    private String location;
    private int size;



    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getHeight() {
        return size;
    }

    @Override
    public String toString() {
        return name;
    }
}
