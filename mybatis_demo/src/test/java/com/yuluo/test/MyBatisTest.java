package com.yuluo.test;

import com.yuluo.mapper.BrandMapper;
import com.yuluo.mapper.UserMapper;
import com.yuluo.pojo.Brand;
import com.yuluo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /*通过条件查询测试类3*/
    @Test
    public void testSelectByCondition3() throws IOException {
        int status = 0;
        String companyName = "三只松鼠";
        String brandName = "三只松鼠";
        //处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";
        //封装对象
        Map map = new HashMap();
        //设置map键的名称和值
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        //1 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4 执行方法
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);
        //5 释放资源
        sqlSession.close();
    }

    /*通过条件查询测试类4-动态查询*/
    @Test
    public void testSelectByCondition4() throws IOException {
        int status = 0;
        String companyName = "小米";
        String brandName = "小米";
        //处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";
        //封装对象
        Map map = new HashMap();
        //设置map键的名称和值
        map.put("status",status);
        map.put("companyName",companyName);
        //map.put("brandName",brandName);

        //1 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4 执行方法
        List<Brand> brands = brandMapper.selectByConditionDynamic(map);
        System.out.println(brands);
        //5 释放资源
        sqlSession.close();
    }

    /*通过条件查询测试类5-单个动态查询*/
    @Test
    public void testSelectByCondition5() throws IOException {
        int status = 0;
        String companyName = "小米";
        String brandName = "小米";
        //处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";
        //封装对象
        //Map map = new HashMap();
        //设置map键的名称和值
        //map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);
        //封装对象
        Brand brand = new Brand();
        //brand.setStatus(status);
        //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);

        //1 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4 执行方法
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);
        //5 释放资源
        sqlSession.close();
    }

    /*添加sql的方法*/
    @Test
    public void testadd() throws IOException {
        int status = 0;
        String companyName = "魅族";
        String brandName = "魅族";
        String description = "年轻人的选择";
        int ordered = 100;
        //处理参数
        //companyName = "%"+companyName+"%";
        //brandName = "%"+brandName+"%";
        //封装对象
        //Map map = new HashMap();
        //设置map键的名称和值
        //map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);
        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取sqlSession对象,true设置JDBC自动提交关闭事务，默认为false开启事务，需要手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4 执行方法
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);
        //提交事物
        sqlSession.commit();
        //5 释放资源
        sqlSession.close();
    }

    /*动态修改sql的方法*/

    @Test
    public void testupdate() throws IOException {
        int status = 0;
        String companyName = "波导";
        String brandName = "波导";
        String description = "波导";
        int ordered = 150;
        int id = 5;
        //处理参数
        //companyName = "%"+companyName+"%";
        //brandName = "%"+brandName+"%";
        //封装对象
        //Map map = new HashMap();
        //设置map键的名称和值
        //map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);
        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        //1 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取sqlSession对象,true设置JDBC自动提交关闭事务，默认为false开启事务，需要手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4 执行方法 返回影响的行数
        int count = brandMapper.update(brand);
//        System.out.println(count);
        //提交事物
        sqlSession.commit();
        //5 释放资源
        sqlSession.close();
    }


    /*删除一条的方法*/

    @Test
    public void testdelete() throws IOException {
//        int status = 0;
//        String companyName = "波导";
//        String brandName = "波导";
//        String description = "波导";
//        int ordered = 150;
        int id = 5;
        //处理参数
        //companyName = "%"+companyName+"%";
        //brandName = "%"+brandName+"%";
        //封装对象
        //Map map = new HashMap();
        //设置map键的名称和值
        //map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);
        //封装对象
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
//        brand.setId(id);

        //1 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取sqlSession对象,true设置JDBC自动提交关闭事务，默认为false开启事务，需要手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4 执行方法 返回影响的行数
        brandMapper.deleteById(id);
//        System.out.println(count);
        //提交事物
        sqlSession.commit();
        //5 释放资源
        sqlSession.close();
    }

    /*批量删除的方法*/

    @Test
    public void testbatchdelete() throws IOException {
//        int status = 0;
//        String companyName = "波导";
//        String brandName = "波导";
//        String description = "波导";
//        int ordered = 150;
        int ids[] = {3,4};
        //处理参数
        //companyName = "%"+companyName+"%";
        //brandName = "%"+brandName+"%";
        //封装对象
        //Map map = new HashMap();
        //设置map键的名称和值
        //map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);
        //封装对象
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
//        brand.setId(id);

        //1 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取sqlSession对象,true设置JDBC自动提交关闭事务，默认为false开启事务，需要手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4 执行方法 返回影响的行数
        brandMapper.deleteByIds(ids);
//        System.out.println(count);
        //提交事物
        sqlSession.commit();
        //5 释放资源
        sqlSession.close();
    }

    /*参数传递的测试方法*/

    @Test
    public void testPara() throws IOException {

        String username = "zhangsan";
        String password = "123";

        //1 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取sqlSession对象,true设置JDBC自动提交关闭事务，默认为false开启事务，需要手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3 获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //4 执行方法 返回影响的行数
        User user = userMapper.select(username, password);
        System.out.println(user);
        //提交事物
        sqlSession.commit();
        //5 释放资源
        sqlSession.close();
    }

    /*注解开发测试方法*/

    @Test
    public void testByNote() throws IOException {

        /*String username = "zhangsan";
        String password = "123";*/
        int id = 1;
        //1 获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取sqlSession对象,true设置JDBC自动提交关闭事务，默认为false开启事务，需要手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3 获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //4 执行方法 返回影响的行数
        User user = userMapper.selectById(id);
        System.out.println(user);
        //提交事物
        sqlSession.commit();
        //5 释放资源
        sqlSession.close();
    }





}
