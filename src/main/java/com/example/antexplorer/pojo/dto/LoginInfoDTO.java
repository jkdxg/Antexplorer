package com.example.antexplorer.pojo.dto;

public class LoginInfoDTO {
    public static int ADMINTYPE=2,USERTYPE=1;
    int userId;
    String password;

    public int type;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}
