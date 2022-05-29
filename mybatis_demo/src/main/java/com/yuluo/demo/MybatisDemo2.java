package com.yuluo.demo;

import com.yuluo.mapper.UserMapper;
import com.yuluo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo2 {

    public static class mybatisDemo {
        public static void main(String[] args) throws IOException {
            //1 加载
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //2 获取sqlsession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //3 执行sql
            //List<User> users = sqlSession.selectList("test.selectAll");
            //3.1 获取UserMapper接口的代理对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = userMapper.selectAll();
            //4 输出结果
            System.out.println(users);
            //5 释放资源
            sqlSession.close();
        }
    }
}
