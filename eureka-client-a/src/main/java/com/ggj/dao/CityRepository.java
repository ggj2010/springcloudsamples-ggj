package com.ggj.dao;

import com.ggj.bean.City;
import org.springframework.data.repository.Repository;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/22 9:14
 */
public interface CityRepository extends Repository<City, Long> {
    City findByNameAndCountryAllIgnoringCase(String name, String country);
}
