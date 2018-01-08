package com.khy.eureka.consumer.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 通过RestTemplate + Ribbon去消费服务
 *
 *
 * Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具。
 * 它是一个基于HTTP和TCP的客户端负载均衡器。
 * 它可以通过在客户端中配置ribbonServerList来设置服务端列表去轮询访问以达到均衡负载的作用。
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConsumerRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerRibbonApplication.class, args);
	}

	/**
	 * 初始化RestTemplate，用来真正发起REST请求
	 *
	 * LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
