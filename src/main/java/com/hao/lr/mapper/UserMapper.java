package com.hao.lr.mapper;

import com.hao.lr.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @InterfaceName UserMapper
 * @Description
 * @Author Administrator
 * @Date 2020/5/30 10:07
 * @Version 1.0
 **/
public interface UserMapper {
    @Select("SELECT * FROM user WHERE u_id = #{uId}")
    @Results({
            @Result(property = "uId", column = "u_id"),
            @Result(property = "uName", column = "u_name"),
            @Result(property = "uSex", column = "u_sex"),
            @Result(property = "uBirthday", column = "u_birthday"),
            @Result(property = "uSignature", column = "u_signature"),
            @Result(property = "uAvatar", column = "u_avatar")
    })
    User queryById(long uId);

    @Insert("INSERT INTO user(u_name,u_sex,u_birthday,u_signature,u_avatar) VALUES (#{uName},#{uSex},#{uBirthday},#{uSignature},#{uAvatar})")
    @Options(useGeneratedKeys = true, keyProperty = "uId", keyColumn = "u_id")
    int insertUser(User user);
}
