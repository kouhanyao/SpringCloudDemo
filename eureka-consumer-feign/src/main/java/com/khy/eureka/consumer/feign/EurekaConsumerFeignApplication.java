package com.khy.eureka.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 通过Feign去消费服务.
 * Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
 *
 * 通过@EnableFeignClients注解开启扫描Spring Cloud Feign客户端的功能：
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class EurekaConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerFeignApplication.class, args);
	}
}
