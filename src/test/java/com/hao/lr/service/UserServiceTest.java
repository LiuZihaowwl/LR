package com.hao.lr.service;

import com.hao.lr.dto.UserResult;
import com.hao.lr.entity.User;
import com.hao.lr.entity.UserAuths;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void userRegister() {
        User user = new User();
        user.setUName("test6");
        user.setUSex("男");
        user.setUBirthday(new Date());
        user.setUSignature("爱拼才会赢");
        user.setUAvatar("爱拼才会赢".getBytes());
        UserAuths userAuths = new UserAuths();
        userAuths.setPhone(346757L);
        userAuths.setPassword("666666");
        try {
            UserResult userResult = userService.userRegister(user, userAuths);
            if(userResult.isFlag()){
                System.out.println("注册成功");
                System.out.println(userResult.getData());
            }
            else {
                System.out.println(userResult.getMessage());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    void userLogin() {
        long phone = 13142346757L;
        String password = "666666";
        UserResult userResult = userService.userLogin(phone, password);
        System.out.println(userResult.getMessage());
        System.out.println(userResult.getData());
    }
}
