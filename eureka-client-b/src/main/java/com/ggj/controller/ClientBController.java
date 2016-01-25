package com.ggj.controller;

import com.ggj.bean.City;
import com.ggj.bean.Message;
import com.ggj.clientservice.DiscoveryClientService;
import com.ggj.clientservice.FeignClientAService;
import com.ggj.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/25 10:35
 */
@RestController
@Slf4j
public class ClientBController {
    @Autowired
    private CityService cityService;

    @Autowired
    private FeignClientAService feignClientAService;

    @Autowired
    private DiscoveryClientService discoveryClientService;

    /**
     * 获取client-a  param
     * @param id
     * @return
     */
    @RequestMapping(value = "getcity")
    public City getCity(@RequestParam int id) {
        City city = cityService.getCity(id);
        return feignClientAService.getCity(city);
    }

    /**
     * 获取client-a  rest
     * @param id
     * @return
     */
    @RequestMapping(value = "getcityrest")
    public City getCityRest(@RequestParam int id) {
        City city = cityService.getCity(id);
        return feignClientAService.getCityRest(city);
    }

    /**
     * 获取client-a  bean 方式参数
     * @return
     */
    @RequestMapping(value = "processmsg")
    public Message processMsg(@RequestParam (defaultValue = "default-client-b")String msg) {
        return feignClientAService.processMessage(msg);
    }

    @RequestMapping(value = "discoveryClient")
    public List<String> discoveryClient() {
        return discoveryClientService.discoveryClient();
    }


}
