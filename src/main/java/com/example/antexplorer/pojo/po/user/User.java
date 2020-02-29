package com.example.antexplorer.pojo.po.user;

public class User {
    public int U_Id;
    public String U_Password;
    public String U_Name;
    public String U_Phone;
    public String U_CarPlate;
    public String U_IdNum;
    public int U_Type;
    public byte[] U_Img;

    public int getU_Id() {
        return U_Id;
    }

    public String getU_IdNum() {
        return U_IdNum;
    }

    public String getU_CarPlate() {
        return U_CarPlate;
    }

    public String getU_Name() {
        return U_Name;
    }

    public String getU_Password() {
        return U_Password;
    }

    public String getU_Phone() {
        return U_Phone;
    }

    public void setU_CarPlate(String u_Carplate) {
        U_CarPlate = u_Carplate;
    }

    public void setU_Id(int u_Id) {
        U_Id = u_Id;
    }

    public void setU_IdNum(String u_IdNum) {
        U_IdNum = u_IdNum;
    }

    public void setU_Name(String u_Name) {
        U_Name = u_Name;
    }

    public void setU_Password(String u_Password) {
        U_Password = u_Password;
    }

    public void setU_Phone(String u_Phone) {
        U_Phone = u_Phone;
    }

    public int getU_Type() {
        return U_Type;
    }

    public void setU_Type(int u_Type) {
        U_Type = u_Type;
    }

    public void setU_Img(byte[] u_Img) {
        U_Img = u_Img;
    }

    public byte[] getU_Img() {
        return U_Img;
    }
}

