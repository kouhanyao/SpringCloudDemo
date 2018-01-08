package com.khy.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 当git文件更改的时候，通过pc端用post 向端口为2001的config-client发送请求http://localhost:2001/bus/refresh,该服务配置文件则更新；
 * 当结合了rabbitMQ后,此时2001端口会发送一个消息，由消息总线向其他服务传递，从而使整个微服务集群都达到更新配置文件。
 *
 *
 * 不需要在注册中心注册
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${info.profile}")
	String info;

//	@Value("${info.location}")
	String location;

	@RequestMapping(value = "/index")
	public String hi(){
		return "and remote info.profile is "+ info + " and location is "+ location;
	}
}
