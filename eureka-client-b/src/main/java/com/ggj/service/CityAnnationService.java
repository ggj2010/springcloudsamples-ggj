package com.ggj.service;

import com.ggj.bean.City;
import com.ggj.dao.CityAnnationDao;
import com.ggj.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/25 9:52
 */
@Service
@Transactional(readOnly = true)
public class CityAnnationService {

    @Autowired
    private CityAnnationDao cityAnnationDao;

    public City getCity(int id){
        return  cityAnnationDao.getCity(id);
    }

    @Transactional(readOnly = false)
    public void insert(City city){
        cityAnnationDao.insert(city);
    }


}
