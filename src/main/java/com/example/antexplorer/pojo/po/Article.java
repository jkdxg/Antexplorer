package com.example.antexplorer.pojo.po;


import java.sql.Date;

public class Article {

    private int A_Id;
    private String A_Content;
    private byte[] A_Pic;
    private String A_Title;
    private String A_Time;
    private String A_Article;
    private int A_Author;
    public int getAId() {
        return A_Id;
    }

    public void setAId(int aId) {
        this.A_Id = aId;
    }


    public String getAContent() {
        return A_Content;
    }

    public void setAContent(String aContent) {
        this.A_Content = aContent;
    }


    public byte[] getAPic() {
        return A_Pic;
    }

    public void setAPic(byte[] aPic) {
        this.A_Pic = aPic;
    }

    public String getA_Title() {
        return A_Title;
    }

    public void setA_Title(String a_Name) {
        A_Title = a_Name;
    }

    public String getA_DateTime() {
        return A_Time;
    }

    public void setA_DateTime(String a_DateTime) {
        A_Time = a_DateTime;
    }

    public int getA_Author() {
        return A_Author;
    }

    public void setA_Author(int a_Author) {
        A_Author = a_Author;
    }

    public void setA_Content(String a_Content) {
        A_Content = a_Content;
    }

    public int getA_Id() {
        return A_Id;
    }

    public String getA_Article() {
        return A_Article;
    }

    public void setA_Article(String a_Article) {
        A_Article = a_Article;
    }
}
