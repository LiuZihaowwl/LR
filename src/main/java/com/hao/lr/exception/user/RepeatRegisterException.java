package com.hao.lr.exception.user;

/**
 * @ClassName RepeatRegisterException
 * @Description   自定义重复注册异常
 * @Author Administrator
 * @Date 2020/5/30 18:28
 * @Version 1.0
 **/
public class RepeatRegisterException extends UserException {
    public RepeatRegisterException(String message) {
        super(message);
    }

    public RepeatRegisterException(String message, Throwable cause) {
        super(message, cause);
    }
}
