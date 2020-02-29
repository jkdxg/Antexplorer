package com.example.antexplorer.interceptor;

import com.example.antexplorer.interceptor.annotation.Authorization;
import com.example.antexplorer.manager.TokenManager;
import com.example.antexplorer.pojo.TokenModel;
import com.example.antexplorer.pojo.vo.ResponseInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@Component
@Configuration
public class AuthorizationInterceptor  extends HandlerInterceptorAdapter {

    @Autowired(required = false)
    private TokenManager manager;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //从header中得到token

        String authorization = request.getHeader("Authorization");
        System.out.println(authorization);
        //验证token
        TokenModel model = manager.getToken(authorization);
        if (manager.checkToken(model)) {
            //如果token验证成功，将token对应的用户id存在request中，便于之后注入
            ///setAttribute指只在这一次request中，设置一个可以被访问到的字段currentUserId
            request.setAttribute("currentUserId", model.getUserId());
            return true;
        }
        //如果验证token失败，并且方法注明了Authorization，返回401错误
        if (method.getAnnotation(Authorization.class) != null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            returnErrorMessage(response, "IDerror");
            return false;
        }
        return true;
    }
    private void returnErrorMessage(HttpServletResponse response, String errorMessage) throws IOException {
        ResponseInfo rst = new ResponseInfo(401,errorMessage);
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonOfRST = mapper.writeValueAsString(rst);
        out.print(jsonOfRST);
        out.flush();
    }

}
