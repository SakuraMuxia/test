package com.yuluo.dao.impl;

import com.yuluo.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    @Value()
    private String name;

    @Override
    public void save() {
        System.out.println("book dao save ..." + name);
    }

}
