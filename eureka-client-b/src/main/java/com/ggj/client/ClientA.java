package com.ggj.client;

import com.ggj.bean.City;
import com.ggj.bean.Message;
import com.ggj.common.FeignService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * author:gaoguangjin
 * Description:@PathVariable (value = "") value不能省,方法的参数不能是Bean
 * Email:335424093@qq.com
 * Date 2016/1/25 9:59
 */
//名称唯一，必须要和eureka-client-a项目 bootstrap.yml配置文件里面一直
@FeignClient(FeignService.CLIENT_SERVICE_A)
public interface ClientA {

    @RequestMapping(value = "getcountryrest/{name}/{country}",method= RequestMethod.GET)
    public City getCityRest(@PathVariable (value = "name")String name,@PathVariable (value = "country")String country);

    @RequestMapping(value = "getcountry?name={name}&country={country}",method= RequestMethod.GET)
    public City getCity(@PathVariable (value = "name")String name,@PathVariable (value = "country")String country);

    /**
     * 传递一个bean
     * @param message
     * @return
     */
    @RequestMapping(value = "message?message={message}",method= RequestMethod.GET)
    public Message processMessage(@PathVariable (value = "message") String message);

    //这个是错误写法，如果需要传递bean 可以将bean转成json
//    @RequestMapping(value = "message?message={message}",method= RequestMethod.GET)
//    public Message processMessage(Message message);
}
