package com.yuluo.app;

import com.yuluo.config.SpringConfig;
import com.yuluo.dao.BookDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        BookDao bookDao1 = ctx.getBean(BookDao.class);
        System.out.println(bookDao);
        System.out.println(bookDao1);
        ctx.close();
    }
}
