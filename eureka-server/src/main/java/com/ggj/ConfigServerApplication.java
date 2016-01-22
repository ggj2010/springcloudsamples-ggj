package com.ggj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * author:gaoguangjin
 * Description:服务注册和发现 服务端eureka
 * Email:335424093@qq.com
 * Date 2016/1/21 11:07
 */
@SpringBootApplication
//注解声明这是eureka服务端
@EnableEurekaServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class);
    }
}
