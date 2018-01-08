package com.khy.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 不需要在注册中心注册
 *
 * 加上@EnableConfigServer注解开启服务端配置的功能
 *
 * Spring Cloud Config实现的配置中心默认采用Git来存储配置信息
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
