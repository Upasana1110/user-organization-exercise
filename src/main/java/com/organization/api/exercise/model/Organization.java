package com.organization.api.exercise.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

// The details associated with organization object.
public class Organization {
    private String name; // Unique for each organization.
    private String address;
    private String phone;

    public Organization(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
}
