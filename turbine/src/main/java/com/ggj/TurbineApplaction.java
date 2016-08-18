package com.ggj;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.cloud.netflix.turbine.stream.TurbineApplication;

/**
 * author:gaoguangjin
 * Description:turbine 是用来收集所有微服务service的信息，然后在Hystrix Dashboard上面进行展示,turbine使用rabbitmq从service读取信息，同时创建/turbine.stram节点
 *service层如果让turbing可以收集到信息 需要配置@EnableCircuitBreaker 同时方法上面加上 注解@HystrixCommand. 都会被监控到
 * url:https://github.com/Oreste-Luci/netflix-oss-example/tree/master/turbine
 * Email:335424093@qq.com
 * Date 2016/1/26 16:05
 */

@SpringBootApplication
@EnableAutoConfiguration
//老版本的EnableTurbineAmqp不能用了
// @EnableTurbineAmqp
@EnableTurbineStream
//@EnableDiscoveryClient
@EnableEurekaClient
public class TurbineApplaction {
    public static void main(String[] args) {
        new SpringApplicationBuilder(TurbineApplication.class).run(args);
    }
}
