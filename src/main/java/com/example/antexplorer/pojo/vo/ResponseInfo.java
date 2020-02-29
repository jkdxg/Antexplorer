package com.example.antexplorer.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @program: OrderSystem
 * @description: ${DESCRIPTION}
 * @author: Huangxn
 * @create: 2018-12-15 10:52
 **/
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class ResponseInfo {
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CODE_FAIL = -1;
    public ResponseInfo(int _code, String _msg){
        this.code=_code;
        this.errorMsg=_msg;
    }
    public ResponseInfo(int _code, String _msg, Object object){
        this.code=_code;
        this.errorMsg=_msg;
        this.data=object;
    }
    public ResponseInfo(){

    }
    /**
     * 错误码
     */
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 数据
     */
    private Object data;
}
