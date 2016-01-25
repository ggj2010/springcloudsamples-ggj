package com.ggj.clientservice;

import com.ggj.common.FeignService;
import com.google.common.util.concurrent.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用DiscoveryClient 来显示客户端
 */
@Component
@Slf4j
public class DiscoveryClientService {

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<String> discoveryClient() {
        ArrayList<String> list = new ArrayList<>();
        discoveryClient.getInstances(FeignService.CLIENT_SERVICE_A).forEach((ServiceInstance s) -> {
            String name = s.getServiceId() + " - " + s.getUri().toString();
           log.info("客户端名称："+name);
            list.add(name);
        });
        return list;
    }
}
