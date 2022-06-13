package com.yuluo.mapper;

import com.yuluo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    //定义一个方法
    List<User> selectAll();

    //设置user表的用户名和密码方法
    @Select("select * from tb_user where id = #{id}")
    User selectById(int i);

    //设置用户名和密码
    User select(@Param("username") String username, @Param("password") String password);

}
