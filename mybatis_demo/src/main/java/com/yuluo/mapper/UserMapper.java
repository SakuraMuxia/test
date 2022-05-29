package com.yuluo.mapper;

import com.yuluo.pojo.User;

import java.util.List;

public interface UserMapper {
    //定义一个方法
    List<User> selectAll();
    //
    User selectById(int i);

}
