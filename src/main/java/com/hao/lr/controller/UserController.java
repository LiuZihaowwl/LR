package com.hao.lr.controller;
import com.hao.lr.dto.UserResult;
import com.hao.lr.entity.User;
import com.hao.lr.entity.UserAuths;
import com.hao.lr.service.UserService;
import com.hao.lr.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description
 * @Author Administrator
 * @Date 2020/6/2 16:00
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserResult userRegister(@RequestBody Map<String, String> map) throws ParseException {
        User user = new User();
        UserAuths userAuths = new UserAuths();
        String uName = map.get("uName");
        String uSex = map.get("uSex");
        Date uBirthday = TimeUtils.StringToDate(map.get("uBirthday"));
        String uSignature = map.get("uSignature");
        long phone = Long.parseLong(map.get("phone"));
        String password = map.get("password");
        user.setUName(uName);
        user.setUSex(uSex);
        user.setUBirthday(uBirthday);
        user.setUSignature(uSignature);
        userAuths.setPhone(phone);
        userAuths.setPassword(password);
        UserResult userResult = null;
        try {
            userResult = userService.userRegister(user, userAuths);
        }catch (Exception e){
            return new UserResult(false, "系统出现错误，请重试或联系客服");
        }
        return userResult;
    }

    @PostMapping("/login")
    public UserResult userLogin(@RequestBody Map<String, String> map){
        long phone = Long.parseLong(map.get("phone"));
        String password = map.get("password");
        UserResult userResult = null;
        try {
            userResult = userService.userLogin(phone, password);
        }catch (Exception e){
            return new UserResult(false, "系统出现错误，请重试或联系客服");
        }
        return userResult;
    }
}
