package com.yuluo.service.impl;

import com.yuluo.dao.BookDao;
import com.yuluo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    @Qualifier("bookDao")
    private BookDao bookDao;


    @Override
    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
}
