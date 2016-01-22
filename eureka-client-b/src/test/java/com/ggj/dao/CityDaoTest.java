package com.ggj.dao;

import com.ggj.ClientApplication;
import com.ggj.bean.City;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/22 15:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ClientApplication.class)
public class CityDaoTest {
    @Autowired
    private CityDao cityDao;

    @Test
    public void testGetCity() throws Exception {
       City city=cityDao.getCity(1);
        assertTrue("执行出错！"+city.getName(),city.getName()=="beijin");
    }
}