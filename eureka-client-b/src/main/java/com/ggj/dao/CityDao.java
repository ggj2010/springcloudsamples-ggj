package com.ggj.dao;

import com.ggj.bean.City;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/22 14:49
 */
public interface CityDao {
    City getCity(int id);

    void insert(City city);
}
