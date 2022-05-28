package com.yuluo.dao.impl;

import com.yuluo.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository("bookDao2")
public class BookDaoImpl2 implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao 2 save ...");
    }

}
