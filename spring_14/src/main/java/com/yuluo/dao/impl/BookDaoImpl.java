package com.yuluo.dao.impl;

import com.yuluo.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository()
public class BookDaoImpl implements BookDao {

    @Override
    public void save() {
        System.out.println("book dao save ...");
    }

}
