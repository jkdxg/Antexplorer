package com.example.antexplorer.manager;

import com.example.antexplorer.pojo.TokenModel;

/**
 * @program: web
 * @description: ${DESCRIPTION}
 * @author: 香喷喷大猪蹄子
 * @create: 2019-01-27 14:17
 **/
public interface TokenManager {
    String TOKEN_PREFIX = "token_%s";

    static Integer EXPIRE =  4; //2小时
    /**
     * 创建一个token关联上指定用户
     * @param userId 指定用户的id
     * @return 生成的token
     */
    public TokenModel createToken(String userId);

    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    public boolean checkToken(TokenModel model);

    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
    public TokenModel getToken(String authentication);

    /**
     * 清除token
     * @param userId 登录用户的id
     */
    public void deleteToken(String userId);

}
