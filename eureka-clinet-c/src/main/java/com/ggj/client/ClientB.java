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
@FeignClient(FeignService.CLIENT_SERVICE_B)
public interface ClientB {
    @RequestMapping(value = "processmsg?msg={msg}",method= RequestMethod.GET)
    public Message processMessage(@PathVariable(value = "msg") String msg);
}
