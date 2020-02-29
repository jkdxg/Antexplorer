package com.example.antexplorer.pojo.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.soap.Text;

public class Club {
    @JsonProperty
    Integer C_Id;
    @JsonProperty
    Integer U_Id;
    @JsonProperty
    Integer C_Name;
    @JsonIgnore
    public Integer getC_Id() {
        return C_Id;
    }
    @JsonIgnore
    public Integer getC_Name() {
        return C_Name;
    }
    @JsonIgnore
    public Integer getU_Id() {
        return U_Id;
    }
    @JsonIgnore
    public void setU_Id(Integer u_Id) {
        U_Id = u_Id;
    }
    @JsonIgnore
    public void setC_Id(Integer c_Id) {
        C_Id = c_Id;
    }
    @JsonIgnore
    public void setC_Name(Integer c_Name) {
        C_Name = c_Name;
    }
}
