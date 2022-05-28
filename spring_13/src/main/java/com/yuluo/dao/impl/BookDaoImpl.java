package com.yuluo.dao.impl;

import com.yuluo.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository("bookDao1")
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao save ...");
    }

}
