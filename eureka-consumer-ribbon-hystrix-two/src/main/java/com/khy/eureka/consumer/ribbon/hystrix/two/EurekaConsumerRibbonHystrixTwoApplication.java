package com.khy.eureka.consumer.ribbon.hystrix.two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 通过RestTemplate + Ribbon去消费服务
 * Spring Cloud Hystrix实现依赖隔离,服务降级,断路器.目的是通过控制那些访问远程系统、服务和第三方库的节点，从而对延迟和故障提供更强大的容错能力
 * 使用@EnableCircuitBreaker或@EnableHystrix注解开启Hystrix的使用
 *
 *
 * Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具。
 * 它是一个基于HTTP和TCP的客户端负载均衡器。
 * 它可以通过在客户端中配置ribbonServerList来设置服务端列表去轮询访问以达到均衡负载的作用。
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class EurekaConsumerRibbonHystrixTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerRibbonHystrixTwoApplication.class, args);
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
