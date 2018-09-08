package com.xiao.core.shiro.exception;

/**
 * @Auther: Administrator
 * @Date: 2018/9/8 23:19
 * @Description:
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}