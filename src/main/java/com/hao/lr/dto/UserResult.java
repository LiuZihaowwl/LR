package com.hao.lr.dto;

import lombok.Data;

/**
 * @ClassName UserResult
 * @Description 用户统一封装信息类
 * @Author Administrator
 * @Date 2020/5/30 18:21
 * @Version 1.0
 **/
@Data
public class UserResult<T> {
    private boolean flag;
    private T data;
    private String message;
    public UserResult(){}
    public UserResult(boolean flag, T data, String message){
        this.flag = flag;
        this.data = data;
        this.message =message;
    }
    public UserResult(boolean flag, String message){
        this.flag = flag;
        this.message = message;
    }
}
