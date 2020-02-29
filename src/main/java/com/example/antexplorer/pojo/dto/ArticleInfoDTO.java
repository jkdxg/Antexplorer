package com.example.antexplorer.pojo.dto;

import com.example.antexplorer.pojo.po.ArticleAccessory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author 吴山烤禽
 * @package com.example.antexplorer.pojo.dto
 * @time 0:05
 * @discribe
 * @since 2020/2/27
 **/
public class ArticleInfoDTO {
    @JsonProperty
    public int aId;
    @JsonProperty
    public String A_Content;
    @JsonProperty
    public String A_Pic;
    @JsonProperty
    public String A_Name;
    @JsonProperty
    public String aDateTime;
    @JsonProperty
    public int aAuthorId;
    @JsonProperty
    public String aAuthorName;
    @JsonProperty
    public String aAuthorImg;
    @JsonProperty
    public String aInnerArticle;
    @JsonProperty
    public List<String> articleAccessoryList;
    @JsonIgnore
    public String getAContent() {
        return A_Content;
    }
    @JsonIgnore
    public void setAContent(String aContent) {
        this.A_Content = aContent;
    }
    @JsonIgnore
    public String getAPic() {
        return A_Pic;
    }
    @JsonIgnore
    public void setAPic(String aPic) {
        this.A_Pic = aPic;
    }
    @JsonIgnore
    public String getA_Name() {
        return A_Name;
    }
    @JsonIgnore
    public void setA_Name(String a_Name) {
        A_Name = a_Name;
    }
    @JsonIgnore
    public int getaAuthorId() {
        return aAuthorId;
    }
    @JsonIgnore
    public void setaAuthorId(int aAuthorId) {
        this.aAuthorId = aAuthorId;
    }
    @JsonIgnore
    public void setaDateTime(String aDateTime) {
        this.aDateTime = aDateTime;
    }
    @JsonIgnore
    public String getaDateTime() {
        return aDateTime;
    }
    @JsonIgnore
    public List<String> getArticleAccessoryList() {
        return articleAccessoryList;
    }
    @JsonIgnore
    public void setArticleAccessoryList(List<String> articleAccessoryList) {
        this.articleAccessoryList = articleAccessoryList;
    }

    @JsonIgnore
    public void setA_Content(String a_Content) {
        A_Content = a_Content;
    }
    @JsonIgnore
    public void setaId(int aId) {
        this.aId = aId;
    }
    @JsonIgnore
    public int getaId() {
        return aId;
    }
    @JsonIgnore
    public String getaAuthorImg() {
        return aAuthorImg;
    }
    @JsonIgnore
    public String getaAuthorName() {
        return aAuthorName;
    }
    @JsonIgnore
    public void setaAuthorImg(String aAuthorImg) {
        this.aAuthorImg = aAuthorImg;
    }
    @JsonIgnore
    public void setaAuthorName(String aAuthorName) {
        this.aAuthorName = aAuthorName;
    }
    @JsonIgnore
    public String getaInnerArticle() {
        return aInnerArticle;
    }
    @JsonIgnore
    public void setaInnerArticle(String aInnerArticle) {
        this.aInnerArticle = aInnerArticle;
    }
}
