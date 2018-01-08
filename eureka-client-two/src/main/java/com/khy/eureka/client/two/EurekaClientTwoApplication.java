package com.khy.eureka.client.two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 创建“服务提供方”
 *
 * 通过注解@EnableEurekaClient 表明自己是一个eurekaclient.
 * 该注解能激活Eureka中的DiscoveryClient实现
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientTwoApplication.class, args);
	}
}
