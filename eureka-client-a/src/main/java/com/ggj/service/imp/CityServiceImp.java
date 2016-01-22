package com.ggj.service.imp;

import com.ggj.bean.City;
import com.ggj.dao.CityRepository;
import com.ggj.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/22 9:13
 */
@Service
@Transactional(readOnly = true)
public class CityServiceImp implements CityService{
    @Autowired
    private CityRepository cityRepository;

    @Override
    public City getCity(String name, String country) {
        return  cityRepository.findByNameAndCountryAllIgnoringCase(name,country);
    }
}
