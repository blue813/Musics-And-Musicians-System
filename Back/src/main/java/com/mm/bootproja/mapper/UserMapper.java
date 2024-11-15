package com.mm.bootproja.mapper;

import com.mm.bootproja.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from t_user where tel=#{tel}")
    public User selectUserByTel(String tel);
    @Insert("insert into t_user values (null,#{tel},#{loginPwd},#{userName})")
    public int insertUser(User user);
}
