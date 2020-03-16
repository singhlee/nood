package org.nood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @program: nood
 * @description: 认证服务启动类
 * @author: singhlee
 * @create: 2020-03-11 15:42
 **/
@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.nood.auth.repository")
public class AuthApplication  {
    public static void main( String[] args )
    {
        SpringApplication.run(AuthApplication.class, args);

    }
}
