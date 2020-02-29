package com.example.antexplorer.pojo.vo;

import com.example.antexplorer.pojo.TokenModel;

public class UserInfoVO {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String carplate;
    private String idnum;
    private TokenModel tokenModel;
    public int U_Type;
    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getCarplate() {
        return carplate;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setCarplate(String carplate) {
        this.carplate = carplate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TokenModel getTokenModel() {
        return tokenModel;
    }

    public void setTokenModel(TokenModel tokenModel) {
        this.tokenModel = tokenModel;
    }

    public void setU_Type(int u_Type) {
        U_Type = u_Type;
    }

    public int getU_Type() {
        return U_Type;
    }
}
