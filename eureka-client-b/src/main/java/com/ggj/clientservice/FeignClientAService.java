package com.ggj.clientservice;

import com.ggj.bean.City;
import com.ggj.bean.Message;
import com.ggj.client.ClientA;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/25 10:59
 */
@Component("feignClientAService")
public class FeignClientAService {
    @Autowired
    private ClientA clientA;


    @HystrixCommand(fallbackMethod = "fallGetCity")
    public City getCity(City city) {
        return clientA.getCity(city.getName(), city.getCountry());
    }

    public City fallGetCity(City city) {
        return new City("beijin-容错返回数据fallGetCity", "china-容错返回数据fallGetCity");
    }

    /**
     * 远程调用rest
     *
     * @param city
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallGetCityRest")
    public City getCityRest(City city) {
        return clientA.getCityRest(city.getName(), city.getCountry());
    }

    public City fallGetCityRest(City city) {
        return new City("beijin-容错返回数据fallGetCityRest", "china-容错返回数据fallGetCityRest");
    }

    @HystrixCommand(fallbackMethod = "fallProcessMessage")
    public Message processMessage(String msg) {
        Message message = new Message();
        message.setMessage(msg);
        return clientA.processMessage(msg);
    }

    public Message fallProcessMessage(String msg) {
        Message message = new Message();
        message.setMessage("容错返回数据fallProcessMessage");
        return message;
    }
}
