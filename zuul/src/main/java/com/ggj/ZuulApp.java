package com.ggj;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

/**
 * @author Oreste Luci
 */
@SpringBootApplication
@Controller
@EnableZuulProxy
//Zuul 是提供动态路由，监控，弹性，安全等的边缘服务。Zuul 相当于是设备和 Netflix 流应用的 Web 网站后端所有请求的前门。Zuul 可以适当的对多个 Amazon Auto Scaling Groups 进行路由请求
public class ZuulApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApp.class).web(true).run(args);
    }
}
