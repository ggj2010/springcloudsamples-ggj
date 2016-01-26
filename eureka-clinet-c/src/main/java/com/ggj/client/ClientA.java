package com.ggj.client;

import com.ggj.bean.Message;
import com.ggj.common.FeignService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/26 10:51
 */
@FeignClient(FeignService.CLIENT_SERVICE_A)
public interface ClientA {
    @RequestMapping(value = "message?message={message}",method= RequestMethod.GET)
    public Message processMessage(@PathVariable (value = "message") String message);

}
