package com.ggj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/22 13:22
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//注解声明断路器
//@EnableCircuitBreaker
//扫描mybatis接口
@MapperScan("com.ggj.dao.*")
//扫描所有可以远程调用的client
@EnableFeignClients("com.ggj.client.*")
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class);
    }

}
