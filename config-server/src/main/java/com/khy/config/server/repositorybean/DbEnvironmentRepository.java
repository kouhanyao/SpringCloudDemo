package com.khy.config.server.repositorybean;

import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.cloud.config.server.environment.PassthruEnvironmentRepository;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * bean 配置
 * 参考文档:http://www.60kb.com/post/22.html
 */
public class DbEnvironmentRepository implements EnvironmentRepository {
    private final static String DEFAULT_VERSION = "1";
    private String version = DEFAULT_VERSION;
    public DbEnvironmentRepository() {
    }

    @Override
    public Environment findOne(String application, String profile, String label) {
        if (StringUtils.isEmpty(application) || StringUtils.isEmpty(profile))
            return null;
//        return new Environment(application, profile);
        ConfigurableEnvironment environment = getEnvironment(profile);
        return fillEnviroment(new PassthruEnvironmentRepository(environment).findOne(application,
                profile, label));
    }

    private ConfigurableEnvironment getEnvironment(String profile) {
        ConfigurableEnvironment environment = new StandardEnvironment();
        environment.getPropertySources()
                .addFirst(new MapPropertySource("profiles",
                        Collections.<String, Object>singletonMap("spring.profiles.active",
                                profile)));
        return environment;
    }

    private Environment fillEnviroment(Environment value){
        Environment environment = new Environment(value.getName(), value.getProfiles(),
                value.getLabel(), this.version, value.getState());
        environment.addAll(value.getPropertySources());
        Map<String,String> map = new HashMap<>();
        map.put("aa","bb");
        map.put("cc","dd");
        environment.add(new PropertySource("three are bean configuration",map));
        return environment;
    }
}
