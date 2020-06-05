package com.hao.lr.service;

import com.hao.lr.dto.UserResult;
import com.hao.lr.entity.User;
import com.hao.lr.entity.UserAuths;
import com.hao.lr.exception.user.UserException;
import com.hao.lr.mapper.UserAuthsMapper;
import com.hao.lr.mapper.UserMapper;
import com.hao.lr.utils.UserPasswordHash;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @ClassName UserService
 * @Description
 * @Author Administrator
 * @Date 2020/5/30 18:20
 * @Version 1.0
 **/
public interface UserService {
    /**
     *
     * @param user  包含user基本信息
     * @param userAuths    包含账号和密码
     * @return
     */
    public UserResult userRegister(User user, UserAuths userAuths);

    /**
     *
     * @param phone   用户账号
     * @param password  用户密码
     * @return
     */
    public UserResult userLogin(long phone, String password);

}
