package com.khy.config.server;

import com.khy.config.server.repositorybean.DbEnvironmentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * 不需要在注册中心注册
 *
 * 加上@EnableConfigServer注解开启服务端配置的功能
 *
 * Spring Cloud Config实现的配置中心默认采用Git来存储配置信息
 *
 * Vault是安全访问秘密的工具。一个秘密是你想要严格控制访问的任何东西，如API密钥，密码，证书等等。
 * Vault为任何秘密提供统一的界面，同时提供严格的访问控制和记录详细的审核日志。
 *
 *
 * 认证授权Spring Security OAuth2
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ConfigServerApplication.class, args);
	}

	@Profile({"db"})
	@Bean
	public DbEnvironmentRepository nativeEnvironmentRepository() {
		return new DbEnvironmentRepository();
	}
}
