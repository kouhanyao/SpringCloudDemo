package com.khy.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 寇含尧 on 2018/1/2.
 */
@Controller
public class IndexController {
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    /**
     * 可以看到这里，我们注入了LoadBalancerClient和RestTemplate，
     * 并在/consumer接口的实现中，先通过loadBalancerClient的choose函数
     * 来负载均衡的选出一个eureka-client的服务实例，
     * 这个服务实例的基本信息存储在ServiceInstance中，
     * 然后通过这些对象中的信息拼接出访问/index接口的详细地址，最后再利用RestTemplate对象实现对服务提供者接口的调用。
     * @return
     */
    @GetMapping("/index")
    @ResponseBody
    public String index() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort()  + "/index?name=khy";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
