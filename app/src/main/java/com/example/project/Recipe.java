package com.example.project;

import com.google.gson.annotations.SerializedName;

public class Recipe {
    private String ID;
    private String type;
    private String company;
    private String category;
    private int cost;
    private Auxdata auxdata;
    private String name;
    @SerializedName("location")
    private String websiteName;
    @SerializedName("size")
    private int time;


    public String getName() {
        return name;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public int getTime() {
        return time;
    }

    public Auxdata getAuxdata() {
        return auxdata;
    }

    @Override
    public String toString() {
        return name;
    }
}
