package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @Autowired
    private DiscoveryClient client;

    @GetMapping("hello")
    public String home() {
        ServiceInstance instance = client.getLocalServiceInstance();
        System.out.println("serviceId"+instance.getServiceId()+"host:post="+instance.getHost()+":"+instance.getPort());
        return "hello spring";
    }
}
