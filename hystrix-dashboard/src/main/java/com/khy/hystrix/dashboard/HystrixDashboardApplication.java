package com.khy.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 *
 * http://localhost:1301/hystrix
 *
 * 不需要在注册中心注册
 * hystrix控制面板
 *
 * 加上@EnableHystrixDashboard，启用Hystrix Dashboard功能。
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}
}
