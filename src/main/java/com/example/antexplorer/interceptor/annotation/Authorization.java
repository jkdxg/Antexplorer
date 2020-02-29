package com.example.antexplorer.interceptor.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.METHOD)//只能在method上使用
@Retention(RetentionPolicy.RUNTIME)//运行时生效
@Documented
@Component
public @interface Authorization {

}