package com.ggj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:gaoguangjin
 * Description:用于测试参数刷新
 * Email:335424093@qq.com
 * Date 2016/1/21 15:29
 */
@RestController
//可以自动刷新参数 环境变量刷新
@RefreshScope
public class TestConfigController {

    @Value("${info.configuration:默认值}")
    private String configuration;

    @Value("${info.defaultmessage:默认值}")
    private String defaultMessage;

    /*配置里面没有这个值*/
    @Value("${info.nullmessage:默认值nullmessage}")
    String nullInfo;

    /**
     * application.properties和eurekaclientA.yml都包含改key
     * @return
     */
    @RequestMapping(value = "config1")
    public String getConfiguration(){
        return "info.configuration="+configuration+"/r/n  application.properties的值会被eurekaclientA.yml取代";
    }

    /**
     * eurekaclientA.yml和eurekaclientA-localprofile.yml文件都含有key=info.defaultmessage  修改bootstayp.yml里面的profile值来进行校验对比
     * @return
     */
    @RequestMapping(value = "config2")
    public String getDefaultMessage(){
        return "info.defaultmessage="+defaultMessage;
    }

    /**
     * 测试读取配置项里面没有的值 info.nullmessage
     * @return
     */
    @RequestMapping(value = "config3")
    public String testConfigThree(){
        return "info.nullmessage="+nullInfo;
    }

}
