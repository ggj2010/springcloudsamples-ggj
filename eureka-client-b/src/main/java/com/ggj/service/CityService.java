package com.ggj.service;

import com.ggj.bean.City;
import com.ggj.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/23 15:57
 */
@Service
@Transactional(readOnly = true)
public class CityService {
    @Autowired
    private CityDao cityDao;

   public  City getCity(int id){
       return  cityDao.getCity(id);
   }

    @Transactional(readOnly = false)
    public void insert(City city){
        cityDao.insert(city);
    }

    /**
     * 测试事务
     */
    @Transactional(readOnly = false)
    public void transation(){
        City city=new City("shanghai","SH");
        cityDao.insert(city);
        Integer.parseInt("d");
    }

}
