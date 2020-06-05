package com.hao.lr.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description  用户表实体
 * @Author Administrator
 * @Date 2020/5/30 9:48
 * @Version 1.0
 **/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private long uId;
    private String uName;
    private String uSex;
    private Date uBirthday;
    private String uSignature;
    private byte[] uAvatar;
}
