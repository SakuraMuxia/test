package com.yuluo.test;

import com.yuluo.mapper.BrandMapper;
import com.yuluo.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    /*查询所有的测试类*/
    public void testSelectAll() throws IOException {
        //1 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4 执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        //5 释放资源
        sqlSession.close();
    }

    /*通过id查询测试类*/
    @Test
    public void testSelectById() throws IOException {
        int id = 1;
        //1 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4 执行方法
        Brand brands = brandMapper.selectById(id);
        System.out.println(brands);
        //5 释放资源
        sqlSession.close();
    }
    /*通过条件查询测试类1*/
    @Test
    public void testSelectByCondition1() throws IOException {
        int status = 1;
        String companyName = "小米";
        String brandName = "小米";
        //处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

        //1 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4 执行方法
        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        System.out.println(brands);
        //5 释放资源
        sqlSession.close();
    }

    /*通过条件查询测试类2*/
    @Test
    public void testSelectByCondition2() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        //处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";
        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        //1 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4 执行方法
        List<Brand> brands = brandMapper.selectByCondition(brand);
        System.out.println(brands);
        //5 释放资源
        sqlSession.close();
    }

}
