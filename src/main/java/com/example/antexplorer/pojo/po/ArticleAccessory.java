package com.example.antexplorer.pojo.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 吴山烤禽
 * @package com.example.antexplorer.pojo.po
 * @time 16:59
 * @discribe
 * @since 2020/2/28
 **/
public class ArticleAccessory {
    @JsonProperty
    private int M_Id;
    @JsonProperty
    private int A_Id;
    @JsonProperty
    byte[] M_Content;
    @JsonIgnore
    public void setA_Id(int a_Id) {
        A_Id = a_Id;
    }
    @JsonIgnore
    public void setM_Content(byte[] m_Content) {
        M_Content = m_Content;
    }
    @JsonIgnore
    public void setM_Id(int m_Id) {
        M_Id = m_Id;
    }
    @JsonIgnore
    public byte[] getM_Content() {
        return M_Content;
    }
    @JsonIgnore
    public int getA_Id() {
        return A_Id;
    }
    @JsonIgnore
    public int getM_Id() {
        return M_Id;
    }

}
