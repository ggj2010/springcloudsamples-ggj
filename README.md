#Springcloudsamples-ggj
本项目是对 https://github.com/Oreste-Luci/netflix-oss-example 项目的中文本地化，加了一些自己的理解，springcloud是个大杂烩，里面有很多东西， 从[springcloud官方文档](http://projects.spring.io/spring-cloud/spring-cloud.html)就可以看出来个大概.
>Spring Cloud 为开发者提供了在分布式系统（如配置管理、服务发现、断路器、智能路由、微代理、控制总线、一次性 Token、全局锁、决策竞选、分布式会话和集群状态）操作的开发工具。使用 Spring Cloud 开发者可以快速实现上述这些模式。

###spring-cloud版本记录

    <parent>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-parent</artifactId>
        <version></version>
    </parent>

   - Brixton.SR4 2016-08-18 commit
   - Brixton.RELEASE 2016-01-21
    
##本项目模块
    <modules>
        <module>base</module>
        <module>config-server</module>
        <module>eureka-server</module>
        <module>eureka-client-a</module>
        <module>eureka-client-b</module>
        <module>eureka-clinet-c</module>
        <module>turbine</module>
        <module>spring-cloud-dashboard</module>
        <module>zuul</module>
    </modules>
 
##模块介绍

- base
     主要就是封装一些通用的POJO
     
- config-server [文档](http://projects.spring.io/spring-cloud/spring-cloud.html#_spring_cloud_config)
     分布式配置管理。
        
- eureka-server  [文档](http://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-eureka-server)
     eureka服务端
 
 - eureka-client [文档](http://projects.spring.io/spring-cloud/spring-cloud.html#_service_discovery_eureka_clients)
     eureka客户端A、B、C.  C可以调用B和A，B可以调用A。类似于微服务直接的调用
     
 - turbine [文档](http://projects.spring.io/spring-cloud/spring-cloud.html#_turbine)
    收集微服务运行时候的信息，然后丢到kafka 或者rabbitmq
    
 -  spring-cloud-dashboard
    spring-cloud面板，显示所有注册信息
   
  - zuul [文档](http://projects.spring.io/spring-cloud/spring-cloud.html#_router_and_filter_zuul)
    路由。
    
    
    
##运行环境
- jdk8 
- 自己搭建kafka 或者rabbitmq 环境,

```
 如果使用或者kafka，请使用以下配置项,同时修改架包引用
  stream:
       kafka:
         binder:
           brokers: 123.56.118.135
           zkNodes: 123.56.118.135

 如果使用或者rabbitmq，请使用以下配置项，同时修改架包引用
 rabbitmq:
     host: localhost
     port: 5672
```
    
## 整体流程
    首先启动config-server ，然后再启动 eureka-server集群，修改端口8761、8762 启动两次，
    接着启动 eureka-client（A、B 、C 各自都启动两次验证集群用），然后就是turbine、 spring-cloud-dashboard、zuul
    
## 验证流程
    除了eureka-clientA、B 、C配置的是随机端口号，其他几个的端口号都在配置文件里面固定好的
    我们可以启动spring-cloud-dashboard 面板进行观看运行情况，http://localhost:8086/
    
    测试eureka-clientC 调用 eureka-clientB 或者eureka-clientA的 我们可以通过spring-cloud-dashboard查看到eureka-clientC 的端口号或者通过idea
    打印的日志 例如2016-08-18 14:04:21.275  INFO 2768 --- [           main] c.n.e.EurekaDiscoveryClientConfiguration : Updating port to 65026 获取到端口号
    
    
#####C调用A ： 
- 指定端口号 http://localhost:65101/processa?msg=gaogao  
 
- 通过zuul代理负载均衡 http://localhost:8765/eurekaclientC/processa?msg=gaogao 

###测试B
- http://localhost:8765/eurekaclientB/discoveryClient

###测试A
- http://localhost:8765/eurekaclientA/config1

###测试spring-cloud-config
   通用的配置文件放在 [git](https://github.com/ggj2010/springcloudsamples-config),我们可以修改某个文件内容然后验证下是否刷新了。
   spring-cloud-config 支持单个刷新也支持集群刷新。比如配置中心里面eurekaclientA.yml 这个文件里面某个配置项info.configuration值修改了，
   如果我们想让项目里面加载这个最新的配置项有如下策略
   
 - post调用 http://localhost:8765/eurekaclientA/refresh 或者 http://localhost:单个项目的端口号/refresh spring会对注解了@RefreshScope自动刷新bean
 
        但是有时候我们修改配置文件可能涉及到多个项目 比如eurekaclientA.yml、eurekaclientB.yml、eurekaclientC.yml 
        按照上面的策略就比较麻烦了
 
 - post调用  http://localhost:8888/bus/refresh   
 
         运用spirng-cloud-bus 这个功能，每个项目启动的时候都往kafka或者mq里面订阅一个topic,当执行bus/refresh 会往所有订阅了改topic的eureka客户端推送变更信息 
    
 ###测试熔断
    微服务之间因为可以相互调用，如果某个微服务挂了，会导致相关联的也都直接挂了，这是熔断和容错就起作用了。
    代码里面加了 @HystrixCommand的方法就是容错时候调用的方法。 比如C调用A的时候  A服务是挂了，那么返回的就是容错的数据。
    
 ###测试turbine
 - 执行 http://localhost:8086/，点击Circuit breakers按钮就可以看到turbine收集到所有eureka客户端的执行信息了
    
 ###测试zuul
 - 上面步骤已有
 
 ### 测试spring-cloud-dashboard
 - 执行 http://localhost:8086/

    
     
    
    
    
    
    
    
    
    
    
     
        
