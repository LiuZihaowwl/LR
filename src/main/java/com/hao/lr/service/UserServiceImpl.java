package com.hao.lr.service;

import com.hao.lr.dto.UserResult;
import com.hao.lr.entity.User;
import com.hao.lr.entity.UserAuths;
import com.hao.lr.exception.user.UserException;
import com.hao.lr.mapper.UserAuthsMapper;
import com.hao.lr.mapper.UserMapper;
import com.hao.lr.utils.UserPasswordHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author Administrator
 * @Date 2020/6/2 15:13
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAuthsMapper userAuthsMapper;

    public UserResult userRegister(User user, UserAuths userAuths){
        long phone = userAuths.getPhone();
        UserAuths temp = null;
        int result;
        temp = userAuthsMapper.findByPhone(phone);
        if(temp != null){
            return new UserResult(false, "该手机号重复注册");
        }
        try {
            result = userMapper.insertUser(user);
            if(result > 0){
                userAuths.setUId(user.getUId());
                try {
                    String salt = UserPasswordHash.genRandomSalt();
                    String passwordAddsalt = UserPasswordHash.genPasswordHash(userAuths.getPassword(), salt);
                    userAuths.setSalt(salt);
                    userAuths.setPassword(passwordAddsalt);
                    result = userAuthsMapper.insertUserAuths(userAuths);
                    if(result > 0)
                        return new UserResult(true, user, "用户注册成功");
                }catch (Exception e){
                    throw new UserException("密码表内部执行异常");
                }
            }
        }catch (Exception e){
            throw new UserException("用户表内部执行异常");
        }
        return new UserResult(false, "用户注册失败");
    }

    public UserResult userLogin(long phone, String password){
        User user = null;
        UserAuths userAuths = null;
        try {
            userAuths = userAuthsMapper.findByPhone(phone);
            if(userAuths != null){
                boolean result;
                result = UserPasswordHash.verify(password, userAuths.getSalt(), userAuths.getPassword());
                if(result == true){
                    user = userMapper.queryById(userAuths.getUId());
                    return new UserResult(true, user, "用户登录成功");
                }
                else
                    return new UserResult(false, "用户输入的账号或者密码有错误");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new UserException("内部加密算法执行错误");
        } catch (InvalidKeySpecException e) {
            throw new UserException("内部加密算法执行错误");
        }catch (Exception e){
            throw new UserException("登录模块内部执行错误");
        }
        return new UserResult(false, "用户输入的账号或者密码有错误");
    }
}
