package com.hao.lr.mapper;

import com.hao.lr.entity.UserAuths;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @InterfaceName UserAuthsMapper
 * @Description
 * @Author Administrator
 * @Date 2020/5/30 17:42
 * @Version 1.0
 **/
public interface UserAuthsMapper {
    @Select("SELECT * FROM user_auths WHERE u_id = #{uId}")
    @Results(value = {
            @Result(property = "uId", column = "u_id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt")
    })
    UserAuths findByUId(long uId);

    @Insert("INSERT INTO user_auths(u_id,phone,password,salt) VALUES (#{uId},#{phone},#{password},#{salt})")
    int insertUserAuths(UserAuths userAuths);

    @Select("SELECT * FROM user_auths WHERE phone = #{phone}")
    @Results(value = {
            @Result(property = "uId", column = "u_id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt")
    })
    UserAuths findByPhone(long phone);


}
