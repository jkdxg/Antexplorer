package com.example.antexplorer.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamInfoVO {
    @JsonProperty
    public Integer T_Id;
    @JsonProperty
    public Integer U_Id;
    @JsonProperty
    public Integer R_Id;
    @JsonProperty
    public String T_Name;
    @JsonIgnore
    public Integer getTId() {
        return T_Id;
    }
    @JsonIgnore
    public void setTId(int tId) {
        this.T_Id = tId;
    }

    @JsonIgnore
    public Integer getUId() {
        return U_Id;
    }
    @JsonIgnore
    public void setUId(int uId) {
        this.U_Id = uId;
    }

    @JsonIgnore
    public Integer getRId() {
        return R_Id;
    }
    @JsonIgnore
    public void setRId(int rId) {
        this.R_Id = rId;
    }
    @JsonIgnore
    public String getT_Name() {
        return T_Name;
    }
    @JsonIgnore
    public void setT_Name(String t_Name) {
        this.T_Name = t_Name;
    }
}
