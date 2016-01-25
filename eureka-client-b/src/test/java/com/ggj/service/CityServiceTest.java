package com.ggj.service;

import com.ggj.ClientApplication;
import com.ggj.bean.City;
import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/23 16:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ClientApplication.class)
public class CityServiceTest {
    @Autowired
    private CityService cityService;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void testGetCity()  {
        City city= cityService.getCity(1);
        assertTrue("执行出错！"+city.getName(),"beijin".equals(city.getName()));
    }

    @Test
    public void testInsert() {
        City city=new City("shanghai","SH");
        cityService.insert(city);
    }

    @Test(expected =NumberFormatException.class)
//    @Test
    public void testTransation()  {
//        thrown.expect(NumberFormatException.class);
//        thrown.expectMessage("转换异常 Integer.parseInt(\"d\");");
        cityService.transation();
    }
}