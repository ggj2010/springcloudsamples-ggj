package com.ggj.service;

import com.ggj.bean.Message;
import com.ggj.client.ClientA;
import com.ggj.client.ClientB;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/26 18:00
 */
@Component
public class BaseService {

    @Autowired
    private ClientA clienta;

    @Autowired
    private ClientB clientb;

    @HystrixCommand(fallbackMethod = "fallbackProcessMessageA")
    public Message processMessageA(String msg) {
        return clienta.processMessage(msg);
    }

    /**
     * 当clienta 挂了的时候调用fallbackProcessMessageA
     * @param msg
     * @return
     */
    private Message fallbackProcessMessageA(String msg){
        Message message=  new Message();
        message.setMessage(msg+"===容错fallbackProcessMessageAAAAAAA");
        return message;
    }


    @HystrixCommand(fallbackMethod = "fallbackProcessMessageB")
    public Message processMessageB(String msg) {
        return clientb.processMessage(msg);
    }

    /**
     * 当clientb 挂了的时候调用fallbackProcessMessageb
     * @param msg
     * @return
     */
    private Message fallbackProcessMessageB(String msg){
        Message message=  new Message();
        message.setMessage(msg+"===容错fallbackProcessMessageBBBBBBBB");
        return message;
    }
}
