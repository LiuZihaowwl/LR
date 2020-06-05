package com.hao.lr.entity;

import lombok.Data;

/**
 * @ClassName UserAuths
 * @Description  用户密码表实体
 * @Author Administrator
 * @Date 2020/5/30 9:52
 * @Version 1.0
 **/
@Data
public class UserAuths {
    private long uId;
    private long phone;
    private String password;
    private String salt;
}
