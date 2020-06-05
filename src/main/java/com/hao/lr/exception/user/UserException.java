package com.hao.lr.exception.user;

/**
 * @ClassName UserException
 * @Description   自定义用户异常
 * @Author Administrator
 * @Date 2020/5/30 18:25
 * @Version 1.0
 **/
public class UserException extends RuntimeException {
    public UserException(String message){}

    public UserException(String message, Throwable cause){
        super(message, cause);
    }
}
