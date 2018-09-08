package com.xiao.core.shiro.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Auther: Administrator
 * @Date: 2018/9/8 23:20
 * @Description:
 */
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

