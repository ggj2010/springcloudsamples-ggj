package com.ggj.controller;

import com.ggj.bean.Message;
import com.ggj.client.ClientA;
import com.ggj.client.ClientB;
import com.ggj.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/26 9:47
 */
@RestController
@Slf4j
public class BaseController {


    @Autowired
    private BaseService baseService;


    private AtomicInteger atomicInteger=new AtomicInteger();

    @RequestMapping(value = "processa")
    public Message processMsga(@RequestParam(defaultValue = "default-client-c")String msg){
        log.info(atomicInteger.incrementAndGet()+":"+"processMsga被调用");
        return baseService.processMessageA(msg);
    }

    @RequestMapping(value = "processb")
    public Message processMsgb(@RequestParam(defaultValue = "default-client-c")String msg){
        log.info(atomicInteger.incrementAndGet()+":"+"processMsgb被调用");
        return baseService.processMessageB(msg);
    }

}
