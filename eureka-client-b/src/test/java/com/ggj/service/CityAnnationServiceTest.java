package com.ggj.service;

import com.ggj.ClientApplication;
import com.ggj.bean.City;
import com.ggj.dao.CityAnnationDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/25 9:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ClientApplication.class)
public class CityAnnationServiceTest {
    @Autowired
    private CityAnnationService cityAnnationService;

    @Test
    public void testGetCity() throws Exception {
        City city=cityAnnationService.getCity(1);
        assertTrue("执行出错！"+city.getName(),"beijin".equals(city.getName()));
    }

    @Test
    public void testInsert() throws Exception {
        City city=new City("shanghai-annation","SH-annation");
        cityAnnationService.insert(city);
    }
}