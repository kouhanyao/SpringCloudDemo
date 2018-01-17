package com.khy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * http://localhost:1001/
 * 创建“服务注册中心”
 *
 *  启动一个服务注册中心，只需要一个注解@EnableEurekaServer，提供给其他应用进行对话
 *  这个注解需要在springboot工程的启动application类上加
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
