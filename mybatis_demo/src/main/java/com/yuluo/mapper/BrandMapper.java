package com.yuluo.mapper;

import com.yuluo.pojo.Brand;
import com.yuluo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    //查询所有
    List<Brand> selectAll();

    //查询详情方法
    Brand selectById(int id);

    //条件查询的方法1 散装的参数
    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName")String companyName, @Param("brandName")String brandName);

    //条件查询的方法2 对象参数 对象的属性名称要和参数占位符的名称一致才可以
    List<Brand> selectByCondition(Brand brand);

    //条件查询的方法3 Map集合参数
    List<Brand> selectByCondition(Map map);
}
