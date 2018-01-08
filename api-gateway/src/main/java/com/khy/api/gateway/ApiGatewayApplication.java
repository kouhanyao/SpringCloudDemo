package com.khy.api.gateway;

import com.khy.api.gateway.filter.ErrorFilter;
import com.khy.api.gateway.filter.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 通过zuul构建服务网关,具备服务路由、均衡负载功能之外，它还具备了权限控制等功能
 *
 * Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如／api/user转发到到user服务，/api/shop转发到到shop服务。zuul默认和Ribbon结合实现了负载均衡的功能。
 *
 *
 * 通过构建服务网关,可以对所有内部服务提供一个统一的对外入口，同时对于服务的路由都会自动创建
 * 例如,自动创建的路由举例如下:
 		转发到eureka-client服务的请求规则为：/eureka-client/**
 		转发到eureka-consumer服务的请求规则为：/eureka-consumer/**
 */
@SpringCloudApplication
@EnableZuulProxy
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public MyFilter myFilter() {
		return new MyFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
}
