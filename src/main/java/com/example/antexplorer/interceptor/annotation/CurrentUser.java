package com.example.antexplorer.interceptor.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface CurrentUser {
}