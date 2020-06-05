package com.hao.lr.mapper;

import com.hao.lr.entity.UserAuths;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserAuthsMapperTest {
    @Autowired
    private UserAuthsMapper userAuthsMapper;
    @Test
    void findByUId() {
        UserAuths userAuths = null;
        long uId = 20;
        try {
            userAuths = userAuthsMapper.findByUId(uId);
            if(userAuths != null)
                System.out.println(userAuths);
            else
                System.out.println("no");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void insertUserAuths() {
        long uId = 12;
        long phone = 18801363979L;
        String password = "666666";
        String salt = "666666";
        UserAuths userAuths = new UserAuths();
        userAuths.setUId(uId);
        userAuths.setPhone(phone);
        userAuths.setPassword(password);
        userAuths.setSalt(salt);
        try {
            int result =  userAuthsMapper.insertUserAuths(userAuths);
            if(result > 0)
                System.out.println("ok");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
