package com.example.antexplorer.pojo.vo;

import java.util.List;

public class RouteInfoVO {
    private Integer r_Id;
    private List<String> r_Place;
    private String r_Name;


    public Integer getRId() {
        return r_Id;
    }

    public void setRId(int rId) {
        this.r_Id = rId;
    }


    public List<String> getRPlace() {
        return r_Place;
    }

    public void setRPlace(List<String> rPlace) {
        this.r_Place = rPlace;
    }


    public String getRName() {
        return r_Name;
    }

    public void setRName(String rName) {
        this.r_Name = rName;
    }
}
