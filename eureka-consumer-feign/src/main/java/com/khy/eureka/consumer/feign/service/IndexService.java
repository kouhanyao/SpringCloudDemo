package com.khy.eureka.consumer.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 寇含尧 on 2018/1/2.
 */

/**
 * 创建一个Feign的客户端接口定义。
 * 使用@FeignClient注解来指定这个接口所要调用的服务名称，
 * 接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口
 */
@FeignClient("eureka-client")
public interface IndexService {
    @GetMapping("/index")
    String consumer(@RequestParam("name") String name);
}

