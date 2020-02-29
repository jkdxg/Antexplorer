package com.example.antexplorer.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RestaurantInfoVO {
    @JsonProperty
    public int D_Id;
    @JsonProperty
    public String D_Name;
    @JsonProperty
    public int D_RestStorage;
    @JsonProperty
    public int D_Phone;
    @JsonProperty
    public String D_District;
    @JsonProperty
    public double Distance;
    @JsonIgnore
    public void setDistance(double distance) {
        Distance = distance;
    }
    @JsonIgnore
    public double getDistance() {
        return Distance;
    }

    @JsonIgnore
    public int getD_Id() {
        return D_Id;
    }
    @JsonIgnore
    public int getD_Phone() {
        return D_Phone;
    }
    @JsonIgnore
    public int getD_RestStorage() {
        return D_RestStorage;
    }
    @JsonIgnore
    public String getD_District() {
        return D_District;
    }
    @JsonIgnore
    public String getD_Name() {
        return D_Name;
    }

    @JsonIgnore
    public void setD_District(String d_District) {
        D_District = d_District;
    }
    @JsonIgnore
    public void setD_Id(int d_Id) {
        D_Id = d_Id;
    }
    @JsonIgnore
    public void setD_Name(String d_Name) {
        D_Name = d_Name;
    }
    @JsonIgnore
    public void setD_Phone(int d_Phone) {
        D_Phone = d_Phone;
    }
    @JsonIgnore
    public void setD_RestStorage(int d_RestStorage) {
        D_RestStorage = d_RestStorage;
    }

}
