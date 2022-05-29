package com.yuluo.app;

import com.alibaba.druid.pool.DruidDataSource;
import com.yuluo.config.SpringConfig;
import com.yuluo.dao.BookDao;
import com.yuluo.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource);
    }
}
