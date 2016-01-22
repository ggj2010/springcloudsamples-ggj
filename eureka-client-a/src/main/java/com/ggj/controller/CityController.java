package com.ggj.controller;

import com.ggj.bean.City;
import com.ggj.service.CityService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/21 15:29
 */
@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    /**
     * rest风格
     * @param name
     * @param country
     * @return
     */
    @RequestMapping(value = "getcountryrest/{name}/{country}")
    public City getCityRest(@PathVariable String name,@PathVariable String country){
        return cityService.getCity(name,country);
    }

    @HystrixCommand
    @RequestMapping(value = "getcountry")
    public City getCity(@RequestParam(defaultValue ="Brisbane",value = "name",required = true) String name, @RequestParam(defaultValue ="Australia",value = "country",required = true) String country){
        return cityService.getCity(name,country);
    }

}
