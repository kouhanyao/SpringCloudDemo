package com.khy.eureka.consumer.feign.controller;

import com.khy.eureka.consumer.feign.service.IndexService;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 寇含尧 on 2018/1/2.
 */
@RestController
public class IndexController {
    @Autowired
    IndexService indexService;

    @GetMapping("/index")
    public String dc() {
        String name = "khy";
        return indexService.consumer(name);
    }
}
