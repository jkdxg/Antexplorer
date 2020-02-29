package com.example.antexplorer.controller;

import com.example.antexplorer.exception.BizException;
import com.example.antexplorer.pojo.vo.ResponseInfo;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

import static com.example.antexplorer.pojo.vo.ResponseInfo.ERROR_CODE_FAIL;
import static com.example.antexplorer.pojo.vo.ResponseInfo.ERROR_CODE_SUCCESS;


/**
 * @program: OrderSystem
 * @description: ${DESCRIPTION}
 * @author: Huangxn
 * @create: 2018-12-15 11:13
 **/
@RestControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if(o instanceof ResponseInfo)return o;
        ResponseInfo responseInfo=new ResponseInfo(ERROR_CODE_SUCCESS,"",o);

        return responseInfo;
    }
    @ExceptionHandler({Exception.class})
    public Object ExceptionHandler(HttpServletRequest request, Exception exception) {
        if(!(exception instanceof BizException)) System.out.print(exception.getMessage());
        ResponseInfo responseInfo=new ResponseInfo(ERROR_CODE_FAIL,exception.getMessage());
        return responseInfo;
    }
}
