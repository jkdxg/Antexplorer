package com.example.antexplorer.pojo.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Place {
    public Integer P_Id;
    public String P_Name;
    public String P_District;
    @JsonProperty
    public double Longtitude;
    @JsonProperty
    public double Latitude;
    @JsonProperty("P_Id")
    public Integer getP_Id() {
        return P_Id;
    }
    @JsonProperty("P_District")
    public String getP_District() {
        return P_District;
    }
    @JsonProperty("P_Name")
    public String getP_Name() {
        return P_Name;
    }
    @JsonProperty("P_District")
    public void setP_District(String p_District) {
        P_District = p_District;
    }
    @JsonProperty("P_Id")
    public void setP_Id(Integer p_Id) {
        P_Id = p_Id;
    }
    @JsonProperty("P_Name")
    public void setP_Name(String p_Name) {
        P_Name = p_Name;
    }
    @JsonIgnore
    public double getLongtitude() {
        return Longtitude;
    }
    @JsonIgnore
    public double getLatitude() {
        return Latitude;
    }
    @JsonIgnore
    public void setLongtitude(double longtitude) {
        Longtitude = longtitude;
    }
    @JsonIgnore
    public void setLatitude(double latitude) {
        Latitude = latitude;
    }
}
