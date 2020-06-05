package com.hao.lr.mapper;

import com.hao.lr.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void queryById() {
    }

    @Test
    void insertUser() {
        String uName = "test2";
        String uSex = "男";
        Date uBirthday = new Date();
        String uSignature = "爱拼才会赢";
        byte[] uAvatar = uSignature.getBytes();
        User user = new User();
        user.setUName(uName);
        user.setUSex(uSex);
        user.setUBirthday(uBirthday);
        user.setUSignature(uSignature);
        user.setUAvatar(uAvatar);
        long uId;
        userMapper.insertUser(user);
        uId = user.getUId();
        System.out.println("uId:"+uId);
    }
}
