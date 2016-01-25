package com.ggj.dao;

import com.ggj.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * author:gaoguangjin
 * Description:对于简单的crud 可以使用mybatis注解，没必要使用xml配置
 * Email:335424093@qq.com
 * Date 2016/1/25 9:27
 */
public interface CityAnnationDao {

    @Select("select id,name,COUNTRY from City where id = #{id}")
    City getCity(@Param("id") int id);

    @Insert("INSERT into City (name,country)VALUE (#{name},#{country})")
    void insert(City city);

}
