package com.khy.eureka.consumer.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    RestTemplate restTemplate;

    /**
     * 因为Spring Cloud Ribbon有一个拦截器，能在实际调用的时候自动的选择服务实例,
     * 通过服务实例的IP和端口号替换这里的服务名
     *
     * @return
     */
    @GetMapping("/index")
    @ResponseBody
    public String index() {
        String url = "http://eureka-client" + "/index?name=khy";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
