package com.khy.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 通过@EnableDiscoveryClient向服务中心注册
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}

	/**
	 * 初始化RestTemplate，用来真正发起REST请求
	 * @return
     */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
