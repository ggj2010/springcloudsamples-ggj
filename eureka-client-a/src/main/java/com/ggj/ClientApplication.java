package com.ggj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/21 14:32
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//注解声明断路器
//@EnableCircuitBreaker
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class);
    }

}
