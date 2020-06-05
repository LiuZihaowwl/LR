package com.hao.lr.exception.user;

/**
 * @ClassName UserLoginException
 * @Description     自定义用户登录异常
 * @Author Administrator
 * @Date 2020/5/30 18:29
 * @Version 1.0
 **/
public class UserLoginException extends UserException {
    public UserLoginException(String message) {
        super(message);
    }

    public UserLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
